package lesson3;

public class MinAvgTwoSlice {

  public static void main( String[] args ) {
    Solution minAvgTwoSlice = new Solution();

    int[] input = { 4, 2, 2, 5, 1, 5, 8 };
    int solution = minAvgTwoSlice.solution( input );

    System.out.println( solution );
  }

  static class Solution {

    public int solution( final int[] input ) {
      final int N = input.length;

      int minIndex = 0;
      double minAvg = Double.MAX_VALUE;

      for ( int i = 0; i < N - 1; i++ ) {
        double average = ( input[ i ] + input[ i + 1 ] ) / 2.0;

        if ( i < N - 2 ) {
          double threeSliceAvg = ( input[ i ] + input[ i + 1 ] + input[ i + 2 ] ) / 3.0;
          average = Math.min( average, threeSliceAvg );
        }

        if ( average < minAvg ) {
          minAvg = average;
          minIndex = i;
        }
      }

      return minIndex;
    }

  }

}
