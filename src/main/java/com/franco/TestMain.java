package com.franco;

public class TestMain {

    public static void main(String[] args) {
        int a = 0x2c;
        System.out.println(a);
        System.out.println(a >> 2);
        int b  = 62;
        System.out.println( (b << 2 & 0xFF) >> 2);
        //  [0x2c & 0xFF]
    }
}
