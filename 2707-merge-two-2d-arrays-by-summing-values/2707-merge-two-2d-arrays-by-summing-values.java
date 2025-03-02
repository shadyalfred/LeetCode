class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> res = new ArrayList<>(nums1.length + nums2.length);

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                res.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                res.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            } else if (nums2[j][0] < nums1[i][0]) {
                res.add(new int[]{nums2[j][0], nums2[j][1]});
                j++;
            }
        }

        while (i < nums1.length) {
            res.add(new int[]{nums1[i][0], nums1[i][1]});
            i++;
        }

        while (j < nums2.length) {
            res.add(new int[]{nums2[j][0], nums2[j][1]});
            j++;
        }

        return res.toArray(new int[0][]);
    }
}