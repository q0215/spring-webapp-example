package com.github.q9029.webapp.controller;

import java.security.Principal;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.q9029.webapp.service.UsersService;

@Controller
@RequestMapping(value = "/")
class IndexController {

    @Autowired
    private Properties applicationProperties;

    @Autowired
    UsersService service;

    @RequestMapping(method = RequestMethod.GET)
    String doGet(HttpServletRequest request, Principal principal) {
    	request.setAttribute("user", service.getUserInfo(principal.getName()));
        return applicationProperties.getProperty("view-index");
    }
}
