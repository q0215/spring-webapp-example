package com.github.q9029.webapp.controller;

import java.util.Properties;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.q9029.webapp.controller.form.SignupFormBean;

@Controller
@RequestMapping(value = "/signup")
class SignupController {

    @Autowired
    private Properties applicationProperties;

    @Resource(name = "validator")
    private Validator validator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @ModelAttribute("formBean")
    public SignupFormBean initForm() {
        SignupFormBean formBean = new SignupFormBean(applicationProperties.getProperty("view-signup"));
        return formBean;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String doGet() {
        return applicationProperties.getProperty("view-signup");
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(@ModelAttribute("formBean") @Valid SignupFormBean formBean) {
        applicationProperties.getProperty("reserved-words", null);
        return "redirect:/login";
    }

    /**
     * Returns the binding results to the previous view.
     * @param e is a {@link BindException} instance thrown
     * by {@link org.springframework.validation.DataBinder#getBindingResult()}.
     * @return the previous view.
     */
    @ExceptionHandler(BindException.class)
    final ModelAndView handleBindException(BindException e) {
        ModelAndView view = new ModelAndView(e.getTarget().toString());
        view.addAllObjects(e.getBindingResult().getModel());
        return view;
    }
}
