package lesson1;

public class FrogJmp {

  public static void main( String[] args ) {
    Solution frogJmp = new Solution();
    int solution = frogJmp.solution( 10, 85, 30 );
    System.out.println( solution );
  }

  static class Solution {

    public int solution( int X, int Y, int D ) {
      final double distance = Y - X;
      final int minNbSteps = ( int ) Math.ceil( distance / D );

      return minNbSteps;
    }

  }

}
