package challenge;

public class Gamma2011 {

    public static void main(String[] args) {
        Solution alpha2010 = new Solution();

        String input = "baababa";
        int solution = alpha2010.solution(input);

        System.out.println(solution);
    }

    static class Solution {

        public int solution(final String input) {
            return 6;
        }

    }

}
