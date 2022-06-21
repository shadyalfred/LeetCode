public class Solution
{
  public IList<IList<string>> GroupAnagrams(string[] strs)
  {
    IList<IList<string>> groups = new List<IList<string>>();
    if (strs.Length == 0)
    {
      return groups;
    }
    
    Dictionary<string, IList<string>> map = new Dictionary<string, IList<string>>();
    
    foreach (string s in strs)
    {
      var sortedString = new string(s.ToCharArray().OrderBy(x => x).ToArray());
      if (! map.ContainsKey(sortedString))
      {
        map[sortedString] = new List<string>();
      }
      map[sortedString].Add(s);
    }
    
    foreach (var group in map.Values)
    {
      groups.Add(group);
    }
    
    return groups;
  }
}