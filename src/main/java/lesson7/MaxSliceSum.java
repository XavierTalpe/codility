package lesson7;

public class MaxSliceSum {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] input = new int[]{3, 2, -6, 4, 0};
        int result = solution.solution(input);

        System.out.println(result);
    }

    static class Solution {

        public int solution(final int[] A) {
            int localMax = 0;
            int globalMax = -Integer.MAX_VALUE;

            final int N = A.length;
            for (int i = 0; i < N; i++) {
                localMax = Math.max(localMax + A[i], A[i]);
                globalMax = Math.max(globalMax, localMax);
            }

            return globalMax;
        }

    }

}
