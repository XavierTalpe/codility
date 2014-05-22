package lesson2;

import java.util.Arrays;

public class MaxCounters {

  public static void main( String[] args ) {
    Solution frogJmp = new Solution();

    int[] history = { 3, 4, 4, 6, 1, 4, 4 };
    int solution[] = frogJmp.solution( 5, history );

    System.out.println( Arrays.toString( solution ) );
  }

  static class Solution {

    public int[] solution( final int nbCounters, final int[] history ) {
      final int[] counters = new int[ nbCounters ];
      final int setMaxValueFlag = nbCounters + 1;

      int maxValue = 0;
      int minValue = 0;

      for ( int counterToIncrement : history ) {
        if ( counterToIncrement == setMaxValueFlag ) {
          minValue = maxValue;
        }
        else {
          final int counterIndex = counterToIncrement - 1;
          final int counterValue = counters[ counterIndex ];

          if ( counterValue < minValue ) {
            counters[ counterIndex ] = minValue + 1;
          }
          else {
            counters[ counterIndex ]++;
          }

          maxValue = Math.max( maxValue, counters[ counterIndex ] );
        }
      }

      for ( int i = 0; i < nbCounters; i++ ) {
        counters[ i ] = Math.max( counters[ i ], minValue );
      }

      return counters;
    }

  }

}
