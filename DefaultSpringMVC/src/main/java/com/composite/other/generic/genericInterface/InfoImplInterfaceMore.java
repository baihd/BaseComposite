package com.composite.other.generic.genericInterface;

public class InfoImplInterfaceMore<T, K, U> implements Info<U> {
    private U var;
    private T x;
    private K y;

    public InfoImplInterfaceMore(U var){
        this.setVar(var);
    }

    @Override
    public U getVar() {
        return this.var;
    }

    @Override
    public void setVar(U var) {
        this.var = var;
    }
}
