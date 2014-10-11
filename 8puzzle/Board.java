public class Board {
    // construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks)
    {
        board = blocks;
        N = blocks.length;
        size = N*N;
        pZ = -1;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(board[i][j] == 0)
                {
                    pZ = i*N + j;
                    break;
                }
            }
            if(pZ != -1)
                break;
        }
    }
    
    private int [][] board;
    int N , size;
    int pZ;
    // board dimension N
    public int dimension()                 
    {
        return N;
    }
    // number of blocks out of place
    public int hamming()
    {
        int size = N*N-1;
        int hamming = 0;
        int exp,row,col;
        for(int i =0 ; i < size ; i++)
        {
            //:bug used size instead of i
            row = i/N;
            col = i%N;
            exp = i+1;

                 if(board[row][col] != exp)
                 {
                     if(board[row][col] != 0)
                     {
                         hamming++;
                     }
                     else
                     {
                         
                     }
                 }
             StdOut.printf(" %d,%d,%d,",board[row][col],exp,hamming);
             if(col == N-1)
                StdOut.printf("\n");
        }
        
        if(board[N-1][N-1] != 0)
        {
            hamming++;
        }
        
        return hamming;
    }
    // sum of Manhattan distances between blocks and goal
    public int manhattan()                 
    {
        int size = N*N;
        int manh = 0;
        int expR,expC,row,col;
        for(int i =0 ; i < size ; i++)
        {
            row = i/N;
            col = i%N;
            
            expR = (board[row][col]-1)/N;
            expC = (board[row][col]-1)%N;
            
            if(board[row][col]!=0)
            {
                manh+=Math.abs(expR-row)+Math.abs(expC-col);
            }
            
             StdOut.printf(" %d,%d,%d,%d,",board[row][col],expR,expC,manh);
             if(col == N-1)
                StdOut.printf("\n");
        }
        return manh;
    }
    // is this board the goal board?
    public boolean isGoal()                
    {
        int size = N*N-1;
        boolean match = true;
        int exp,row,col;
        for(int i =0 ; i < size ; i++)
        {
            //:bug used size instead of i
            row = i/N;
            col = i%N;
            exp = i+1;

                 if(board[row][col] != exp)
                 {
                     if(board[row][col] != 0)
                     {
                         match = false;
                         break;
                     }
                 }
        }
        return match;
    }
    // a boadr that is obtained by exchanging two adjacent blocks in the same row
    public Board twin()                    
    {
        int size = N*N-1;
        int crow=0 ,ccol=0 , nrow=0 ,ncol=0 ;
        for(int i =0;i<size;i++)
        {
            nrow = (i+1)/N;
            ncol = (i+1)%N;
            crow = i/N;
            ccol = i%N;
                    
            if(board[nrow][ncol]!=0 && board[crow][ccol]!=0)
            {
                break;
            }
        }
        
        int [][]b2 = new int[N][N];
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                b2[i][j]=board[i][j];
            }
        }
        
        b2[nrow][ncol] = board[crow][ccol];
        b2[crow][ccol] = board[nrow][ncol];
            
        return new Board(b2);
    }
    // does this board equal y?
    public boolean equals(Object y)        
    {
        Board test = (Board) y;
        
        if(toString() != test.toString())
            return false;
        
        return true;

    }
    // all neighboring boards
    public Iterable<Board> neighbors()     
    {
        return null;
    }
    // string representation of this board (in the output format specified below)
    public String toString() 
    {
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", board[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    
    private static Board readFile(String file)
    {
        In in = new In(file);
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
            blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
        
        return initial;
        
//        // solve the puzzle
//        Solver solver = new Solver(initial);
//        
//        // print solution to standard output
//        if (!solver.isSolvable())
//            StdOut.println("No solution possible");
//        else {
//            StdOut.println("Minimum number of moves = " + solver.moves());
//            for (Board board : solver.solution())
//                StdOut.println(board);
//        }
    }

    public static void main(String[] args) // unit tests (not graded)
    {
        Board brd = readFile(args[0]);
        
        StdOut.printf("\n hamming val : %d \n" , brd.hamming());
        
        StdOut.printf("\n manhattan  val : %d" , brd.manhattan());
    }
}