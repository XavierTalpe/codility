package lesson9;

import java.util.Arrays;
import java.util.BitSet;

public class CountSemiPrimes {

    public static void main( String[] args ) {
        Solution solution = new Solution();

        int[] P = new int[]{ 1, 4, 16 };
        int[] Q = new int[]{ 26, 10, 20 };
        int[] result = solution.solution( 1, P, Q );

        System.out.println( Arrays.toString( result ) );
    }

    static class Solution {

        public int[] solution( final int maxSemiPrimeValue, final int[] P, final int[] Q ) {
            final int[] primes = computeAllPrimesUntil( maxSemiPrimeValue / 2 );

            final int nbQueries = P.length;
            final int[] result = new int[ nbQueries ];
            for ( int i = 0; i < nbQueries; i++ ) {
                result[ i ] = computeNumberOfSemiPrimesInRange( primes, P[ i ], Q[ i ] );
            }

            return result;
        }

        private int[] computeAllPrimesUntil( final int N ) {
            final BitSet bitSet = new BitSet( N );
            bitSet.set( 0 ); // 1, set = not prime.

            final int maxFactor = ( int ) Math.sqrt( N );
            for ( int i = 2; i <= maxFactor; i++ ) {
                int bitIndex = i - 1;

                if ( !bitSet.get( bitIndex ) ) { // Prime
                    for ( int j = i * 2; j <= N; j += i ) {
                        bitIndex = j - 1;
                        bitSet.set( bitIndex );
                    }
                }
            }

            final int nbPrimes = Math.max( N - bitSet.cardinality(), 0 );
            final int[] allPrimes = new int[ nbPrimes ];
            for ( int i = 2, primeIndex = 0; i <= N; i++ ) {
                final int bitIndex = i - 1;

                if ( !bitSet.get( bitIndex ) ) { // Not set = prime.
                    allPrimes[ primeIndex++ ] = i;
                }
            }

            return allPrimes;
        }

        private int computeNumberOfSemiPrimesInRange( final int[] primes, final int minBound, final int maxBound ) {
            int nbSemiPrimes = 0;

            final int nbPrimes = primes.length;
            for ( int i = 0; i < nbPrimes; i++ ) {
                for ( int j = i; j < nbPrimes; j++ ) {
                    final int product = primes[ i ] * primes[ j ];
                    if ( product >= minBound && product <= maxBound ) {
                        nbSemiPrimes++;
                    }
                }
            }

            return nbSemiPrimes;
        }

    }

}
