package lesson4;

import java.util.Comparator;
import java.util.TreeSet;

public class NumberOfDiscIntersections {

    public static void main(String[] args) {
        Solution numberOfDiscIntersections = new Solution();

        int[] input = {1, 5, 2, 1, 4, 0};
        int solution = numberOfDiscIntersections.solution(input);

        System.out.println(solution);
    }

    static class Solution {

        public int solution(int[] discs) {
            final TreeSet<Pair> solutions = new TreeSet<Pair>(new Comparator<Pair>() {
                @Override
                public int compare(Pair left, Pair right) {
                    final int lX = left.x;
                    final int lY = left.y;

                    final int rX = right.x;
                    final int rY = right.y;

                    final int deltaX = lX - rX;
                    if (deltaX == 0) {
                        return lY - rY;
                    } else {
                        return deltaX;
                    }
                }
            });

            final int nbDiscs = discs.length;
            for (int i = 0; i < nbDiscs; i++) {
                final int discRadius = discs[i];

                for (int k = i - discRadius; k <= i + discRadius; k++) {
                    if (k >= 0 && k < nbDiscs && k != i) {
                        solutions.add(new Pair(i, k));

                        if (solutions.size() > 10000000) {
                            return -1;
                        }
                    }
                }
            }

            return solutions.size();
        }

        private static final class Pair {

            private final int x;
            private final int y;

            private Pair(int x, int y) {
                if (x <= y) {
                    this.x = x;
                    this.y = y;
                } else {
                    this.x = y;
                    this.y = x;
                }
            }

        }

    }

}
