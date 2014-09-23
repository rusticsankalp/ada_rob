public class Percolation {
    
    private WeightedQuickUnionUF qf;
    private int nN;
    private int max;
    
    private int [][]opened;
    
    //row =1 col =1 min
    private int  xyTod(int row , int col)
    {
        //since row starts with one and is horizontal each row means n items
        return (row-1)*nN + col;
    }
   public Percolation(int N)  // create N-by-N grid, with all sites blocked
   {
       //StdOut.printf("percolation :: N:%d \n",N);
       max = N*N;
       nN = N;
        
       int topen[][] = new int[N][N];
       topen[0][0] =0;
       //StdOut.printf("Created new test 2d array \n");
       qf = new WeightedQuickUnionUF(max+2);
       opened = new int[nN][nN];
       //topened[0][0
       //StdOut.printf("Created new 2d array\n");
       nN= N;

       for(int i =0;i<N;i++)
       {
           for(int j =0 ;j <N; j++)
           {
               //StdOut.printf("percolation :: i:%d , j:%d \n",i,j);
               opened[i][j] =0;
           }
       }
   }
   
   //i,j start at 0
   public void open(int i, int j)// open site (row i, column j) if it is not already
   {
       //StdOut.printf("open :: i:%d , j:%d \n",i,j);
       if(opened[i-1][j-1]==1)
       {
           return;
       }
       
       opened[i-1][j-1]=1;
       
       //left
       if(j>1)
       {
           if(opened[i-1][j-2]==1)
           {
               qf.union(xyTod(i,j),xyTod(i,j-1));
           }
       }
       
       //right
       if(j<(nN))
       {
           if(opened[i-1][j]==1)
           {
               qf.union(xyTod(i,j),xyTod(i,j+1));
           }
       }
       
       //up 
       if(i>1)
       {
           if(opened[i-2][j-1]==1)
           {
               qf.union(xyTod(i,j),xyTod(i-1,j));
           }
       }else if ( i ==1)
       {
           qf.union(xyTod(i,j),0);
       }
       
       //down
       if(i<nN)
       {
           if(opened[i][j-1]==1)
           {
               qf.union(xyTod(i,j),xyTod(i+1,j));
           }
       }
       else if ( i ==nN)
       {
           qf.union(xyTod(i,j),max+1);
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
       //StdOut.printf("isOpen :: i:%d , j:%d \n",i,j);
       boolean res = (opened[i-1][j-1]==1);
       //StdOut.printf("isOpen :: res:%B \n",res);
           
       return res;
   }
   public boolean isFull(int i, int j)      // is site (row i, column j) full?
   {
       //StdOut.printf("isFull :: i:%d , j:%d \n",i,j);
       boolean res = (qf.connected(xyTod(i,j),0));
       //StdOut.printf("isFull :: res:%B \n",res);
       return res;
   }
   public boolean percolates()              // does the system percolate?
   {
       return (qf.connected(max+1,0));
   }
   public static void main(String[] args)   // test client, optional
   {
   }
}
