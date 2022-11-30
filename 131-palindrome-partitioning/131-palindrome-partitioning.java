public class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> partitions = new ArrayList<List<String>>();

        if (s.equals("")) {
            partitions.add(new ArrayList<String>());
            return partitions;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i + 1)) {
                for (List<String> list : partition(s.substring(i + 1))) {
                    list.add(0, s.substring(0, i + 1));
                    partitions.add(list);
                }
            }
        }

        return partitions;
    }

    public boolean isPalindrome(String s, int n) {
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) return false;
        }

        return true;
    }
}