package lesson3;

public class PassingCars {

  public static void main( String[] args ) {
    Solution passingCars = new Solution();

    int[] cars = { 0, 1, 0, 1, 1 };
    int solution = passingCars.solution( cars );

    System.out.println( solution );
  }

  static class Solution {

    public int solution( int[] cars ) {
      int totalNbPassingCars = 0;
      int nbPassingCars = 0;

      final int nbCars = cars.length;
      for ( int i = nbCars - 1; i >= 0; i-- ) {
        final int car = cars[ i ];

        if ( car == 1 ) {
          nbPassingCars++;
        }
        else if ( car == 0 ) {
          totalNbPassingCars += nbPassingCars;

          if ( totalNbPassingCars > 1000000000 ) {
            totalNbPassingCars = -1;
            break;
          }
        }
      }

      return totalNbPassingCars;
    }

  }

}
