package com.javarzn.core.common;

public class ScanParameters {
    private long size;
    private long byteOffset;
    private String sizeType;

    public ScanParameters(String size, long byteOffset, String sizeType) {
        this.size = Long.valueOf(size);
        this.byteOffset = byteOffset;
        this.sizeType = sizeType;
    }

    public long getSize() {
        return size;
    }

    public long getByteOffset() {
        return byteOffset;
    }

    public String getSizeType() {
        return sizeType;
    }

    public long getTargetSize() {
        return size * byteOffset;
    }


}
