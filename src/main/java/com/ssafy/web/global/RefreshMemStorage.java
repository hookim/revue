package com.ssafy.web.global;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RefreshMemStorage {
    private final Map<String, TupleStorage> storage = new HashMap<>();

    public Map<String, TupleStorage> getStorage() {
        return storage;
    }

}
