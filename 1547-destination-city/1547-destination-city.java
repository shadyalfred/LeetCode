class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> leftSideCities = new HashSet<>();

        for (List<String> path : paths) {
            String leftCity = path.get(0);

            leftSideCities.add(leftCity);
        }

        for (List<String> path : paths) {
            String rightCity = path.get(1);

            if (!leftSideCities.contains(rightCity)) {
                return rightCity;
            }
        }

        return "";
    }
}