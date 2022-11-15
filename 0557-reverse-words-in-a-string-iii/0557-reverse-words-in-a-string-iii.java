class Solution {
    public String reverseWords(String s) {
        String rev = String.join(" ", Arrays.asList(s.split(" ")).stream().map(word -> {
            return new StringBuilder(word).reverse().toString();
        }).toList());

        return rev;
    }
}