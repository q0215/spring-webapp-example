package q9029.app.spring.controller;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import q9029.app.spring.service.IUsersService;

/**
 * This class is a controller for user has the role user.
 *
 * <p>This is extends {@link ExceptionController} class.
 * If you throw an exception, it is controlled by {@link ExceptionController}.
 *
 * @author q9029
 * @see ExceptionController
 * @see IUsersService
 * @see HttpServletRequest
 * @see HttpSession
 */
@Controller
@RequestMapping(value = "/{id:[a-z0-9]{4,10}}")
class AccountController {

    @Autowired
    private Properties applicationProperties;

    @Autowired
    IUsersService service;

    /**
     * hasRole('ROLE_USER')
     *
     * @param locale
     * @param model
     * @return user.jsp
     */
    @RequestMapping(method = RequestMethod.GET)
    String doGet(HttpServletRequest request, HttpSession session, @PathVariable String id) {
        request.setAttribute("user", service.getUserInfo(id));
        return applicationProperties.getProperty("view-user");
    }
}
