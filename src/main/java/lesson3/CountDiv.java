package lesson3;

public class CountDiv {

  public static void main( String[] args ) {
    Solution countDiv = new Solution();

    int solution = countDiv.solution( 6, 11, 2 );

    System.out.println( solution );
  }

  static class Solution {

    public int solution( int A, int B, int K ) {
      int lowestMultipleOfK;
      if ( A % K == 0 ) {
        lowestMultipleOfK = A;
      }
      else {
        lowestMultipleOfK = A + ( K - ( A % K ) );
      }

      if ( lowestMultipleOfK <= B ) {
        return 1 + ( B - lowestMultipleOfK ) / K;
      }
      else {
        return 0;
      }
    }

  }

}
