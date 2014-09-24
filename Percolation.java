public class Percolation {
    
    QuickFindUF qf;
    int nN;
    int max;
    
    int [][]opened;
    
    //row =1 col =1 min
    private int  xyTod(int row , int col)
    {
        //since row starts with one and is horizontal each row means n items
        return (row-1)*nN + col;
    }
   public Percolation(int N)  // create N-by-N grid, with all sites blocked
   {
       max = N*N;
        
       qf = new QuickFindUF(max+2);
       nN= N;

       for(int i =0;i<N;i++)
       {
           for(int j =0 ;j <N; i++)
           {
               opened[i][j] =0;
           }
       }
   }
   
   //i,j start at 0
   public void open(int i, int j)// open site (row i, column j) if it is not already
   {
       if(opened[i-1][j-1]==1)
       {
           return;
       }
       
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
       }
   }
   
   public boolean isOpen(int i, int j)      // is site (row i, column j) open?
   {
       return (opened[i][j]==1);
   }
   public boolean isFull(int i, int j)      // is site (row i, column j) full?
   {
       return (qf.connected(xyTod(i,j),0));
   }
   public boolean percolates()              // does the system percolate?
   {
       return (qf.connected(max+1,0));
   }
   public static void main(String[] args)   // test client, optional
   {
   }
}
