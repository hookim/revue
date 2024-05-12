package com.ssafy.web.global;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AccessMemStorage {
    private final Map<String, TupleStorage> storage = new HashMap<>();

    public Map<String, TupleStorage> getStorage() {
        return storage;
    }

    @Override
    public String toString() {
        return "AccessMemStorage{" +
                "storage=" + storage +
                '}';
    }
}
