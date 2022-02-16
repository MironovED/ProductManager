package ru.netology.expection;

public class NotFoundExpection extends Exception {
    public NotFoundExpection(String s) {
        super(s);
    }
}
