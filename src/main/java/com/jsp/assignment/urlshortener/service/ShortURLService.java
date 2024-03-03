package com.jsp.assignment.urlshortener.service;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.assignment.urlshortener.entity.ShortURL;
import com.jsp.assignment.urlshortener.entity.User;
import com.jsp.assignment.urlshortener.repository.ShortUrlRepository;

@Service
public class ShortURLService {
	@Autowired
	private ShortUrlRepository repository;

	public ModelAndView createShortUrl(HttpSession httpSession, String url) {
		User user =  (User) httpSession.getAttribute("user");

		if (user == null)
			return new ModelAndView("/user/login.jsp");

		if (url != null) {
			try {
				String key = generateShortUrl();
				ShortURL shortURL = new ShortURL();
				shortURL.setUrl(url);
				shortURL.setShortURLKey(key);
				shortURL.setUser(user);

				repository.saveURL(shortURL);
				return new ModelAndView("/user/dashboard.jsp", "shortURL", "http://localhost:8080/UrlShortener/" + key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView("/user/dashboard.jsp");
	}

	public String generateShortUrl() {
		String base = UUID.randomUUID().toString();
		Random random = new Random();

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			builder.append(base.charAt(random.nextInt(base.length())));
		}
		return builder.toString();
	}

	public ModelAndView getAnalytics(HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) httpSession.getAttribute("user");
		if (user != null)
			modelAndView.setViewName("/user/login.jsp");

		List<ShortURL> urls = new ShortUrlRepository().findAllShortURLByUser(user);
		if (urls != null && !urls.isEmpty()) {
			modelAndView.addObject("urls", urls);
			modelAndView.setViewName("/user/analytics.jsp");
		}
		return modelAndView;
	}

	public ModelAndView deleteShortUrl(HttpSession httpSession, int urlId) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) httpSession.getAttribute("user");
		if (user == null)
			modelAndView.setViewName("/user/login.jsp");

		ShortURL url = repository.findShortUrlByById(urlId);
		if (url != null) {
			repository.deleteURL(url);
		}

		modelAndView.addObject("urls", repository.findAllShortURLByUser(user));
		modelAndView.setViewName("user/analytics.jsp");

		return modelAndView;
	}

	public void redirectUrl(String key, HttpServletResponse resp) throws IOException {

		ShortURL shortURL = repository.findUrlByShortURLKey(key);
		if (shortURL != null) {
			shortURL.setClickCount(shortURL.getClickCount() + 1);
			repository.updateURL(shortURL);
		}
		resp.sendRedirect(shortURL.getUrl());
	}
}
