package com.example.logistics.model;

public enum SizeBox {
    SMALL(10,15,6),
    MEDIUM(15,25,18),
    LARGE(35,50,30),
    XLARGE(70,102,60);

    private final Integer depth1;
    private final Integer depth2;
    private final Integer depth3;

    SizeBox(int depth1, int depth2, int depth3){
        this.depth1 = depth1;
        this.depth2 = depth2;
        this.depth3 = depth3;
    }

    public Integer getDepth1() {
        return depth1;
    }

    public Integer getDepth2() {
        return depth2;
    }

    public Integer getDepth3() {
        return depth3;
    }
}
