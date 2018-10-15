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

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.social.twitter.api.Collection;
import org.springframework.social.twitter.api.Collection.Response;
import org.springframework.social.twitter.api.Collection.Response.Timeline;
import org.springframework.social.twitter.api.Collection.Timelines;
import org.springframework.social.twitter.api.Entities;
import org.springframework.social.twitter.api.TickerSymbolEntity;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TweetExtended;
import org.springframework.social.twitter.api.TwitterProfile;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Custom Jackson deserializer for colelctions. Collections can't be simply mapped like other Twitter model objects because the JSON structure
 * varies between the collection API and the timeline API.
 * @author Steffi Wild
 */
class CollectionDeserializer extends JsonDeserializer<Collection> {

	@Override
	public Collection deserialize(final JsonParser jp, final DeserializationContext ctx) throws IOException {
		final JsonNode node = jp.readValueAs(JsonNode.class);
		if (null == node || node.isMissingNode() || node.isNull()) {
			return null;
		}
		final Collection collection = this.deserialize(node);
		jp.skipChildren();
		return collection;
	}


	public Collection deserialize(JsonNode node) throws IOException, JsonProcessingException {

		JsonNode objectsNode = node.get("objects");
		JsonNode timelinesNode = objectsNode.get("timelines");
		JsonNode tweetsNode = objectsNode.get("tweets");
		JsonNode responseNode = objectsNode.get("response");
		
		Map<String, Timelines> timelines = toTimelines(timelinesNode);
		Map<Long, Tweet> tweets = toTweets(tweetsNode);
		Response response = toResponse(responseNode);
		
		Collection collection = new Collection(timelines, tweets, response);
		
		return collection;
	}
	
	private Map<String, Timelines> toTimelines(JsonNode timelinesNode) {
		return null;
	}
	
	private Map<Long, Tweet> toTweets(JsonNode tweetsNode) {
		return null;
	}

	private Response toResponse(JsonNode responseNode) {
		return null;
	}
}
