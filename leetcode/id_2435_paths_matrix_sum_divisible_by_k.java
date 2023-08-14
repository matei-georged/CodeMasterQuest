class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        //declare variables
        final int MODULO_SOL    = 1000000007;
        int       N             = grid.length;
        int       M             = grid[0].length;
        int[][][] DPMaxtrix     = new int[N+1][M+1][k+1];

        //init the DP matrix solution. 
        //DP[I][J][K] = the number of ways we can get the sum from (0,0) to (i-1)(j-1)
        //with the modulo of sum to be K. 
        int originalRemainder = grid[0][0] % k;
        DPMaxtrix[1][1][originalRemainder] += 1;
        
        for (int i = 1; i <= N; ++i)
        {
            for (int j = 1; j <= M; ++j)
            {
                //we use i-1 and j-1 because the input is zero indexed. 
                //Our DP matrix is 1 indexed so there is no need for perform OOB checks
                int addedRemained = grid[i-1][j-1] % k;

                for(int kAux = 0; kAux <= k; ++kAux)
                {   
                    //Do a +k hack. It will prevent OOB exceptions. 
                    //Because we do a modulo K, adding a +k does not change anything
                    //This loop updates the matrix with the modulo of the new number.
                    DPMaxtrix[i][j][kAux] += DPMaxtrix[i-1][j][(kAux + k - addedRemained)%k] % MODULO_SOL;
                    DPMaxtrix[i][j][kAux] += DPMaxtrix[i][j-1][(kAux + k - addedRemained)%k] % MODULO_SOL;
                }
            }
        }

        return DPMaxtrix[N][M][0] % MODULO_SOL;
    }
}