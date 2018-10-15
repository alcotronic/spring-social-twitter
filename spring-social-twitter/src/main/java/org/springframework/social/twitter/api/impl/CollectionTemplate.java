/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.twitter.api.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.social.ResourceNotFoundException;
import org.springframework.social.twitter.api.Collection;
import org.springframework.social.twitter.api.CollectionOperations;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.ListOperations;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.UserList;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Implementation of {@link ListOperations}, providing a binding to Twitter's list-oriented REST resources.
 * @author Craig Walls
 */
class CollectionTemplate extends AbstractTwitterOperations implements CollectionOperations {
	
	private final RestTemplate restTemplate;
					
	public CollectionTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser, boolean isAuthorizedForApp) {
		super(isAuthorizedForUser, isAuthorizedForApp);
		this.restTemplate = restTemplate;
	}

	
	public List<Collection> getCollections(long userId, String screenName) {
		requireEitherUserOrAppAuthorization();
		LinkedMultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("user_id", String.valueOf(userId));
		parameters.set("screen_name", String.valueOf(screenName));
		return restTemplate.getForObject(buildUri("collections/list.json",parameters), CollectionList.class);
	}
	
	@Override
	public Collection getCollection(String collectionId) {
		requireUserAuthorization();
		return restTemplate.getForObject(buildUri("collections/entries.json", "id", String.valueOf(collectionId)), Collection.class);
	}

	// private helpers

	private boolean checkListConnection(URI uri) {
		try {
			restTemplate.getForObject(uri, String.class);
			return true;
		} catch (ResourceNotFoundException e) {
			return false;
		}
	}

	private MultiValueMap<String, Object> buildListDataMap(String name,
			String description, boolean isPublic) {
		MultiValueMap<String, Object> request = new LinkedMultiValueMap<String, Object>();
		request.set("name", name);
		request.set("description", description);
		request.set("mode", isPublic ? "public" : "private");
		return request;
	}

	@SuppressWarnings("serial")
	private static class TweetList extends ArrayList<Tweet> {}
	
	@SuppressWarnings("serial")
	private static class CollectionList extends ArrayList<Collection> {}

	

}
