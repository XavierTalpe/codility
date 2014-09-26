package lesson4;

import java.util.Arrays;
import java.util.Comparator;

public class NumberOfDiscIntersections {

    public static void main(String[] args) {
        Solution numberOfDiscIntersections = new Solution();

        int[] input = {1, 5, 2, 1, 4, 0};
        int solution = numberOfDiscIntersections.solution(input);

        System.out.println(solution);
    }

    static class Solution {

        public int solution(int[] discs) {
            final int nbDiscs = discs.length;
            final Interval[] intervals = new Interval[nbDiscs];

            for (int i = 0; i < nbDiscs; i++) {
                final int left = i - discs[i];
                final int right = i + discs[i];
                intervals[i] = new Interval(left, right);
            }

            Arrays.sort(intervals, new IntervalComparator());

            int totalNbIntersections = 0;
            for (int i = 0; i < nbDiscs; i++) {
                final Interval interval = intervals[i];
                final int targetRight = interval.right;

                int nbIntersections = 0;
                int k = i + 1;
                boolean intersecting = true;
                while (intersecting && k < nbDiscs) {
                    Interval sourceInterval = intervals[k];
                    if (sourceInterval.left > targetRight) {
                        intersecting = false;
                    } else {
                        k++;
                        nbIntersections++;
                    }
                }

                totalNbIntersections += nbIntersections;
            }

            return totalNbIntersections;
        }

        private static final class Interval {

            private final int left;
            private final int right;

            private Interval(int left, int right) {
                if (left <= right) {
                    this.left = left;
                    this.right = right;
                } else {
                    this.left = right;
                    this.right = left;
                }
            }

        }

        private static final class IntervalComparator implements Comparator<Interval> {

            @Override
            public int compare(Interval cLeft, Interval cRight) {
                final int deltaLeft = cLeft.left - cRight.left;
                if (deltaLeft == 0) {
                    return cLeft.right - cRight.right;
                } else {
                    return deltaLeft;
                }
            }

        }

    }

}
