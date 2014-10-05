import java.util.Comparator;

public class Point implements Comparable<Point> 
{

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER;       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate
    
//    private int compare(Point v, Point w)
//    {
//        return v.compareTo(w);
//    }
    
    private static class SlopeOrder implements Comparator<Point>
    {
        
        public SlopeOrder(Point ap)
        {
            p = ap;
        }
        
        Point p;
        public int compare(Point v, Point w)
        {
            int res = 0;
            
            double slopeA = p.slopeTo(v);
            double slopeB = p.slopeTo(w);
            
            if(slopeA < slopeB)
            {
                res = -1;
            }
            else if (slopeA > slopeB)
            {
                res = 1;
            }
            else
            {
                res = 0;
            }
            
            return res;
        }
    }

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
        
        SLOPE_ORDER = new SlopeOrder(this);
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        
        if (that == null)
           throw new NullPointerException("parameter null not allowed");
        double slope = 0;
        
                
        if(that.x == x)
        {
            if(that.y == y)
                slope = Double.NEGATIVE_INFINITY;
            else
                slope = Double.POSITIVE_INFINITY;
        }
        else
        {
            if(that.y == y)
                slope = 0;
            else
                slope = ((double) (that.y - y))/(that.x - x); 
        }
            
        return slope;
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        
        if (that == null)
           throw new NullPointerException("parameter null not allowed");
        int res = 0;
        
        if(y < that.y)
        {
            res = 1;
        }else if(y > that.y)
        {
            res = -1;
        }else //y == that.y
        {
            if(x<that.x)
                res = 1;
            else if(x > that.x)
                res = -1;
            else
                res = 0 ;
        }
        
        return res;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        //boolean bResult = true;
        //Test CompareTo 
        
        
    }
}

