package lesson3;

import java.util.Arrays;

public class GenomicRangeQuery {

  public static void main( String[] args ) {
    Solution genomicRangeQuery = new Solution();

    int[] queryStarts = { 2, 5, 0 };
    int[] queryEnds = { 4, 5, 6 };
    int[] solution = genomicRangeQuery.solution( "CAGCCTA", queryStarts, queryEnds );

    System.out.println( Arrays.toString( solution ) );


    queryStarts = new int[]{ 0, 0, 1 };
    queryEnds = new int[]{ 0, 1, 1 };
    solution = genomicRangeQuery.solution( "AC", queryStarts, queryEnds );

    System.out.println( Arrays.toString( solution ) );
  }

  static class Solution {

    private static int[][] getCumulativeNucleotideCount( String dnaSequence ) {
      final int nbNucleotides = dnaSequence.length();
      final int nbNucleotideTypes = 4 - 1; /*A, C, G, we skip T.*/
      final int[][] results = new int[ nbNucleotides + 1 ][ nbNucleotideTypes ];

      // The first count of nucleotides is [0, 0, 0]. Afterwards
      // nucleotide i is added to results[i + 1],
      for ( int i = 0; i < nbNucleotides; i++ ) {
        System.arraycopy( results[ i ], 0, results[ i + 1 ], 0, nbNucleotideTypes );

        char nucleotide = dnaSequence.charAt( i );
        int impactFactor = getImpactFactor( nucleotide );

        if ( impactFactor < 4 ) {
          results[ i + 1 ][ impactFactor - 1 ]++;
        }
      }

      return results;
    }

    private static int getImpactFactor( char nucleotide ) {
      switch ( nucleotide ) {
        case 'A':
          return 1;
        case 'C':
          return 2;
        case 'G':
          return 3;
        case 'T':
          return 4;
      }

      return -1;
    }

    public int[] solution( String dnaSequence, int[] queryStarts, int[] queryEnds ) {
      final int nbQueries = queryStarts.length;
      final int[] results = new int[ nbQueries ];

      final int[][] nucleotideCount = getCumulativeNucleotideCount( dnaSequence );
      final int nbNucleotideTypes = 4;

      for ( int i = 0; i < nbQueries; i++ ) {
        final int startIndex = queryStarts[ i ];
        final int endIndex = queryEnds[ i ] + 1;

        final int[] nucleotideStartCount = nucleotideCount[ startIndex ];
        final int[] nucleotideEndCount = nucleotideCount[ endIndex ];

        for ( int j = 0; j < nbNucleotideTypes; j++ ) {
          if ( j == 3 ) { // T type.
            results[ i ] = 4;
          }
          else if ( nucleotideStartCount[ j ] < nucleotideEndCount[ j ] ) {
            results[ i ] = j + 1;
            break;
          }
        }
      }

      return results;
    }

  }

}
