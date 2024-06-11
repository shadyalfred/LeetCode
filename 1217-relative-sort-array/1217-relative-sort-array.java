class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        return Arrays.stream(arr1).
            boxed().
            sorted(
                (el1, el2) -> {
                    Integer i1 = findElInArr(el1, arr2);
                    Integer i2 = findElInArr(el2, arr2);
    
                    boolean el1ExistsInArr2 = i1 != -1;
                    boolean el2ExistsInArr2 = i2 != -1;
    
                    if (el1ExistsInArr2 && !el2ExistsInArr2) {
                        return -1;
                    } else if (!el1ExistsInArr2 && el2ExistsInArr2) {
                        return 1;
                    } else if (!el1ExistsInArr2 && !el2ExistsInArr2) {
                        return el1.compareTo(el2);
                    } else {
                        return i1.compareTo(i2);
                    }
                }
            ).
            mapToInt(i -> i).
            toArray();
    }

    private int findElInArr(int el, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == el) {
                return i;
            }
        }

        return -1;
    }
}