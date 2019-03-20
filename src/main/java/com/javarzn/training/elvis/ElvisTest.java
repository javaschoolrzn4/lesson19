package com.javarzn.training.elvis;

public class ElvisTest {
    private String copiedValue;

    public String getCopiedValue() {
        return copiedValue;
    }

    public void setCopiedValue(String copiedValue) {
        this.copiedValue = copiedValue;
    }

    public void init() {
        System.out.println(getCopiedValue());
    }
}
