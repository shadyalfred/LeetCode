class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];

        Integer[] elCount = new Integer[1001];

        for (int el : arr2) {
            elCount[el] = 0;
        }

        int j = arr1.length - 1;

        for (int el : arr1) {
            if (elCount[el] != null) {
                elCount[el]++;
            } else {
                result[j--]= el;
            }
        }

        Arrays.sort(result, j + 1, result.length);

        j = 0;

        for (int el : arr2) {
            for (int i = 0; i < elCount[el]; i++) {
                result[j++] = el;
            }
        }

        return result;
    }
}