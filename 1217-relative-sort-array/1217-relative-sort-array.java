class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] indexOf = new int[1001] ;
        Arrays.fill(indexOf, -1);
        
        for (int i = 0; i < arr2.length; i++) {
            indexOf[arr2[i]] = i;
        }

        return Arrays.stream(arr1).
            boxed().
            sorted(
                (el1, el2) -> {
                    Integer i1 = indexOf[el1];
                    Integer i2 = indexOf[el2];
    
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
}