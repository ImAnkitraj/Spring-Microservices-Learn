package org.tekion;

public class Main {

    public static void main(String[] args) {
        Boolean isTrue = Boolean.valueOf("true");
        Boolean isFalse = Boolean.valueOf("false");
        System.out.println(isFalse);
        System.out.println(isTrue);
        System.out.println(isFalse == isTrue);
    }
}