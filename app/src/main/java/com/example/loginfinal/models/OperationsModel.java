package com.example.loginfinal.models;

import com.example.loginfinal.interfaces.OperationsInterfaceModel;
import com.example.loginfinal.presenters.OperationsPresenter;

public class OperationsModel implements OperationsInterfaceModel {
    private int result;
    private OperationsPresenter presenter;

    public OperationsModel(OperationsPresenter operationsPresenter){
        this.presenter = operationsPresenter;
    }

    @Override
    public void add(int num1, int num2) {
        result =  num1 + num2;
        presenter.showResult(Integer.toString(result));
    }

    @Override
    public void subtract(int num1, int num2) {
        result =  num1 - num2;
        presenter.showResult(Integer.toString(result));
    }

    @Override
    public void multiply(int num1, int num2) {
        result =  num1 * num2;
        presenter.showResult(Integer.toString(result));
    }

    @Override
    public void divide(int num1, int num2) {
        result =  num1 / num2;
        presenter.showResult(Integer.toString(result));
    }

}
