OVERVIEW:
This package includes two classes: Matrix and MatrixTester.  The Matrix class represents matrices
and involves methods that can create a matrix, transpose a matrix, calculuate the determinant, 
create the inverse of an invertible matrix, calculate the trace of a matrix, and multiply two 
matrices by each other.  The MatrixTester class simply tests the methods of the Matrix class.

The Matrix class includes:

    - a Matrix constructor, which places values from an array into a 2D array to represent the
      matrix
      
    - createMatrixSubset() method, which utilizes for loops to access elements of a 2D array and
      construct a new 2D array from them

    - getDet() method, which utilizes recursion to calculate the determinant of the matrix
    
    - getInv() method, which utilizes if-else and for loops to create an inverse of a matrix
    
    - transpose() method, which utilizes loops to transpose a 2D array matrix
    
    - trace() method, which utilizes loops to add values within a 2D array matrix
    
    - mult() method, which multiplies 2D array matrices by each other
    
In order to write the matrix class, research on how to code matrix methods had to be done, especially
with the getDet() and getInv() methods.
    
Pseudocode for createMatrixSubset() method:

Create a matrix subset that is one minus the length and width of the passed-in matrix.

For the first row in the matrix, if that row must be skipped, increment the row.

Else, for the first column in the matrix, if that column must be skipped, increment the column.

Else, the matrix value gets added to the matrix subset and the row and column of the matrix subset
are incremented.

Pseudocode for getDet() method:

If the matrix is a 2 by 2 matrix, calculate its determinant by multiplying its diagonal values and
subtracting them.

Else, create a matrix subset (using the createMatrixSubset() method) and run the getDet() method
on that matrix subset.

Pseudocode for getInv() method:

Using the getDet() method, calculate the determinant of the passed-in matrix.

If the determinant is not 0, and the matrix is a square, loop through each element in the matrix, 
use createMatrixSubset() method to create a matrix subset, and calculate the determinant of each 
subset.  Set the negative or positive of that value as the new value of the matrix.

IMPORTANT: In order to run this class, run the main method of the MatrixTester class.  All 
relevant instructions will be given once it is run.