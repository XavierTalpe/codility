package lesson4;

import java.util.Arrays;

public class Triangle {

    public static void main( String[] args ) {
        Solution triangle = new Solution();

        int[] hasSolution = { 10, 2, 5, 1, 8, 20 };
        int[] hasNoSolution = { 10, 50, 5, 1 };
        int solution = triangle.solution( hasSolution );

        System.out.println( solution );
    }

    static class Solution {

        private static boolean isTriangular( long aP, long aQ, long aR ) {
            return ( aP + aQ > aR ) && ( aQ + aR > aP ) && ( aR + aP > aQ );
        }

        public int solution( int[] input ) {
            final int N = input.length;

            final int[] sortedInput = new int[ N ];
            System.arraycopy( input, 0, sortedInput, 0, N );
            Arrays.sort( sortedInput );

            int result = 0;
            for ( int i = 0; i < N - 2; i++ ) {
                int aP = sortedInput[ i ];
                int aQ = sortedInput[ i + 1 ];
                int aR = sortedInput[ i + 2 ];

                if ( isTriangular( aP, aQ, aR ) ) {
                    result = 1;
                    break;
                }
            }

            return result;
        }

    }

}
