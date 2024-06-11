class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Integer[] elCount = new Integer[1001];

        for (int el : arr2) {
            elCount[el] = 0;
        }

        List<Integer> res2 = new ArrayList<>(arr1.length);

        for (int el : arr1) {
            if (elCount[el] != null) {
                elCount[el]++;
            } else {
                res2.add(el);
            }
        }

        Collections.sort(res2);

        List<Integer> res1 = new ArrayList<>(arr1.length - res2.size());

        for (int el : arr2) {
            for (int i = 0; i < elCount[el]; i++) {
                res1.add(el);
            }
        }

        res1.addAll(res2);

        return res1.stream().mapToInt(Integer::intValue).toArray();
    }
}