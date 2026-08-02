class Solution {

    public int coinChange(int[] coins, int amount) {

        // Edge case
        if (amount == 0) {
            return 0;
        }

        // DP array
        int[] minCoinsDP = new int[amount + 1];

        // Initialize DP array
        for (int i = 1; i <= amount; i++) {
            minCoinsDP[i] = Integer.MAX_VALUE;
        }

        // Fill DP array
        for (int i = 1; i <= amount; i++) {

            // Try every coin
            for (int coin : coins) {

                if (coin <= i && minCoinsDP[i - coin] != Integer.MAX_VALUE) {

                    minCoinsDP[i] = Math.min(
                        minCoinsDP[i],
                        1 + minCoinsDP[i - coin]
                    );

                }
            }
        }

        if (minCoinsDP[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return minCoinsDP[amount];
    }
}