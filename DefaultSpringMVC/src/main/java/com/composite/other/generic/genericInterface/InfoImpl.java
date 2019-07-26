package com.composite.other.generic.genericInterface;

public class InfoImpl implements Info<String> {
    private String var;

    public InfoImpl(String var){
        this.setVar(var);
    }

    @Override
    public String getVar() {
        return this.var;
    }

    @Override
    public void setVar(String var) {
        this.var = var;
    }
}
