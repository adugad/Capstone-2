import java.util.Scanner;

/**
 * Tests objects of the Matrix class.
 * 
 * @author Annika Dugad 
 * @version 4/24/2015
 */
public class MatrixTester
{
    /**
     * The main method that tests the Matrix class.
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows in the matrix: ");
        int rows = 0;
        if(in.hasNextInt())
        {
            rows = in.nextInt();
        }
        System.out.println("Enter the number of columns in the matrix: ");
        int cols = 0;
        if(in.hasNextInt())
        {
            cols = in.nextInt();
        }

        double[][] matVals = new double[rows][cols];

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                int wRow = i+1;
                int wCol = j+1;
                System.out.println("Enter the value in row #" + wRow + " and column #" + wCol + ": ");
                if(in.hasNextDouble())
                {
                    matVals[i][j] = in.nextDouble();
                }
            }
        }

        Matrix matrix = new Matrix(matVals);

        System.out.println("Here is your matrix:\n" + matrix + "\n");

        if(matVals.length == matVals[0].length)
        {
            double det = matrix.getDet(matrix.getMatrix());

            System.out.println("Here is the determinant of your matrix: " + det);

            double trace = matrix.trace();

            System.out.println("Here is the trace of your matrix: " + trace + "\n");

            if(det != 0)
            {
                Matrix inverse = new Matrix(matrix.getInv());

                System.out.println(inverse);
            }
        }

        Matrix transpose = new Matrix(matrix.transpose());

        System.out.println("Here is your matrix transposed:\n" + transpose + "\n");

    }

}