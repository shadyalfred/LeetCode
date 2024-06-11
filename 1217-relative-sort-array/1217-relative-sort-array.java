class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Integer[] elCount = new Integer[1001];

        for (int el : arr2) {
            elCount[el] = 0;
        }

        List<Integer> endEls = new ArrayList<>(arr1.length);

        for (int el : arr1) {
            if (elCount[el] != null) {
                elCount[el]++;
            } else {
                endEls.add(el);
            }
        }

        Collections.sort(endEls);

        int j = 0;

        for (int el : arr2) {
            for (int i = 0; i < elCount[el]; i++) {
                arr1[j++] = el;
            }
        }

        for (int el : endEls) {
            arr1[j++] = el;
        }

        return arr1;
    }
}