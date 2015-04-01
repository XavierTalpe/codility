package lesson6;

public class EquiLeader {

    public static void main(String[] args) {
        Solution equiLeader = new Solution();

        int[] input = new int[]{4, 3, 4, 4, 4, 2};
        int solution = equiLeader.solution(input);

        System.out.println(solution);
    }

    static class Solution {

        public int solution(final int[] input) {
            final int N = input.length;

            int candidate = 0;
            int candidateIndex = -1;
            int candidateOccurrences = 0;
            for (int i = 0; i < N; i++) {
                final int value = input[i];

                if (candidateOccurrences == 0) {
                    candidate = value;
                    candidateIndex = i;
                    candidateOccurrences++;
                } else if (value == candidate) {
                    candidateOccurrences++;
                } else {
                    candidateOccurrences--;
                }
            }

            candidateOccurrences = 0;
            final double minNbOccurrences = N / 2.0;
            for (int i = 0; i < input.length; i++) {
                final int value = input[i];
                if (value == candidate) {
                    candidateIndex = i;
                    candidateOccurrences++;

                    if (candidateOccurrences > minNbOccurrences) {
                        break;
                    }
                }
            }

            return candidateOccurrences > minNbOccurrences ? candidateIndex : -1;
        }

    }

}
