class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> leftSideCities = new HashSet<>();
        Set<String> rightSideCities = new HashSet<>();

        for (List<String> path : paths) {
            String leftCity = path.get(0);
            String rightCity = path.get(1);

            leftSideCities.add(leftCity);
            rightSideCities.add(rightCity);
        }

        for (String city : rightSideCities) {
            if (!leftSideCities.contains(city)) {
                return city;
            }
        }

        return "";
    }
}