/**
 * A class that creates objects that represent matrices.
 *  
 * @author Annika Dugad
 * @version 4/24/2015
 */
public class Matrix
{
    double[][] matrix;
    
    /**
     * Constructor for the objects of class Matrix.
     *  
     * @param   values   A 2D array that takes in double values that will be used to create the matrix
     */
    public Matrix(double[][] values)
    {
        matrix = values;
        int counter = 0;
    }

    /**
     * The method that creates a smaller matrix from a matrix by excluding a specific row and column.
     *
     * @pre     The matrix that is passed in is a square from the getDet() method.
     * @param   array  A 2D array with double values to represent a matrix
     *          skipRow The index value for the row that has to be skipped
     *          skipCol The index value for the column that has to be skipped
     * @return  Returns a 2D array representing the matrix subset.
     */
    public double[][] createMatrixSubset(double[][] array, int skipRow, int skipCol)
    {
        int newRows = array.length - 1;
        int newCols = array[0].length - 1;
        double[][] newMatrix = new double[newRows][newCols];
        int ni = 0;
        int nj = 0;
        for(int i = 0; i < array.length; i++)
        {
            if(i == skipRow)
            {
                continue;
            }
            else
            {
                nj=0;
                for(int j = 0; j < array[0].length; j++)
                {
                    if( j == skipCol)
                    {
                        continue;
                    }
                    else
                    {
                        newMatrix[ni][nj] = matrix[i][j];
                        nj++;
                    }
                }
                ni++;
            }
        }
        return newMatrix;
    }

    /**
     * The method that calculates the determinant of a matrix.
     *
     * @param   matrix  A 2D array with double values to represent a matrix
     * @return  A double value representing the determinant of the matrix
     */
    public double getDet(double[][] matrix)
    {
        double det = 0;
        double[][] array = this.matrix;
        if (array.length == array[0].length)
        {
            if(array.length == 2)
            {
                det = array[0][0]*array[1][1] - array[0][1]*array[1][0];
                return det;
            }
            else
            {
                for(int i = 0; i < 1; i++)
                {
                    for(int j = 0; j < array[0].length; j++)
                    {
                        double k = 1;
                        double[][] newMatrix = createMatrixSubset(array,i,j);
                        if((i+j)%2 != 0)
                        {
                            k = -1;
                        }
                        det += k * array[i][j] * getDet(newMatrix);
                    }
                }
            }
        }
        else
        {
            throw new ArithmeticException("Matrix is not a square.");
        }
        return det;
    }

    /**
     * The method that returns the inverse of the matrix by utilizing the determinant and the adjoint.
     *
     * @return  Returns a 2D array representing the inverse matrix.
     */
    public double[][] getInv()
    {
        double det = getDet(this.matrix);
        double[][] array = this.matrix;
        if(array.length == array[0].length || det != 0)
        {
            for(int i = 0; i < array.length; i++)
            {
                for(int j = 0; j < array[0].length; j++)
                {
                    double k = 1;
                    double[][] newMatrix = createMatrixSubset(array,i,j);
                    if((i+j)%2 != 0)
                    {
                        k = -1;
                    }
                    double value = k * getDet(newMatrix);
                    array[i][j] = value / det;
                }
            }
        }
        else if(det == 0)
        {
            throw new ArithmeticException("Matrix is not invertible.");
        }
        else if(matrix.length != matrix[0].length)
        {
            throw new ArithmeticException("Matrix is not a square.");
        }
        return array;
    }

    /**
     * The method that transposes a matrix.
     *
     * @return  Returns a 2D array representing the transposed matrix
     */
    public double[][] transpose()
    {
        int cols = matrix[0].length;
        int rows = matrix.length;
        double[][] newMatrix = new double[cols][rows];
        for(int r = 0; r < matrix.length; r++)
        {
            for(int c = 0; c < matrix[0].length; c++)
            {
                newMatrix[c][r] = matrix[r][c];
            }
        }
        return newMatrix;
    }

    /**
     * The method that calculates the trace of the matrix.
     *
     * @return  Returns a double value which represents the trace of the matrix
     */
    public double trace()
    {
        double value = 0;
        if (matrix.length == matrix[0].length)
        {
            for(int i = 0; i < matrix.length; i++)
            {
                value += matrix[i][i];
            }
            return value;
        }
        else
        {
            throw new ArithmeticException("Matrix is not a square.");
        }
    }

    /**
     * The method that multiplies two matrices with each other.
     *
     * @param   mat1    A 2D array with double values to represent a matrix
     *          mat2    A 2D array with double values to represent a matrix
     * @return  Returns a 2D array representing the multiplied matrix.
     */
    public double[][] mult(double[][] mat1, double[][] mat2)
    {
        double[][] matrix = new double[mat1.length][mat2[0].length];
        if(mat1[0].length == mat2.length)
        {
            for(int i = 0; i < mat1.length; i++)
            {
                for(int j = 0; j < mat2[0].length; j++)
                {
                    for(int k = 0; k < mat1.length; k++)
                    {
                        matrix[i][j] = mat1[i][k] * mat2[k][j];
                    }
                }
            }
            return matrix;
        }
        else
        {
            throw new ArithmeticException("Matrices cannot be multiplied together.");
        }
    }
    
    /**
     * Returns the 2D array matrix instance variable
     * 
     * @return Returns a 2D array representing the matrix.
     */
    public double[][] getMatrix()
    {
        return this.matrix;
    }
    
    /**
     * The toString() method for the Matrix class
     * 
     * @return Returns a string representing a matrix object.
     */
    public String toString()
    {
        String str = "[ ";
        for(int i = 0; i < matrix.length; i++)
        {
            if(i != 0)
            {
                str += "\n";
            }
            for(int j = 0; j < matrix[0].length; j++)
            {
                str += matrix[i][j] + " ";
            }
        }
        str += " ]";
        return str;
    }
}