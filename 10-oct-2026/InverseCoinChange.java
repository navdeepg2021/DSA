class Solution {
  public List<Integer> findCoins(int[] numWays) {
    int m = nums.length;
    int[] dp = new int[nums.length];
    dp[0] = 1;
    for(int i = 0; i < m; i++){
      dp[i+1] = numWays[i];
    }
    List<Integer> res = new ArrayList();
    for(int i = 1; i <= m; i++) {
      if(dp[i] > 1) return new ArrayList();
      if(dp[i] == 0) continue;
      res.add(i);
      for(int j = m; j >= i; j--) {
          dp[j] -= dp[j-i]; 
          if(dp[j] < 0) return new ArrayList();
      }
    }
    return res;
  }
}
