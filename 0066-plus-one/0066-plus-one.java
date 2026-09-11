class Solution {
  public int[] plusOne(int[] digits) {
    int n = digits.length;
    boolean carry = true;
    for (int i = n - 1; i >= 0; i--) {
        if (carry) {
            if (digits[i] < 9) {
                digits[i]++;
                carry = false;
            } else {
                digits[i] = 0;
            }
        }
    }

    if (carry) {
        int[] newDigits = new int[n + 1];
        System.arraycopy(digits, 0, newDigits, 1, n);
        newDigits[0] = 1;
        return newDigits;
    }
      
    return digits;
  }
}