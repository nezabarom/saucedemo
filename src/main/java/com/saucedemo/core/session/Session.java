package com.saucedemo.core.session;

import java.util.*;

import static java.util.Objects.isNull;

public class Session extends HashMap<SessionKey, Object> {

    private static final ThreadLocal<Session> context = new ThreadLocal<>();

    private Session() {
    }

    public static Session session() {
        Session session = context.get();
        return isNull(session) ? init() : session;
    }

    public static Session init() {
        Session session = new Session();
        context.set(session);
        return session;
    }

    public static void destroy() {
        context.remove();
    }

    public static <T> T getSessionValue(SessionKey key, Class<T> type) {
        try{
            return session().get(key, type);
        }
        catch (RuntimeException e){
            throw new IllegalArgumentException("Variable: " + key + " doesn't exist in the 'Session'");
        }
    }

    public static <T> T getSessionValue(SessionKey key, Class<T> type, T defaultValue) {
        return session().get(key, type, defaultValue);
    }

    @SuppressWarnings("unchecked")
    public static <T> T putSessionValue(SessionKey key, T value) {
        session().put(key, value);
        return value;
    }



    @SuppressWarnings("unchecked")
    private <T> T get(SessionKey key, Class<T> type) {
        if (containsKey(key)) {
            return (T) get(key);
        }
        throw new RuntimeException("Key '" + key + "' not found");
    }

    private <T> T get(SessionKey key, Class<T> type, T defaultValue) {
        if (containsKey(key)) {
            return (T) get(key);
        } else {
            return defaultValue;
        }
    }
}