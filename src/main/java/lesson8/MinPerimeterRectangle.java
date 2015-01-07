package lesson8;

public class MinPerimeterRectangle {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result = solution.solution(30);

        System.out.println(result);
    }

    static class Solution {

        public int solution(final int area) {
            final int maxFactor = (int) Math.floor(Math.sqrt(area));

            int minPerimeter = Integer.MAX_VALUE;
            for (int i = 1; i <= maxFactor; i++) {
                if (area % i == 0) {
                    int A = i;
                    int B = area / i;

                    minPerimeter = Math.min(minPerimeter, 2 * (A + B));
                }
            }

            return minPerimeter;
        }

    }

}
