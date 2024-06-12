/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int N = mountainArr.length();

        int l = 0;
        // subtract 1 to avoid out of bounds when getting the value on the right
        int r = N - 1;
        int iPeak = 0;

        // Finding the index of the peak
        while (l < r) {
            int m = (l + r) / 2;

            int left = mountainArr.get(m - 1);
            int mid = mountainArr.get(m);
            int right = mountainArr.get(m + 1);

            if (left < mid && mid < right) {
                l = m + 1;
            } else if (left > mid && mid > right) {
                r = m;
            } else {
                iPeak = m;
                break;
            }
        }
        
        l = 0;
        r = iPeak + 1;

        // BS on the left side (increasing order)
        while (l < r) {
            int m = (l + r) / 2;
            int v = mountainArr.get(m);

            if (v < target) {
                l = m + 1;
            } else if (v > target) {
                r = m;
            } else {
                return m;
            }
        }

        l = iPeak;
        r = N;

        // BS on the right side (decreasing order)
        while (l < r) {
            int m = (l + r) / 2;
            int v = mountainArr.get(m);

            if (v < target) {
                r = m;
            } else if (v > target) {
                l = m + 1;
            } else {
                return m;
            }
        }

        return -1;
    }
}