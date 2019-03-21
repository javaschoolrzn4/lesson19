package com.javarzn.training.spel.elvis;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElvisTest {
    private String copiedValue;

    public void init() {
        System.out.println(getCopiedValue());
    }
}
