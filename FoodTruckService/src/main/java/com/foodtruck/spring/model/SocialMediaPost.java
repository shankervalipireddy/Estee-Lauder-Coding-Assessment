package com.foodtruck.spring.model;

public class SocialMediaPost {
	private String platform;
	private String content;
	private String imageUrl;

	public SocialMediaPost(String platform, String content, String imageUrl) {
		this.platform = platform;
		this.content = content;
		this.imageUrl = imageUrl;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "SocialMediaPost{" + "platform='" + platform + '\'' + ", content='" + content + '\'' + ", imageUrl='"
				+ imageUrl + '\'' + '}';
	}
}
