public class Solution
{
  public int Change(int amount, int[] coins)
  {
    int[] combinations = new int[amount + 1];
    
    combinations[0] = 1;
    
    foreach (int coin in coins)
    {
      for (int i = coin; i <= amount; i++)
      {
        combinations[i] += combinations[i - coin];
      }
    }

    return combinations[amount];
  }
}