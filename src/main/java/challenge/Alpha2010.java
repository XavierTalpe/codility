package challenge;

import java.util.BitSet;

public class Alpha2010 {

    public static void main(String[] args) {
        Solution alpha2010 = new Solution();

        int[] input = {2, 2, 1, 0, 1};
        int solution = alpha2010.solution(input);

        System.out.println(solution);
    }

    static class Solution {

        public int solution(final int[] input) {
            final int N = input.length;
            final BitSet bitSet = new BitSet(N);

            for (int i : input) {
                bitSet.set(i);
            }

            int firstCoveringPrefix = N - 1;
            for (int i = 0; i < N; i++) {
                final int value = input[i];
                bitSet.set(value, false);

                if (bitSet.isEmpty()) {
                    firstCoveringPrefix = i;
                    break;
                }
            }

            return firstCoveringPrefix;
        }

    }

}
