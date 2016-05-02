package com.github.q9029.webapp.controller;

import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.q9029.webapp.controller.form.AccountsManageFormBean;
import com.github.q9029.webapp.service.IUsersService;

/**
 * 管理者画面コントローラー
 *
 * @author q9029
 */
@Controller
@RequestMapping(value = "/accountsmanager")
class AccountsManageController {

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
    AccountsManageFormBean initForm() {
        AccountsManageFormBean formBean = new AccountsManageFormBean(applicationProperties.getProperty("view-admin"));
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
    String doGet(HttpServletRequest request, @ModelAttribute("formBean") AccountsManageFormBean formBean) {
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
    String doPost() {
        return applicationProperties.getProperty("view-admin");
    }
}
