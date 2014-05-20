package lesson1;

public class PermMissingElem {

  public static void main( String[] args ) {
    Solution frogJmp = new Solution();
    int solution = frogJmp.solution( new int[]{ 2, 3, 1, 5 } );
    System.out.println( solution );
  }

  static class Solution {

    public int solution( int[] input ) {
      final long N = input.length + 1;

      long cumulativeSum = N * ( N + 1 ) / 2;
      for ( int element : input ) {
        cumulativeSum -= element;
      }

      return ( int ) cumulativeSum;
    }

  }

}
