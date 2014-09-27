public class TestDeque
{
    public boolean AddRemoveSeqFirst(int N)
    {
        boolean bRes = true;
        Deque<Integer> tq = new Deque<Integer>();
        
        for(int i =0 ;i <N ;i++)
        {
            StdOut.printf("AddRemoveSeq :: Adding val : %d", i);
            tq.addFirst(i);
        }
        
        for(int i =N-1 ;i >= 0;i--)
        {
            StdOut.printf("AddRemoveSeq :: Atempting ro remove ");
            Integer exp = tq.removeFirst();
            StdOut.printf("AddRemoveSeq :: Removed value %d ",exp);
            if(i != exp)
            {
                bRes = false;
                StdOut.printf("AddRemoveSeq :: Failed :expected %d found %d \n",i ,exp);
            }
        }
        
        return bRes;
    }
    
    public boolean AddRemoveSeqlast(int N)
    {
        boolean bRes = true;
        Deque<Integer> tq = new Deque<Integer>();
        
        for(int i =0 ;i <N ;i++)
        {
            StdOut.printf("AddRemoveSeq :: Adding val : %d \n", i);
            tq.addLast(i);
        }
        
        for(int i =N-1 ;i >= 0;i--)
        {
            StdOut.printf("AddRemoveSeq :: Atempting ro remove \n");
            Integer exp = tq.removeLast();
            StdOut.printf("AddRemoveSeq :: Removed value %d \n",exp);
            if(i != exp)
            {
                bRes = false;
                StdOut.printf("AddRemoveSeq :: Failed :expected %d found %d \n",i ,exp);
            }
        }
        
        return bRes;
    }
    
    public boolean AddRemoveRand(int N)
    {
      
        
        return false;
    }
    
    public static void main(String[] args)   // unit testing
   {
       TestDeque ttq = new TestDeque();
       ttq.AddRemoveSeqlast(5);
   }
}