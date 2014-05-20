package lesson2;

import java.util.BitSet;

public class PermCheck {

  public static void main( String[] args ) {
    Solution permCheck = new Solution();

    final int N = 100000;
    final int[] largeInput = new int[ N ];
    for ( int i = 0; i < N; i++ ) {
      largeInput[ i ] = i + 1;
    }

    int solution = permCheck.solution( largeInput );

    System.out.println( solution );
  }

  static class Solution {

    public int solution( int[] input ) {
      final int N = input.length;
      final BitSet counter = new BitSet( N );

      boolean isPermutation = true;
      for ( int element : input ) {
        if ( element == 0 || element > N ) {
          isPermutation = false;
          break;
        }

        final int index = element - 1;
        final boolean hasOccurred = counter.get( index );

        if ( hasOccurred ) {
          isPermutation = false;
          break;
        }
        else {
          counter.set( index );
        }
      }

      for ( int i = 0; i < N; i++ ) {
        if ( !counter.get( i ) ) {
          isPermutation = false;
          break;
        }
      }

      return isPermutation ? 1 : 0;
    }

  }

}
