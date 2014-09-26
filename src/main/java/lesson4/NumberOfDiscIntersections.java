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
                final long left = i - discs[i];
                final long right = i + discs[i];
                intervals[i] = new Interval(left, right);
            }

            Arrays.sort(intervals, new IntervalComparator());

            int totalNbIntersections = 0;
            for (int i = 0; i < nbDiscs; i++) {
                final Interval targetInterval = intervals[i];

                int insertIndex = Arrays.binarySearch(intervals, targetInterval, new Comparator<Interval>() {
                    @Override
                    public int compare(Interval source, Interval target) {
                        final int delta = (int) (source.left - target.right);
                        if (delta == 0 ) {
                            return 1;
                        }
                        else {
                            return delta;
                        }
                    }
                });

                if (insertIndex < 0) {
                    insertIndex = -(insertIndex + 1);
                }

                if ( i != insertIndex ) {
                    int nbIntersections = insertIndex - 1 - i;
                    totalNbIntersections += nbIntersections;
                }
            }

            return totalNbIntersections;
        }

        private static final class Interval {

            private final long left;
            private final long right;

            private Interval(long left, long right) {
                if (left <= right) {
                    this.left = left;
                    this.right = right;
                } else {
                    this.left = right;
                    this.right = left;
                }
            }

            @Override
            public String toString() {
                return "(" + left + ", " + right + ")";
            }
        }

        private static final class IntervalComparator implements Comparator<Interval> {

            @Override
            public int compare(Interval cLeft, Interval cRight) {
                final int deltaLeft = (int) (cLeft.left - cRight.left);
                if (deltaLeft == 0) {
                    return (int) (cLeft.right - cRight.right);
                } else {
                    return deltaLeft;
                }
            }

        }


    }

}
