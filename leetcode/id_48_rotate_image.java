class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int line = 0; line < n / 2; ++line) {
            
            for (int col = line; col < n - line - 1; ++col) {
                
                // (x, y) = (y, -x)
                int startX = line + 1;
                int startY = col + 1;
                int tranX  = startY;
                int tranY  = n + 1 - startX;

                int temp = matrix[line][col];
                int prevTtemp = temp;
                
                while (tranX - 1 != line || tranY - 1 != col) {
                    temp = matrix[tranX - 1][tranY - 1];
                    matrix[tranX - 1][tranY - 1] = prevTtemp;
                    prevTtemp = temp;

                    startX = tranX;
                    startY = tranY;
                    tranX  = startY;
                    tranY  = n + 1 - startX;
                }

                matrix[line][col] = prevTtemp;
            }
        }        

    }
}