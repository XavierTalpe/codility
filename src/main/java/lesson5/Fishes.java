package lesson5;

import java.util.Deque;
import java.util.LinkedList;

public class Fishes {

    public static void main(String[] args) {
        Solution fish = new Solution();

//        int[] sizes = {4, 3, 2, 1, 5};
//        int[] directions = {0, 1, 0, 0, 0};
        int[] sizes = {3, 4};
        int[] directions = {1, 0};
        int solution = fish.solution(sizes, directions);

        System.out.println(solution);
    }

    static class Solution {

        private static final int UPSTREAM = 0;
        private static final int DOWNSTREAM = 1;

        public int solution(final int[] sizes, final int[] directions) {
            final Deque<Fish> stack = new LinkedList<Fish>();

            final int N = sizes.length;
            for (int i = 0; i < N; i++) {
                final Fish downstreamFish = new Fish(sizes[i], directions[i]);

                while (!stack.isEmpty()) {
                    final Fish upstreamFish = stack.peek();
                    if (upstreamFish.direction == DOWNSTREAM && downstreamFish.direction == UPSTREAM) {
                        if (upstreamFish.size < downstreamFish.size) {
                            stack.pop(); // Upstream fish eaten.
                        } else if (upstreamFish.size == downstreamFish.size) {
                            stack.push(downstreamFish);
                            break;
                        }
                        else {
                            break; // Downstream fish eaten.
                        }
                    }
                    else { // Fish can never meet.
                        stack.push(downstreamFish);
                        break;
                    }
                }

                if (stack.isEmpty()) {
                    stack.push(downstreamFish);
                }
            }

            return stack.size();
        }

        private static final class Fish {


            private final int size;
            private final int direction;

            private Fish(int size, int direction) {
                this.size = size;
                this.direction = direction;
            }

        }

    }

}
