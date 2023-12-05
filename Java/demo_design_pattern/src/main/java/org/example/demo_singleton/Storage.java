package org.example.demo_singleton;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static volatile Storage instance = null;
    private static final Object lock = new Object();
    private List<Person> personList;

    private Storage() {
        personList = new ArrayList<>();
    }

    public static Storage getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new Storage();
            }
        }
        return instance;
    }

    public List<Person> getPersonList() {
        return personList;
    }
}
