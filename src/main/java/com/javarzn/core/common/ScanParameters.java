package com.javarzn.core.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScanParameters {
    private long size;
    private long byteOffset;
    private String sizeType;

    public long getTargetSize() {
        return size * byteOffset;
    }
}
