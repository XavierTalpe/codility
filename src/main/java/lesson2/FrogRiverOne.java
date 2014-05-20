package lesson2;

import java.util.BitSet;

public class FrogRiverOne {

  public static void main( String[] args ) {
    Solution frogJmp = new Solution();

    int[] leaves = { 1, 3, 1, 4, 2, 3, 5, 4 };
    int solution = frogJmp.solution( 5, leaves );

    System.out.println( solution );
  }

  static class Solution {

    public int solution( int targetPosition, int[] leaves ) {
      final BitSet leavesAvailable = new BitSet( targetPosition );

      int timeJumpedToEnd = -1;
      int nbDistinctLeavesDropped = 0;

      for ( int i = 0; i < leaves.length; i++ ) {
        final int leafPosition = leaves[ i ];
        final int leafIndex = leafPosition - 1;

        if ( !leavesAvailable.get( leafIndex ) ) {
          leavesAvailable.set( leafIndex );
          nbDistinctLeavesDropped++;

          if ( nbDistinctLeavesDropped == targetPosition ) {
            timeJumpedToEnd = i;
            break;
          }
        }
      }

      return timeJumpedToEnd;
    }

  }

}
