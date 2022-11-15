class Solution {
    public String reverseWords(String s) {
        return String.join(" ", Arrays.asList(s.split(" ")).stream().map(word -> {
            return new StringBuilder(word).reverse().toString();
        }).toList());
    }
}