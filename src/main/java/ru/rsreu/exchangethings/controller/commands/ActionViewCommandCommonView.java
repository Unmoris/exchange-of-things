package ru.rsreu.exchangethings.controller.commands;

import ru.rsreu.exchangethings.helper.Helper;
import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

final public class ActionViewCommandCommonView extends ActionViewCommandLogger {
    public ActionViewCommandCommonView(View view, View errorView, Helper helper) {
        this.view = view;
        this.helper = helper;
        this.errorView = errorView;
    }

    public ActionViewCommandCommonView(View commonView, Helper helper) {
        this.view = commonView;
        this.helper = helper;
        this.errorView = commonView;
    }

    private View view;
    private View errorView;

    private Helper helper;


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            helper.includeParamsInScopes(request, response);
            view.show(request, response);
        } catch (IncludeParameterException e) {
            errorView.show(request, response);
        }
        super.execute(request, response);
    }
}
