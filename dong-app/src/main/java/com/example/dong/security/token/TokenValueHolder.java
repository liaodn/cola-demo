package com.example.dong.security.token;

/**
 **/
public class TokenValueHolder {

    private static ThreadLocal<String> tokens = new ThreadLocal<>();

    public static void setTokenValue(String tokenValue) {
        if (tokenValue == null) {
            tokens.remove();
        } else {
            tokens.set(tokenValue);
        }
    }

    public static void remove() {
        tokens.remove();
    }

    public static String get() {
        return tokens.get();
    }
}
