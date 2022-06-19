public class Solution {
  private Dictionary<string, int> wordCount = new Dictionary<string, int>();
  private int n;
  private int wordLength;
  private int substringSize;
  private int k;

  private void SlidingWindow(int left, string s, IList<int> answer) {
    Dictionary<string, int> wordsFound = new Dictionary<string, int>();
    int wordsUsed = 0;
    bool excessWord = false;

    // iterate word_length at a time, and at each iteration we focus on one word
    for (int right = left; right <= n - wordLength; right += wordLength) {

      string sub = s[right .. (right + wordLength)];
      if (!wordCount.ContainsKey(sub)) {
        // Mismatched word - reset the window
        wordsFound.Clear();
        wordsUsed = 0;
        excessWord = false;
        left = right + wordLength;
      } else {
        // If we reached max window size or have an excess word
        while (right - left == substringSize || excessWord) {
          string leftmostWord = s[left .. (left + wordLength)];
          left += wordLength;
          wordsFound[leftmostWord] = wordsFound[leftmostWord] - 1;

          if (wordsFound[leftmostWord] >= wordCount[leftmostWord]) {
            // This word was an excess word
            excessWord = false;
          } else {
            // Otherwise we actually needed it
            wordsUsed--;
          }
        }

        // Keep track of how many times this word occurs in the window
        wordsFound[sub] = wordsFound.GetValueOrDefault(sub, 0) + 1;
        if (wordsFound[sub] <= wordCount[sub]) {
          wordsUsed++;
        } else {
          // Found too many instances already
          excessWord = true;
        }

        if (wordsUsed == k && !excessWord) {
          // Found a valid substring
          answer.Add(left);
        }
      }
    }
  }

  public IList<int> FindSubstring(string s, string[] words) {
    n = s.Length;
    k = words.Length;
    wordLength = words[0].Length;
    substringSize = wordLength * k;

    foreach (string word in words) {
      wordCount[word] = wordCount.GetValueOrDefault(word, 0) + 1;
    }

    IList<int> answer = new List<int>();
    for (int i = 0; i < wordLength; i++) {
      SlidingWindow(i, s, answer);
    }

    return answer;
  }  
}