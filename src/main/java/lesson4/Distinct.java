package lesson4;

import java.util.Arrays;

public class Distinct {

  public static void main( String[] args ) {
    Solution distinct = new Solution();

    int[] input = { 2, 1, 1, 2, 3, 1 };
    int solution = distinct.solution( input );

    System.out.println( solution );
  }

  static class Solution {

    public int solution( int[] input ) {
      final int length = input.length;

      if ( length < 2 ) {
        return length;
      }

      Arrays.sort( input );

      int prevNumber = input[ 0 ];
      int nbDistinctNumbers = 1;

      for ( int i = 1; i < length; i++ ) {
        final int nextNumber = input[ i ];

        if ( prevNumber != nextNumber ) {
          nbDistinctNumbers++;
          prevNumber = nextNumber;
        }
      }

      return nbDistinctNumbers;
    }

  }

}
