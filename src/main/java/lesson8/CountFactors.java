package lesson8;

public class CountFactors {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result = solution.solution(42);

        System.out.println(result);
    }

    static class Solution {

        public int solution(final int N) {
            final int maxFactor = (int) Math.floor(Math.sqrt(N));

            int nbFactors = 0;
            for (int i = 1; i <= maxFactor; i++) {
                if (N % i == 0) {
                    nbFactors++; // Always pair of factors.

                    if (N / i != i) { // 4: 1, 2, 4, don't count 2 twice.
                        nbFactors++;
                    }
                }
            }

            return nbFactors;
        }

    }

}
