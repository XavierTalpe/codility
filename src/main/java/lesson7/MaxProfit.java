package lesson7;

public class MaxProfit {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] input = new int[]{23171, 21011, 21123, 21366, 21013, 21367};
        int result = solution.solution(input);

        System.out.println(result);
    }

    static class Solution {

        public int solution(final int[] stockPrices) {
            int localMaxProfit = 0;
            int globalMaxProfit = -Integer.MAX_VALUE;

            final int N = stockPrices.length;
            for (int i = 1; i < N; i++) {
                final int dailyProfit = stockPrices[i] - stockPrices[i - 1];

                localMaxProfit = Math.max(localMaxProfit + dailyProfit, 0);
                globalMaxProfit = Math.max(globalMaxProfit, localMaxProfit);
            }

            return globalMaxProfit;
        }

    }

}
