package ru.job4j.map;

import java.util.*;

public class Weather {
    public static List<Info> editData(List<Info> list) {
        Map<String, Info> rainMap = new HashMap<>();
        for (Info tmpInfo : list) {
            if (rainMap.containsKey(tmpInfo.city)) {
                rainMap.get(tmpInfo.city).rainfall += tmpInfo.rainfall;
            } else {
                rainMap.put(tmpInfo.city, tmpInfo);
            }
        }
        return new ArrayList<>(rainMap.values());
    }

    public static class Info {
        private String city;

        private int rainfall;

        public Info(String city, int rainfall) {
            this.city = city;
            this.rainfall = rainfall;
        }

        public String getCity() {
            return city;
        }

        public int getRainfall() {
            return rainfall;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return rainfall == info.rainfall
                    && Objects.equals(city, info.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(city, rainfall);
        }
    }
}