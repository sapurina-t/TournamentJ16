package ru.netology.exception;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super(name);
    }
}
