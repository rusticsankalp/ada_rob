public class Percolation {
    
    QuickFindUF qf;
    int nN;
    int max;
    
    int [][]opened;
    
    //row =1 col =1 min
    private int xyTod(int row , int col)
    {
        //since row starts with one and is horizontal each row means n items
        return (row-1)*nN + col;
    }
   public Percolation(int N)                // create N-by-N grid, with all sites blocked
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
   public void open(int i, int j)           // open site (row i, column j) if it is not already
   {
       opened[i][j]=1;
       
       int ti = (i+1)*nN+(j+1)*nN;
       
       //left
       if(j>0)
       {
           if(opened[i-1][j]==1)
           {
               qf.union(ti,ti-1);
           }
       }
       
       //right
       if(j<(nN-1))
       {
           if(opened[i-1][j]==1)
           {
               qf.union(ti,ti+1);
           }
       }
       
       //up 
       if(i>0)
       {
           if(opened[i-1][j]==1)
           {
               qf.union(ti,ti-nN);
           }
       }
       
       //down
       if(i<(nN-1))
       {
           if(opened[i-1][j]==1)
           {
               qf.union(ti,ti+nN);
           }
       }
   }
   
   public boolean isOpen(int i, int j)      // is site (row i, column j) open?
   {
       return (opened[i][j]==1);
   }
   public boolean isFull(int i, int j)      // is site (row i, column j) full?
   {
       boolean bResult = false;
       return bResult;
   }
   public boolean percolates()              // does the system percolate?
   {
       boolean bResult = false;
       return bResult;
   }
   public static void main(String[] args)   // test client, optional
   {
   }
}
