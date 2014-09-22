package lesson2;

import java.util.BitSet;

public class MissingInteger {

    public static void main( String[] args ) {
        Solution missingInteger = new Solution();

        int[] integers = { 1, 3, 6, 4, 1, 2 };
        int solution = missingInteger.solution( integers );

        System.out.println( solution );
    }

    static class Solution {

        public int solution( int[] input ) {
            final int N = input.length;
            final int minResult = 1;
            final int maxResult = Math.min( N + 1, 100000 + 1 );

            final BitSet flags = new BitSet( 17 );
            for ( final int value : input ) {
                if ( value >= minResult && value <= maxResult ) {
                    flags.set( value, true );
                }
            }

            int result = -1;
            for ( int i = 1; i <= maxResult; i++ ) {
                boolean hasValueI = flags.get( i );

                if ( !hasValueI ) {
                    result = i;
                    break;
                }
            }

            return result;
        }

    }

}
