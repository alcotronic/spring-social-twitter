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
package org.springframework.social.twitter.api;

import java.util.List;

import org.springframework.social.ApiException;
import org.springframework.social.MissingAuthorizationException;


/**
 * Interface defining the operations for working with a user's lists.
 * @author Craig Walls
 * @author Steffi Wild
 */
public interface ListExtendedOperations {
	
	
	/**
	 * Retrieves the timeline tweets for the given user list.
	 * Supports either user or application authorization.
	 * @param listId the ID of the list to retrieve.
	 * @return a list of {@link Tweet} objects for the items in the user list timeline.
	 * @throws ApiException if there is an error while communicating with Twitter.
	 * @throws MissingAuthorizationException if TwitterTemplate was not created with OAuth credentials or an application access token.
	 */
	List<TweetExtended> getListStatuses(long listId);

	/**
	 * Retrieves the timeline tweets for the given user list.
	 * Supports either user or application authorization.
	 * @param listId the ID of the list to retrieve.
	 * @param pageSize The number of {@link Tweet}s per page.
	 * @return a list of {@link Tweet} objects for the items in the user list timeline.
	 * @throws ApiException if there is an error while communicating with Twitter.
	 * @throws MissingAuthorizationException if TwitterTemplate was not created with OAuth credentials or an application access token.
	 */
	List<TweetExtended> getListStatuses(long listId, int pageSize);

	/**
	 * Retrieves the timeline tweets for the given user list.
	 * Supports either user or application authorization.
	 * @param listId the ID of the list to retrieve.
	 * @param pageSize The number of {@link Tweet}s per page.
	 * @param sinceId The minimum {@link Tweet} ID to return in the results
	 * @param maxId The maximum {@link Tweet} ID to return in the results
	 * @return a list of {@link Tweet} objects for the items in the user list timeline.
	 * @throws ApiException if there is an error while communicating with Twitter.
	 * @throws MissingAuthorizationException if TwitterTemplate was not created with OAuth credentials or an application access token.
	 */
	List<TweetExtended> getListStatuses(long listId, int pageSize, long sinceId, long maxId);

	/**
	 * Retrieves the timeline tweets for the given user list.
	 * Supports either user or application authorization.
	 * @param screenName the screen name of the Twitter user.
	 * @param listSlug the list's slug.
	 * @return a list of {@link Tweet} objects for the items in the user list timeline.
	 * @throws ApiException if there is an error while communicating with Twitter.
	 * @throws MissingAuthorizationException if TwitterTemplate was not created with OAuth credentials or an application access token.
	 */
	List<TweetExtended> getListStatuses(String screenName, String listSlug);

	/**
	 * Retrieves the timeline tweets for the given user list.
	 * Supports either user or application authorization.
	 * @param screenName the screen name of the Twitter user.
	 * @param listSlug the list's slug.
	 * @param pageSize The number of {@link Tweet}s per page.
	 * @return a list of {@link Tweet} objects for the items in the user list timeline.
	 * @throws ApiException if there is an error while communicating with Twitter.
	 * @throws MissingAuthorizationException if TwitterTemplate was not created with OAuth credentials or an application access token.
	 */
	List<TweetExtended> getListStatuses(String screenName, String listSlug, int pageSize);

	/**
	 * Retrieves the timeline tweets for the given user list.
	 * Supports either user or application authorization.
	 * @param screenName the screen name of the Twitter user.
	 * @param listSlug the list's slug.
	 * @param pageSize The number of {@link Tweet}s per page.
	 * @param sinceId The minimum {@link Tweet} ID to return in the results
	 * @param maxId The maximum {@link Tweet} ID to return in the results
	 * @return a list of {@link Tweet} objects for the items in the user list timeline.
	 * @throws ApiException if there is an error while communicating with Twitter.
	 * @throws MissingAuthorizationException if TwitterTemplate was not created with OAuth credentials or an application access token.
	 */
	List<TweetExtended> getListStatuses(String screenName, String listSlug, int pageSize, long sinceId, long maxId);

}
