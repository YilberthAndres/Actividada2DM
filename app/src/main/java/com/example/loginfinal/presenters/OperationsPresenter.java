package com.example.loginfinal.presenters;


import com.example.loginfinal.home;
import com.example.loginfinal.interfaces.OperationsInterfacePresenter;
import com.example.loginfinal.models.OperationsModel;
import com.example.loginfinal.views.OperationsView;

public class OperationsPresenter implements OperationsInterfacePresenter {
    private home view;
    private OperationsModel model;

    public OperationsPresenter(home view) {
        this.view = view;
        this.model = new OperationsModel(this);
    }

    @Override
    public void showResult(String result) {
        if (view != null) {
            view.showResult(result);
        }
    }

    @Override
    public void invalidOperation() {

    }

    @Override
    public void add(int num1, int num2) {
        model.add(num1,num2);
    }

    @Override
    public void subtract(int num1, int num2) {
        model.subtract(num1,num2);
    }

    @Override
    public void multiply(int num1, int num2) {
        model.multiply (num1,num2);
    }

    @Override
    public void divide(int num1, int num2) {
        model.divide(num1,num2);
    }
}
