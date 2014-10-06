import java.util.Comparator;
public class Brute {
    private static void collinear(Point[] g)
    {
        Comparator<Point> comp = g[0].SLOPE_ORDER;
        if(comp.compare(g[1],g[2]) != 0)
        {
            return;
        }
        
        if(comp.compare(g[1],g[3]) != 0)
        {
            return;
        }
        Point swap;
        for(int i= 1;i<4;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(g[i].compareTo(g[j])>=0)
                {
                    continue;
                }
                else
                {
                    swap = g[i];
                    g[i] = g[j];
                    g[j] = swap;
                }
            }
        }
        for(int i= 0;i<3;i++)
        {
            //(14000, 10000) -> (18000, 10000) -> (19000, 10000) -> (21000, 10000)
            StdOut.printf(g[i].toString());
            StdOut.printf(" -> ");
        }
        g[0].drawTo(g[3]);
        StdOut.printf(g[3].toString()+"\n");
        StdDraw.show(0);
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
            for(int j= i+1;j<N;j++)
            {
                for (int k=j+1;k<N;k++)
                {
                    for (int l = k+1;l<N;l++)
                    {
                        Point [] grp = (Point [])new Point[4];
                        grp[0]=gr[i];
                        grp[1]=gr[j];
                        grp[2]=gr[k];
                        grp[3]=gr[l];
                        
                        collinear(grp);
                        
                    }
                }
            }
        }
        StdDraw.show(0);
   }
}