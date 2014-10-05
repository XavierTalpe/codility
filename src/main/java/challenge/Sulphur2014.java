package challenge;

import java.util.ArrayList;
import java.util.List;

public class Sulphur2014 {

    public static void main( String[] args ) {
        Solution sulphur = new Solution();

        int[] a1 = new int[]{ 5, 3, 6, 3, 3 };
        int[] b1 = new int[]{ 2, 3, 1, 1, 2 };
        int[] c1 = new int[]{ -1, 0, -1, 0, 3 };

        int[] a2 = new int[]{ 4, 3, 1 };
        int[] b2 = new int[]{ 2, 2, 1 };
        int[] c2 = new int[]{ -1, 0, 1 };

        int[] a3 = new int[]{ 7, 9, 5, 8, 8, 6, 8, 5, 10, 6 };
        int[] b3 = new int[]{ 3, 3, 2, 4, 1, 3, 3, 4, 1, 5 };
        int[] c3 = new int[]{ -1, -1, 0, -1, 3, 1, 2, 4, -1, -1 };

        int solution = sulphur.solution( a3, b3, c3 );

        System.out.println( solution );
    }

    static class Solution {

        public int solution( int[] durabilities, int[] weights, int[] attachPoints ) {
            final int N = durabilities.length;

            final Rope[] indexToRope = new Rope[ N + 1 ];
            indexToRope[ N ] = new Rope( Integer.MAX_VALUE, 0 );

            int nbRopesAdded = 0;
            for ( int i = 0; i < N; i++ ) {
                final int durability = durabilities[ i ];
                final int weight = weights[ i ];
                final int attachPoint = attachPoints[ i ];

                if ( weight > durability ) {
                    break;
                }

                final Rope rope = new Rope( durability, weight );
                indexToRope[ i ] = rope;

                Rope ropeToAttach;
                if ( attachPoint == -1 ) {
                    ropeToAttach = indexToRope[ N ];
                }
                else {
                    ropeToAttach = indexToRope[ attachPoint ];
                }

                if ( ropeToAttach.canAddChild( rope ) ) {
                    ropeToAttach.addChild( rope );
                    nbRopesAdded++;
                }
                else {
                    break;
                }
            }

            return nbRopesAdded;
        }


        private static final class Rope {

            private final int durability;
            private final int weight;
            private final List<Rope> children;
            private Rope parent;

            public Rope( int durability, int weight ) {
                this.durability = durability;
                this.weight = weight;

                children = new ArrayList<Rope>();
            }

            public boolean canAddChild( Rope rope ) {
                int totalWeight = getTotalWeight();

                if ( totalWeight + rope.weight > durability ) {
                    return false;
                }
                else {
                    return parent == null ? true : parent.canAddChild( rope );
                }
            }

            public void addChild( Rope rope ) {
                rope.parent = this;
                children.add( rope );
            }

            public int getTotalWeight() {
                int totalWeight = weight;
                for ( Rope child : children ) {
                    totalWeight += child.getTotalWeight();
                }

                return totalWeight;
            }
        }

    }

}
