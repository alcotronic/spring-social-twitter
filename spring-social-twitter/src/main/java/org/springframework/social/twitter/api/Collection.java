package org.springframework.social.twitter.api;

import java.util.List;
import java.util.Map;


/**
 * @author Steffi Wild
 *
 */
public class Collection extends TwitterObject {

	private final Map<String, Timelines> timelines;
	private final Map<Long, Tweet> tweets;
	private final Response response;
	
	/**
	 * @param timelines
	 * @param tweets
	 * @param response
	 */
	public Collection(Map<String, Timelines> timelines, Map<Long, Tweet> tweets,
			Response response) {
		super();
		this.timelines = timelines;
		this.tweets = tweets;
		this.response = response;
	}

	/**
	 * @return the timelines
	 */
	public Map<String, Timelines> getTimelines() {
		return timelines;
	}

	/**
	 * @return the tweets
	 */
	public Map<Long, Tweet> getTweets() {
		return tweets;
	}

	/**
	 * @return the response
	 */
	public Response getResponse() {
		return response;
	}
	
	public class Timelines extends TwitterObject {

		private final String collectionType;
		private final String collectionUrl;
		private final String descritpion;
		private final String name;
		private final String timelineOrder;
		private final String url;
		private final String userId;
		private final String visibility;
		
		/**
		 * @param collectionType
		 * @param collectionUrl
		 * @param descritpion
		 * @param name
		 * @param timelineOrder
		 * @param url
		 * @param userId
		 * @param visibility
		 */
		public Timelines(String collectionType, String collectionUrl, String descritpion, String name,
				String timelineOrder, String url, String userId, String visibility) {
			super();
			this.collectionType = collectionType;
			this.collectionUrl = collectionUrl;
			this.descritpion = descritpion;
			this.name = name;
			this.timelineOrder = timelineOrder;
			this.url = url;
			this.userId = userId;
			this.visibility = visibility;
		}

		/**
		 * @return the collectionType
		 */
		public String getCollectionType() {
			return collectionType;
		}

		/**
		 * @return the collectionUrl
		 */
		public String getCollectionUrl() {
			return collectionUrl;
		}

		/**
		 * @return the descritpion
		 */
		public String getDescritpion() {
			return descritpion;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the timelineOrder
		 */
		public String getTimelineOrder() {
			return timelineOrder;
		}

		/**
		 * @return the url
		 */
		public String getUrl() {
			return url;
		}

		/**
		 * @return the userId
		 */
		public String getUserId() {
			return userId;
		}

		/**
		 * @return the visibility
		 */
		public String getVisibility() {
			return visibility;
		}
		
	}

	public class Response {
		
		private final Position position;
		private final List<Timeline> timeline;
		private final String timelineId;
		
		
		
		/**
		 * @param position
		 * @param timeline
		 * @param timelineId
		 */
		public Response(Position position, List<Timeline> timeline, String timelineId) {
			super();
			this.position = position;
			this.timeline = timeline;
			this.timelineId = timelineId;
		}

		/**
		 * @return the position
		 */
		public Position getPosition() {
			return position;
		}

		/**
		 * @return the timeline
		 */
		public List<Timeline> getTimeline() {
			return timeline;
		}

		/**
		 * @return the timelineId
		 */
		public String getTimelineId() {
			return timelineId;
		}

		public class Position {
			
			private final Long maxPosition;
			private final Long minPosition;
			private final boolean wasTruncated;
			
			/**
			 * @param maxPosition
			 * @param minPosition
			 * @param wasTruncated
			 */
			public Position(Long maxPosition, Long minPosition, boolean wasTruncated) {
				super();
				this.maxPosition = maxPosition;
				this.minPosition = minPosition;
				this.wasTruncated = wasTruncated;
			}
			/**
			 * @return the maxPosition
			 */
			public Long getMaxPosition() {
				return maxPosition;
			}
			/**
			 * @return the minPosition
			 */
			public Long getMinPosition() {
				return minPosition;
			}
			/**
			 * @return the wasTruncated
			 */
			public boolean isWasTruncated() {
				return wasTruncated;
			}
			
		}
		
		public class Timeline {
			
			private final String featureContext;
			private final Tweet tweet;
			
			/**
			 * @param featureContext
			 * @param tweet
			 */
			public Timeline(String featureContext, Tweet tweet) {
				super();
				this.featureContext = featureContext;
				this.tweet = tweet;
			}

			/**
			 * @return the featureContext
			 */
			public String getFeatureContext() {
				return featureContext;
			}

			/**
			 * @return the tweet
			 */
			public Tweet getTweet() {
				return tweet;
			}

			public class Tweet {
				
				private final Long id;
				private final Long sortIndex;
				
				/**
				 * @param id
				 * @param sort_index
				 */
				public Tweet(Long id, Long sortIndex) {
					super();
					this.id = id;
					this.sortIndex = sortIndex;
				}

				/**
				 * @return the id
				 */
				public Long getId() {
					return id;
				}

				/**
				 * @return the sortIndex
				 */
				public Long getSortIndex() {
					return sortIndex;
				}
				
			}
			
		}
		
	}

}
