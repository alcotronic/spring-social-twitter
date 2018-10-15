/*
 * Copyright 2018 the original author or authors.
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
package org.springframework.social.twitter.api;

import java.util.List;

import org.springframework.social.ApiException;
import org.springframework.social.MissingAuthorizationException;


/**
 * Interface defining the operations for working with a collection.
 * @author Steffi Wild
 */
public interface CollectionOperations {
	
	/**
	 * Retrieves collection lists for a given user.
	 * Supports either user or application authorization.
	 * @param userId the ID of the Twitter user.
	 * @param screenName the screen name of the Twitter user.
	 * @return a list of {@link UserList}s for the specified user.
	 * @throws ApiException if there is an error while communicating with Twitter.
	 * @throws MissingAuthorizationException if TwitterTemplate was not created with OAuth credentials or an application access token.
	 */
	List<Collection> getCollections(long userId, String screenName);

	/**
	 * Retrieves a specific collection.
	 * @param collectionId the ID of the collection to retrieve.
	 * @return the requested {@link UserList}
	 * @throws ApiException if there is an error while communicating with Twitter.
	 * @throws MissingAuthorizationException if TwitterTemplate was not created with OAuth credentials.
	 */
	Collection getCollection(String collectionId);

}
