/**
Q2. Black Shapes

Problem Description

Given character matrix A of O's and X's, where O = white, X = black.

Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)



Problem Constraints

1 <= |A|,|A[0]| <= 1000

A[i][j] = 'X' or 'O'



Input Format

The First and only argument is character matrix A.



Output Format

Return a single integer denoting number of black shapes.



Example Input

Input 1:

 A = [ [X, X, X], [X, X, X], [X, X, X] ]
Input 2:

 A = [ [X, O], [O, X] ]


Example Output

Output 1:

 1
Output 2:

 2


Example Explanation

Explanation 1:

 All X's belong to single shapes
Explanation 2:

 Both X's belong to different shapes

*/

package Graph1;

class BlackShapes {

	int[] x = {-1, 0, 1, 0};
    int[] y = {0, -1, 0, 1};
    char[][] matrix;

    public int black(String[] A) {
        int count = 0;

        matrix = new char[A.length][A[0].length()];
        for(int i=0; i<A.length; i++)
            matrix[i] = A[i].toCharArray();

        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                if(matrix[i][j] == 'X')
                {
                    count++;
                    matrix[i][j] = 'O';
                    DFS(matrix, i, j);
                }
            }
        }
        return count;
    }

    public void DFS(char[][] A, int i, int j)
    {
        for(int k=0; k<4; k++)
        {
            int newX = i + x[k];
            int newY = j + y[k];

            if(newX>=0 && newY>=0 && newX<A.length && newY<A[0].length)
            {
                if(A[newX][newY] == 'X')
                {
                    A[newX][newY] = 'O';
                    DFS(A, newX, newY);
                }
            }
        }
    }
}