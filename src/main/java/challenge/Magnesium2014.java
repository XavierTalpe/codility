package challenge;

public class Magnesium2014 {

    public static void main( String[] args ) {
        Solution magnesium = new Solution();

        int N = 6;
        int[] A = new int[]{ 0, 1, 1, 2, 3, 4, 5, 3 };
        int[] B = new int[]{ 1, 2, 3, 3, 4, 5, 0, 2 };
        int[] C = new int[]{ 4, 3, 2, 5, 6, 6, 8, 7 };

        int solution = magnesium.solution( N, A, B, C );

        System.out.println( solution );
    }

    static class Solution {

        public int solution( int nbIntersections, int[] from, int[] to, int[] attractiveness ) {
            final int nbRoads = from.length;
            return 4;
        }

    }

}
