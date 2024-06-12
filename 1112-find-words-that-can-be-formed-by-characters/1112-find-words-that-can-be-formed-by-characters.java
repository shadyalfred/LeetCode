class Solution {
    public int countCharacters(String[] words, String chars) {
        int total = 0;

        int[] charsCount = countChars(chars);

        for (var word : words) {
            int[] wordCharsCount = countChars(word);

            if (canBeFound(wordCharsCount, charsCount)) {
                total += word.length();
            }
        }

        return total;
    }

    private int[] countChars(String word) {
        int[] charsCount = new int[26];

        for (char c : word.toCharArray()) {
            charsCount[c - 'a']++;
        }

        return charsCount;
    }

    private boolean canBeFound(int[] word, int[] chars) {
        if (word.length == 0) {
            return true;
        }

        for (int i = 0; i < chars.length; i++) {
            if (word[i] > chars[i]) {
                return false;
            }
        }

        return true;
    }
}