package com.composite.other.generic.genericInterface;

public class InfoImplInterface<T> implements Info<T> {
    private T var;

    public InfoImplInterface(T var) {
        this.setVar(var);
    }

    @Override
    public T getVar() {
        return this.var;
    }

    @Override
    public void setVar(T var) {
        this.var = var;
    }
}
