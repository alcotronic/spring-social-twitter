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

import java.util.ArrayList;
import java.util.List;

import org.springframework.social.twitter.api.ListExtendedOperations;
import org.springframework.social.twitter.api.TweetExtended;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Implementation of {@link ListExtendedOperations}, providing a binding to Twitter's list-oriented REST resources.
 * @author Craig Walls
 */
class ListExtendedTemplate extends AbstractTwitterOperations implements ListExtendedOperations {
	
	private final RestTemplate restTemplate;
					
	public ListExtendedTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser, boolean isAuthorizedForApp) {
		super(isAuthorizedForUser, isAuthorizedForApp);
		this.restTemplate = restTemplate;
	}

	public List<TweetExtended> getListStatuses(long listId) {
		return getListStatuses(listId, 20, 0, 0);
	}

	public List<TweetExtended> getListStatuses(long listId, int pageSize) {
		return getListStatuses(listId, pageSize, 0, 0);
	}

	public List<TweetExtended> getListStatuses(long listId, int pageSize, long sinceId, long maxId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> parameters = PagingUtils.buildPagingParametersWithCount(pageSize, sinceId, maxId);
		parameters.set("list_id", String.valueOf(listId));
		parameters.set("include_entities", "true");
		parameters.set("tweet_mode", "extended");
		return restTemplate.getForObject(buildUri("lists/statuses.json", parameters), TweetExtendedList.class);
	}

	public List<TweetExtended> getListStatuses(String screenName, String listSlug) {
		return getListStatuses(screenName, listSlug, 20, 0, 0);
	}

	public List<TweetExtended> getListStatuses(String screenName, String listSlug, int pageSize) {
		return getListStatuses(screenName, listSlug, pageSize, 0, 0);
	}

	public List<TweetExtended> getListStatuses(String screenName, String listSlug, int pageSize, long sinceId, long maxId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> parameters = PagingUtils.buildPagingParametersWithCount(pageSize, sinceId, maxId);
		parameters.set("owner_screen_name", screenName);
		parameters.set("slug", listSlug);
		parameters.set("include_entities", "true");
		parameters.set("tweet_mode", "extended");
		return restTemplate.getForObject(buildUri("lists/statuses.json", parameters), TweetExtendedList.class);
	}

	// private helpers
	
	@SuppressWarnings("serial")
	private static class TweetExtendedList extends ArrayList<TweetExtended> {}
	
}
