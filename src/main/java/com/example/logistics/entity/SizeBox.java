package com.example.logistics.entity;

public enum SizeBox {
    SMALL(10,15,6),
    MEDIUM(15,25,18),
    LARGE(35,50,30),
    XLARGE(70,102,60);

    SizeBox(int depth1, int depth2, int depth3){}
}
