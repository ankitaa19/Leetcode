class Solution {

    public int paintWalls(int[] cost, int[] time) {

        int n = cost.length;
        int INF = 1000000000;

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = INF;
        }

        dp[0] = 0;

        for (int i = 0; i < n; i++) {

            int[] next = dp.clone();

            for (int painted = 0; painted <= n; painted++) {

                int newPainted = Math.min(n, painted + time[i] + 1);

                next[newPainted] = Math.min(
                    next[newPainted],
                    dp[painted] + cost[i]
                );
            }

            dp = next;
        }

        return dp[n];
    }
}