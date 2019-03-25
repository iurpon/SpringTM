package ru.trandefil.spring.controller;

import ru.trandefil.spring.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class CatEditController {

    @Inject
    private UserService userService;


    private String id;


    private Category cat = new Category();

    public void init() {
        if (cat != null) this.cat = cat;
    }


    public String save() {
        return "cat-list.xhtml";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }
}
