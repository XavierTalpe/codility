package lesson1;

public class TapeEquilibrium {

  public static void main( String[] args ) {
    int[] A = new int[]{ 3, 1, 2, 4, 3 };

    Solution tapeEquilibrium = new Solution();
    int solution = tapeEquilibrium.solution( A );
    System.out.println( solution );
  }

  static class Solution {

    public int solution( int[] aInput ) {
      long totalSum = sum( aInput );

      long leftSide = 0;
      long rightSide = totalSum;
      int minDifference = Integer.MAX_VALUE;

      for ( int i = 0; i < aInput.length - 1; i++ ) {
        leftSide += aInput[ i ];
        rightSide -= aInput[ i ];

        int currentDifference = ( int ) Math.abs( leftSide - rightSide );
        if ( currentDifference < minDifference ) {
          minDifference = currentDifference;
        }
      }

      return minDifference;
    }

    private static long sum( int[] aInput ) {
      long sum = 0;

      for ( int number : aInput ) {
        sum += number;
      }

      return sum;
    }

  }

}
