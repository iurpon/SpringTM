package ru.trandefil.spring.controller;

import ru.trandefil.spring.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Collection;


@ViewScoped
@ManagedBean
public class CatListController {


    @Inject
    private UserService userService;

    public Collection<Category> getCatsList() {
        return null;
    }

    public void removeCatByID(String catId) {
    }

}
