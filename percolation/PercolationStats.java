//http://introcs.cs.princeton.edu/java/stdlib/
public class PercolationStats {
    
   //Percolation m_Prc;
   private int n_N,n_T,ind,maxInd;
   private int ri,rj;
   private double [] responses;
   
   private double mean , stddev, clo,chi;
   public PercolationStats(int N, int T)    // perform T independent computational experiments on an N-by-N grid
   {
       n_N = N;
       n_T = T;
       
       maxInd=n_N*n_N;
       mean = stddev= clo= chi= 0;
       
       performTest();
       
       
       //verify();
   }
   public double mean()                     // sample mean of percolation threshold
   {
       //double mean=0;
       return mean;
   }
   public double stddev()                   // sample standard deviation of percolation threshold
   {
       //double sd=0;
       return stddev;
   }
   public double confidenceLo()             // returns lower bound of the 95% confidence interval
   {
       //double cl=0;
       return clo;
   }
   public double confidenceHi()             // returns upper bound of the 95% confidence interval
   {
       //double ch=0;
       return chi;
   }
   
   
   private void performTest()
   {
       int res;
       responses = new double[n_T];
       for(int i=0;i<n_T;i++)
       {
           res = runTillPercolation();
           responses[i]=((double)res)/maxInd;
       }
       
       mean = StdStats.mean(responses);
       stddev = StdStats.stddev(responses);
       double fact = (1.96*stddev)/Math.sqrt(n_T);
       clo = mean - fact;
       chi = mean + fact;
       
       StdOut.printf("mean \t = %f \n stddev \t = %f \n 95%% confidence interval \t = %f, %f" ,mean,stddev,clo,chi);
       //clo = StdStats.mean(responses);
       //chi = StdStats.mean(responses);
   }
  
   private void selectUopened(Percolation prc)
   {
       ri =StdRandom.uniform(n_N)+1;
       rj = StdRandom.uniform(n_N)+1;
         
       while(prc.isOpen(ri,rj))
       {
           ri =StdRandom.uniform(n_N)+1;
           rj = StdRandom.uniform(n_N)+1;
       }
   }
   private int runTillPercolation()
   {
     Percolation prc = new Percolation(n_N);
     int nopened =0;
        
          
     while(!prc.percolates() && ind <maxInd)
     {
         //find and open a site
         selectUopened(prc);
         prc.open(ri,rj);
         nopened++;
     }
     
     return nopened;
   }
   
   public static void main(String[] args)   // test client, described below
   {
       PercolationStats perS = new PercolationStats(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
       StdOut.println(perS.mean());
   }
}
