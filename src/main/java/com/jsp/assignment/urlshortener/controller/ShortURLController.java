package com.jsp.assignment.urlshortener.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.assignment.urlshortener.service.ShortURLService;

@Controller
public class ShortURLController {
	@Autowired
	private ShortURLService shortURLService;

	@RequestMapping(value = "/shorten-url", method = RequestMethod.POST)
	public ModelAndView createShortUrl(HttpSession httpSession,String url) throws IOException {
		return shortURLService.createShortUrl(httpSession, url);
	}
	
	@RequestMapping(value = "/get-analytics", method = RequestMethod.GET)
	public ModelAndView getAnalytics(HttpSession httpSession) throws IOException {
		return shortURLService.getAnalytics(httpSession);
	}
	
	@RequestMapping(value = "/delete-url", method = RequestMethod.POST)
	public ModelAndView deleteShortUrl(HttpSession httpSession, int urlId) throws IOException {
		return shortURLService.deleteShortUrl(httpSession, urlId);
	}
	
	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	public void redirectUrl(@PathVariable String key, HttpServletResponse resp) throws IOException {
		shortURLService.redirectUrl(key, resp);
	}

}
