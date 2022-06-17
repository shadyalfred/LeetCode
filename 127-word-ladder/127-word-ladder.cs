public class Solution {
    public int LadderLength(string beginWord, string endWord, IList<string> wordList) {
        HashSet<string> words = new HashSet<string>(wordList);
        
        HashSet<string> reached = new HashSet<string>();
        reached.Add(beginWord);
        
        int distance = 1;
        
        while (! reached.Contains(endWord))
        {
            if (reached.Count == 0)
            {
                return 0;
            }
            
            HashSet<string> neighbors = new HashSet<string>();
            
            foreach (string word in reached)
            {
                foreach (string otherWord in words)
                {
                    int count = 0;
                    for (int i = 0; i < word.Length; i++)
                    {
                        if (word[i] != otherWord[i])
                        {
                            count++;
                            if (count > 1)
                            {
                                break;
                            }
                        }
                    }
                    if (count == 1)
                    {
                        neighbors.Add(otherWord);
                        words.Remove(otherWord);
                    }
                }
            }
            
            distance++;

            reached = neighbors;
        }
        
        return distance;
    }
}