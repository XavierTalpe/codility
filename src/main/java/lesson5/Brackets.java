package lesson5;

import java.util.ArrayDeque;
import java.util.Deque;

public class Brackets {

  public static void main( String[] args ) {
    Solution brackets = new Solution();

    int solution = brackets.solution( "(()))(" );

    System.out.println( solution );
  }

  static class Solution {

    private static boolean isOpenBracket( char aCharacter ) {
      return aCharacter == '{' || aCharacter == '(' || aCharacter == '[';
    }

    private static boolean isClosingBracket( char aCharacter ) {
      return aCharacter == '}' || aCharacter == ')' || aCharacter == ']';
    }

    private static boolean isFamily( char aOpeningBracket, char aClosingBracket ) {
      return ( aOpeningBracket == '{' && aClosingBracket == '}' ) ||
             ( aOpeningBracket == '[' && aClosingBracket == ']' ) ||
             ( aOpeningBracket == '(' && aClosingBracket == ')' );
    }

    public int solution( String input ) {
      final Deque<Character> stack = new ArrayDeque<Character>();

      boolean isProperlyFormed = true;
      for ( int i = 0; i < input.length(); i++ ) {
        char character = input.charAt( i );

        if ( isOpenBracket( character ) ) {
          stack.push( character );
        }
        else if ( isClosingBracket( character ) ) {
          Character openingBracket = stack.peek();

          if ( openingBracket == null ) {
            isProperlyFormed = false;
            break;
          }
          else if ( isFamily( openingBracket, character ) ) {
            stack.pop();
          }
          else {
            isProperlyFormed = false;
            break;
          }
        }
      }

      return stack.isEmpty() && isProperlyFormed ? 1 : 0;
    }

  }

}
