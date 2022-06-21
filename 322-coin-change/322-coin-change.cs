public class Solution {
  public int CoinChange(int[] coins, int amount)
  {
    if (coins.Length == 0)
    {
      return -1;
    }
    
    const int INF = int.MaxValue;
    
    int[] minCoins = new int[amount + 1];
    
    minCoins[0] = 0;
    
    for (int i = 1; i < minCoins.Length; i++)
    {
      minCoins[i] = INF;
      foreach (int coin in coins)
      {
        if (i - coin >= 0 && minCoins[i - coin] != INF)
        {
          minCoins[i] = Math.Min(minCoins[i], minCoins[i - coin] + 1);
        }
      }
    }
    
    return minCoins[amount] == INF ? -1 : minCoins[amount];
  }
}