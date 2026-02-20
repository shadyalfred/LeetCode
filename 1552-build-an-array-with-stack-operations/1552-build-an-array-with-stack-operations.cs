public class Solution {
  public IList<string> BuildArray(int[] target, int n) {
    var list = new List<string>();
    int j = 0;
    for (int i = 1; i <= n; i++)
    {
      if (j == target.Length)
      {
        break;
      }

      list.Add("Push");
      if (i != target[j])
      {
        list.Add("Pop");
      }
      else
      {
        j++;
      }
    }
    return list;
  }
}