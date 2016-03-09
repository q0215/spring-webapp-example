package q9029.app.spring.controller;

import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import q9029.app.spring.controller.form.RoleAdminFormBean;
import q9029.app.spring.service.IUsersService;

/**
 * 管理者画面コントローラー
 *
 * @author q9029
 */
@Controller
@RequestMapping(value = "/admin")
class RoleAdminController {

    @Autowired
    private Properties applicationProperties;

    @Autowired
    IUsersService service;

    @Resource(name = "validator")
    private Validator validator;

    @InitBinder
    void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @ModelAttribute("formBean")
    RoleAdminFormBean initForm() {
        RoleAdminFormBean formBean = new RoleAdminFormBean(applicationProperties.getProperty("view-admin"));
        return formBean;
    }

    /**
     * doGet<br>
     * hasRole('ROLE_ADMIN')
     *
     * @param formBean
     * @return 管理者画面
     */
    @RequestMapping(method = RequestMethod.GET)
    String doGet(HttpServletRequest request, HttpSession session, @ModelAttribute("formBean") RoleAdminFormBean formBean) {
        request.setAttribute("users", service.getAllUsersInfo());
        return applicationProperties.getProperty("view-admin");
    }

    /**
     * doPost<br>
     * role('ROLE_ADMIN')
     *
     * @param formBean
     * @return 管理者画面
     */
    @RequestMapping(method = RequestMethod.POST)
    String doPost(@ModelAttribute("formBean") @Valid RoleAdminFormBean formBean) {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
        formBean.setHash(encoder.encodePassword(formBean.getEncode() + "{" + applicationProperties.getProperty("salt-source") + "}", null));
        return applicationProperties.getProperty("view-admin");
    }
}
