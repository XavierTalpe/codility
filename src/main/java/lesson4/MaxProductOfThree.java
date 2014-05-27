package lesson4;

import java.util.Arrays;

public class MaxProductOfThree {

  public static void main( String[] args ) {
    Solution maxProductOfThree = new Solution();

    int[] input = { -3, 1, 2, -2, 5, 6 };
    int solution = maxProductOfThree.solution( input );

    System.out.println( solution );
  }

  static class Solution {

    public int solution( int[] input ) {
      if ( input.length == 3 ) {
        return input[ 0 ] * input[ 1 ] * input[ 2 ];
      }

      Arrays.sort( input );

      // Only two possible cases for max value.
      final int length = input.length;
      final int right = input[ length - 1 ] * input[ length - 2 ] * input[ length - 3 ];
      final int left = input[ length - 1 ] * input[ 0 ] * input[ 1 ];

      return Math.max( right, left );
    }

  }

}
