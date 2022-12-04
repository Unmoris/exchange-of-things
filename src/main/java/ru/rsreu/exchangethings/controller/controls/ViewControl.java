package ru.rsreu.exchangethings.controller.controls;

import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.view.pages.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ViewControl implements Control {

    protected Page page;
    protected Page errorPage;
    protected List<Helper> helpers = new LinkedList<>();

    private void addHelpers(Helper... helpers) {
        this.helpers.addAll(Arrays.asList(helpers));
    }

    public ViewControl(Page page, Page errorPage, Helper... helpers) {
        this.page = page;
        this.errorPage = errorPage;
        this.addHelpers(helpers);
    }


    public ViewControl(Page commonPage, Helper... helpers) {
        this.page = commonPage;
        this.errorPage = commonPage;
        this.addHelpers(helpers);
    }

    public ViewControl(Page commonPage){
        this.page = commonPage;
        this.errorPage = commonPage;
    }


    @Override
    public void control(HttpServletRequest request, HttpServletResponse response) {
        try {
            for (Helper helper : helpers) {
                helper.execute(request, response);
            }
            page.show(request, response);
        } catch (IncludeParameterException e) {
            errorPage.show(request, response);
        }
    }
}
