package com.jsp.assignment.urlshortener.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ShortURL {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int urlId;
	private String url;
	private String shortURLKey;
	private int clickCount;

	@ManyToOne
	private User user;

	public int getUrlId() {
		return urlId;
	}

	public void setUrlId(int urlId) {
		this.urlId = urlId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShortURLKey() {
		return shortURLKey;
	}

	public void setShortURLKey(String shortURLKey) {
		this.shortURLKey = shortURLKey;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

}
