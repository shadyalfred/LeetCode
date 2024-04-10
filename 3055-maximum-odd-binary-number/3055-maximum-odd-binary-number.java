class Solution {
    public String maximumOddBinaryNumber(String s) {
        int l = 0;

        char[] num = s.toCharArray();

        for (int i = 0; i < num.length; i++) {
            if (num[i] == '1') {
                swap(num, l, i);
                l++;
            }
        }

        swap(num, num.length - 1, l - 1);

        return new String(num);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}