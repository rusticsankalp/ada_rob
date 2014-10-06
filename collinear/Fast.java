import java.util.Comparator;
public class Fast {
    
//    private Point [] sort(Point[]g)
//    {
//        return g;
//    }
    private static void collinear(Point[] g, Point tp ,int N)
    {
        
        double [] slope = new double[N];
        double tslope;
        Point sp;
        
        for(int i =0 ; i<N ; i++)
        {
            slope[i] = tp.slopeTo(g[i]);
        }
        
        for(int i= 1;i<N;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(slope[i]>=slope[j])
                {
                    continue;
                }
                else
                {
                    sp = g[i];
                    g[i] = g[j];
                    g[j] = sp;
                    
                    tslope = slope[i];
                    slope[i] = slope[j];
                    slope[j] = tslope;
                }
            }
        }
        int sind = 0, send = 0;
        tslope = slope[0];
        
        for(int i =1;i< N; i++)
        {
            if(slope[i] == tslope)
            {
                send = i;
            }
            else
            {
                if(send - sind > 4)
                {
                    //draw and print
                    
                    //:bug started with i didnot change i to j++
                    for(int j= sind;i<send;j++)
                    {
                        //(14000, 10000) -> (18000, 10000) -> (19000, 10000) -> (21000, 10000)
                        StdOut.printf(g[j].toString());
                        StdOut.printf(" -> ");
                        g[sind].drawTo(g[j]);
                    }
                    StdOut.printf(g[send].toString()+"\n");
                    g[sind].drawTo(g[send]);
                    StdDraw.show(0);
                }
                sind = i;
                send = i;
                tslope = slope[i];
            }
        }
        
//        for(int i= 0;i<3;i++)
//        {
//            //(14000, 10000) -> (18000, 10000) -> (19000, 10000) -> (21000, 10000)
//            StdOut.printf(g[i].toString());
//            StdOut.printf(" -> ");
//        }
//        g[0].drawTo(g[3]);
//        StdOut.printf(g[3].toString()+"\n");
//        StdDraw.show(0);
    }
   public static void main(String[] args)
   {
        // rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01);  // make the points a bit larger
       
       String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point [] gr = (Point [])new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            gr[i]=p;
            p.draw();
        }
        
        StdDraw.show(0);

        // reset the pen radius
        StdDraw.setPenRadius();
        
        //StdDraw.setPenRadius(0.001);  // make the points a bit larger
        for(int i=0 ;i<N;i++)
        {
            collinear(gr,gr[i],N);        
        }
        StdDraw.show(0);
   }
}
