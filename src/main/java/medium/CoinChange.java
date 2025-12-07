package medium;

import java.util.Arrays;
import java.util.HashMap;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return deposit(coins, amount, 0L, new HashMap<>());
    }

    private int deposit(int[] sortedCoins, int amount, long sum, HashMap<Integer, Integer> memo) {
        int remaining = (int)((long)amount - sum);
        if (remaining == 0) return 0;
        if (remaining < 0) return -1;
        if (memo.containsKey(remaining)) return memo.get(remaining);

        int min = Integer.MAX_VALUE;

        for (int coin : sortedCoins) {
            int res = deposit(sortedCoins, amount, sum + coin, memo);
            if (res >= 0) {
                min = Math.min(min, res + 1);
            }
        }

        memo.put(remaining, (min == Integer.MAX_VALUE) ? -1 : min);
        return memo.get(remaining);
    }
}
