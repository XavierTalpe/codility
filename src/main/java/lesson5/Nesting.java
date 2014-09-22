package lesson5;

import java.util.Deque;
import java.util.LinkedList;

public class Nesting {

    public static void main( String[] args ) {
        Solution nesting = new Solution();

        String isNested = "(()(())())";
        String isNotNested = "())";

        int solution = nesting.solution( isNested );

        System.out.println( solution );
    }

    static class Solution {

        public int solution( String input ) {
            final Deque<Character> stack = new LinkedList<Character>();
            final int nbChars = input.length();
            for ( int i = 0; i < nbChars; i++ ) {
                final char c = input.charAt( i );

                if ( c == '(' ) {
                    stack.push( c );
                }
                else if ( c == ')' ) {
                    if ( stack.isEmpty() ) {
                        return 0;
                    }
                    else {
                        stack.pop();
                    }
                }
            }

            return stack.isEmpty() ? 1 : 0;
        }

    }

}
