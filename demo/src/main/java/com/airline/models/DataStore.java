package com.airline.models;

import java.util.*;

public class DataStore {
    public static Map<String, String> flights = new LinkedHashMap<>();
    public static Map<String, String> users = new LinkedHashMap<>();
    public static Map<String, String> flightTimes = new LinkedHashMap<>();
    public static Set<String> cancelledFlights = new HashSet<>();
    public static Set<String> cancelledUsers = new HashSet<>();
    public static Map<String, String> newStatus = new LinkedHashMap<>();

    static {
        flights.put("AA001", "On Time");
        flights.put("AA002", "Delayed");
        flights.put("AA003", "Cancelled");

        users.put("Lim Dun Xiang", "AA001");
        users.put("Jonathan Wong", "AA002");
        users.put("Bobby Foo", "AA003");

        flightTimes.put("AA001", "08:00 AM");
        flightTimes.put("AA002", "11:30 AM");
        flightTimes.put("AA003", "05:45 PM");

        newStatus.put("Delayed", "AA001");
        newStatus.put("Cancelled", "Delayed");
        newStatus.put("Arriving Early", "Cancelled");
    }
}

