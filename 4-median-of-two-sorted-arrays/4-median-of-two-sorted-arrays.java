class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A;
        int[] B;
        
        if (nums1.length < nums2.length) {
            A = nums1;
            B = nums2;
        } else {
            A = nums2;
            B = nums1;
        } 
        
        int total = A.length + B.length;
        
        int half = total / 2;
        
        int l = 0;
        int r = A.length - 1;
        
        while (true) {
            int i = Math.floorDiv(l + r, 2);
            int j = half - i - 2;
            
            int ALeft = (i >= 0) ? A[i] : Integer.MIN_VALUE;
            int ARight = ((i + 1) < A.length) ? A[i + 1] : Integer.MAX_VALUE;
            
            int BLeft = (j >= 0) ? B[j] : Integer.MIN_VALUE;
            int BRight = ((j + 1) < B.length) ? B[j + 1] : Integer.MAX_VALUE;
            
            if (ALeft <= BRight && BLeft <= ARight) {
                if (total % 2 == 0) {
                    return (Math.max(ALeft, BLeft) + Math.min(ARight, BRight)) / 2.0;
                }
                
                return Math.min(ARight, BRight);
                
            } else if (ALeft > BRight) {
                
                r = i - 1;
                
            } else {
                
                l = i + 1;
                
            }
        }
    }
}