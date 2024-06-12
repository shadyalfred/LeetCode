class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Set<String>> adj = new HashMap<>();
        Set<String> cities = new HashSet<>();

        for (List<String> path : paths) {
            String citySrc = path.get(0);
            String cityDst = path.get(1);

            if (! adj.containsKey(citySrc)) {
                adj.put(citySrc, new HashSet<>());
            }

            adj.get(citySrc).add(cityDst);

            cities.add(citySrc);
            cities.add(cityDst);
        }

        for (String city : cities) {
            if (!adj.containsKey(city)) {
                return city;
            }
        }

        return "";
    }
}