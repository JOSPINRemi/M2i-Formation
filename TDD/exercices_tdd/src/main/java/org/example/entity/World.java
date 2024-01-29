package org.example.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class World {
    List<String> cities;

    public World() {
        this(Arrays.asList("Budapest", "Valence", "Vancouver"));
    }

    public World(List<String> cities) {
        this.cities = cities;
    }

    public List<String> searchCities(String cityName) {
        List<String> res;
        Pattern pattern;
        Matcher matcher;
        if (cityName.equals("*")) {
            return cities;
        }
        if (cityName.length() < 2) {
            throw new RuntimeException("Le nom de la ville saisi est trop court");
        }
        res = new ArrayList<>();
        pattern = Pattern.compile(cityName, Pattern.CASE_INSENSITIVE);
        for (String city : cities) {
            matcher = pattern.matcher(city);
            if (matcher.find()) {
                res.add(city);
            }
        }
        return res;
    }
}
