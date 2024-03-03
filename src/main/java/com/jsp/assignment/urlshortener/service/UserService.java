package com.jsp.assignment.urlshortener.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.assignment.urlshortener.entity.User;
import com.jsp.assignment.urlshortener.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ModelAndView saveUser(User user) {
        ModelAndView modelAndView = new ModelAndView("/user/login.jsp");
        try {
            userRepository.saveUser(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelAndView;
    }

    public ModelAndView loginUser(HttpSession httpSession, String email, String password) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            httpSession.setAttribute("user", user);
            modelAndView.setViewName("/user/dashboard.jsp");
        } else {
            modelAndView.setViewName("/user/login.jsp");
            modelAndView.addObject("error", "Incorrect email or password. Please try again.");
        }

        return modelAndView;
    }

    public ModelAndView logoutUser(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("/user/login.jsp");
        if (httpSession.getAttribute("user") != null) {
            httpSession.removeAttribute("user");
        }
        return modelAndView;
    }
}
