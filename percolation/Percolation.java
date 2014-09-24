public class Percolation {
    private WeightedQuickUnionUF qf, qf2, qf3;
    private int nN;
    private int max;
    
    private int [][]opened;
    
   public Percolation(int N)  // create N-by-N grid, with all sites blocked
   {
       //StdOut.printf("percolation :: N:%d \n",N);
       
       if (N <= 0) 
           throw new IllegalArgumentException("Size or square N illegal");
       max = N*N;
       nN = N;
        
       //StdOut.printf("Created new test 2d array \n");
       qf = new WeightedQuickUnionUF(max+2);
       qf2 = new WeightedQuickUnionUF(max+2);
       qf3 = new WeightedQuickUnionUF(max+2);
       opened = new int[nN][nN];
       //topened[0][0
       //StdOut.printf("Created new 2d array\n");
       nN = N;

       for (int i = 0; i < N; i++)
       {
           for (int j = 0; j < N; j++)
           {
               //StdOut.printf("percolation :: i:%d , j:%d \n",i,j);
               opened[i][j] = 0;
           }
       }
   }
   
   private void verifyIndex(int i , int j)
   {
       if (i <= 0 || i > nN) 
           throw new IndexOutOfBoundsException("row index i out of bounds");
       if (j <= 0 || j > nN) 
           throw new IndexOutOfBoundsException("row index j out of bounds");
   }
        
    //row =1 col =1 min
    private int  xyTod(int row , int col)
    {
        //since row starts with one and is horizontal each row means n items
        return (row-1)*nN + col;
    }
  
   
   //i,j start at 0
   // open site (row i, column j) if it is not already
   public void open(int i, int j)
   {
       verifyIndex(i, j);
       //StdOut.printf("open :: i:%d , j:%d \n",i,j);
       if (opened[i-1][j-1] == 1)
       {
           return;
       }
       
       opened[i-1][j-1] = 1;
       
       //left
       if (j > 1)
       {
           if (opened[i-1][j-2] == 1)
           {
               qf.union(xyTod(i, j), xyTod(i, j-1));
               qf2.union(xyTod(i, j), xyTod(i, j-1));
               qf3.union(xyTod(i, j), xyTod(i, j-1));
           }
       }
       
       //right
       if (j < (nN))
       {
           if (opened[i-1][j] == 1)
           {
               qf.union(xyTod(i, j), xyTod(i, j+1));
               qf2.union(xyTod(i, j), xyTod(i, j+1));
               qf3.union(xyTod(i, j), xyTod(i, j+1));
           }
       }
       
       //up 
       if (i > 1)
       {
           if (opened[i-2][j-1] == 1)
           {
               qf.union(xyTod(i, j), xyTod(i-1, j));
               qf2.union(xyTod(i, j), xyTod(i-1, j));
               qf3.union(xyTod(i, j), xyTod(i-1, j));
           }
       } else if (i == 1)
       {
           qf.union(xyTod(i, j), 0);
           qf3.union(xyTod(i, j), 0);
       }
       
       //down
       if (i < nN)
       {
           if (opened[i][j-1] == 1)
           {
               qf.union(xyTod(i, j), xyTod(i+1, j));
               qf2.union(xyTod(i, j), xyTod(i+1, j));
               qf3.union(xyTod(i, j), xyTod(i+1, j));
           }
       }
       else if (i == nN)
       {
           qf2.union(xyTod(i, j), max+1);
           qf3.union(xyTod(i, j), max+1);
         //if((qf.connected(xyTod(i,j),max+1)) && (qf.connected(xyTod(i,j),0)))
           // qf.union(xyTod(i,j),max+1);
           //else
       }
       
       /*
       for(int ii =0;ii<nN;ii++)
       {
           for(int jj =0 ;jj <nN; jj++)
           {
               //StdOut.printf("  %d",opened[ii][jj]);
               //opened[i][j] =0;
           }
           StdOut.printf("\n");
       }
       */
       
   }
   
   public boolean isOpen(int i, int j)      // is site (row i, column j) open?
   {
       verifyIndex(i, j);
       //StdOut.printf("isOpen :: i:%d , j:%d \n",i,j);
       boolean res = (opened[i-1][j-1] == 1);
       //StdOut.printf("isOpen :: res:%B \n",res);
           
       return res;
   }
   public boolean isFull(int i, int j)      // is site (row i, column j) full?
   {
       verifyIndex(i, j);
       //StdOut.printf("isFull :: i:%d , j:%d \n",i,j);
       boolean res = (qf.connected(xyTod(i, j), 0));
                          //&& qf2.connected(xyTod(i, j), max+1));
       //StdOut.printf("isFull :: res:%B \n",res);
       return res;
   }
   public boolean percolates()              // does the system percolate?
   {
       return (qf3.connected(max+1, 0));
   }
   public static void main(String[] args)   // test client, optional
   {
   }
}
