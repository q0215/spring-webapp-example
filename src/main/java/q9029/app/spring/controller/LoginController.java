package q9029.app.spring.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
class LoginController {

    @Autowired
    private Properties applicationProperties;

    @RequestMapping(method = RequestMethod.GET)
    String doGet() {
        return applicationProperties.getProperty("view-login");
    }
}
