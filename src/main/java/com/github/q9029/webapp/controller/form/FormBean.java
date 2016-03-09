package com.github.q9029.webapp.controller.form;

abstract class FormBean {

    private final String view;

    public FormBean(String view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return this.view;
    }
}
