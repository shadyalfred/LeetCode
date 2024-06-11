class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> elCountMap = new HashMap<>();

        for (int el : arr2) {
            elCountMap.put(el, 0);
        }

        List<Integer> res2 = new ArrayList<>();

        for (int el : arr1) {
            if (elCountMap.containsKey(el)) {
                elCountMap.put(el, elCountMap.get(el) + 1);
            } else {
                res2.add(el);
            }
        }

        Collections.sort(res2);

        List<Integer> res1 = new ArrayList<>();

        for (int el : arr2) {
            for (int i = 0; i < elCountMap.get(el); i++) {
                res1.add(el);
            }
        }

        res1.addAll(res2);

        return res1.stream().mapToInt(Integer::intValue).toArray();
    }
}