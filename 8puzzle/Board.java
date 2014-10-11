public class Board {
    // construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks)
    {
        board = blocks;
        N = blocks.length;
    }
    
    private int [][] board;
    int N;
    // board dimension N
    public int dimension()                 
    {
        return N;
    }
    // number of blocks out of place
    public int hamming()
    {
        int size = N*N -1;
        int hamming = 0;
        int exp;
        for(int i =0 ; i < N ; i++)
        {
             for(int j =0 ; j < N ; j++)
             {
                 exp = (i*N + j);
                 if(board[i][j] != exp)
                 {
                     if(board[i][j] != 0)
                     {
                         hamming++;
                         
                     }
                     else
                     {
                         
                     }
                     
                     
                 }
                 StdOut.printf(" %d,%d,%B",board[i][j],exp,hamming);
                 
             }
             StdOut.printf("\n");
        }
        
        return hamming;
    }
    // sum of Manhattan distances between blocks and goal
    public int manhattan()                 
    {
        return 0;
    }
    // is this board the goal board?
    public boolean isGoal()                
    {
        return false;
    }
    // a boadr that is obtained by exchanging two adjacent blocks in the same row
    public Board twin()                    
    {
        return null;
    }
    // does this board equal y?
    public boolean equals(Object y)        
    {
        return false;
    }
    // all neighboring boards
    public Iterable<Board> neighbors()     
    {
        return null;
    }
    // string representation of this board (in the output format specified below)
    public String toString()               
    {
        return "";
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
        
        StdOut.printf("hamming val : %d" , brd.hamming());
    }
}