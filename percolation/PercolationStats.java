//http://introcs.cs.princeton.edu/java/stdlib/
public class PercolationStats {
    
   //Percolation m_Prc;
   private int nN, nT, ind, maxInd;
   private int ri, rj;
   private double []responses;
   
   private double mean , stddev, clo, chi;
   // perform T independent computational experiments on an N-by-N grid
   public PercolationStats(int N, int T)    
   {
       if (N <= 0) 
           throw new IllegalArgumentException("Size or square N illegal");
       if (T <= 0) 
           throw new IllegalArgumentException("num of exp T illegal");
       
       nN = N;
       nT = T;
       
       maxInd = nN*nN;
       mean = 0;
       stddev = 0;
       clo = 0;
       chi = 0;
       
       performTest();
       //verify();
   }
   
   // sample mean of percolation threshold
   public double mean()                     
   {
       //double mean=0;
       return mean;
   }
   
   // sample standard deviation of percolation threshold
   public double stddev()                   
   {
       //double sd=0;
       return stddev;
   }
   
   // returns lower bound of the 95% confidence interval
   public double confidenceLo()             
   {
       //double cl=0;
       return clo;
   }
   
   // returns upper bound of the 95% confidence interval
   public double confidenceHi()             
   {
       //double ch=0;
       return chi;
   }
   
   
   private void performTest()
   {
       int res;
       responses = new double[nT];
       for (int i = 0;  i < nT; i++)
       {
           res = runTillPercolation();
           responses[i] = ((double) res)/maxInd;
       }
       
       mean = StdStats.mean(responses);
       stddev = StdStats.stddev(responses);
       double fact = (1.96*stddev)/Math.sqrt(nT);
       clo = mean - fact;
       chi = mean + fact;
       
       StdOut.printf(
       "mean \t = %f \n stddev \t = %f \n 95%% confidence interval \t = %f, %f"
        , mean, stddev, clo, chi);
       //clo = StdStats.mean(responses);
       //chi = StdStats.mean(responses);
   }
  
   private void selectUopened(Percolation prc)
   {
       ri = StdRandom.uniform(nN) + 1;
       rj = StdRandom.uniform(nN) + 1;
         
       while (prc.isOpen(ri, rj))
       {
           ri = StdRandom.uniform(nN) + 1;
           rj = StdRandom.uniform(nN) + 1;
       }
   }
   private int runTillPercolation()
   {
     Percolation prc = new Percolation(nN);
     int nopened = 0;
        
          
     while (!prc.percolates() && ind < maxInd)
     {
         //find and open a site
         selectUopened(prc);
         prc.open(ri, rj);
         nopened++;
     }
     
     return nopened;
   }
   
   public static void main(String[] args)   // test client, described below
   {
       PercolationStats perS = new PercolationStats(Integer.parseInt(args[0]),
        Integer.parseInt(args[1]));
       StdOut.println(perS.mean());
   }
}
