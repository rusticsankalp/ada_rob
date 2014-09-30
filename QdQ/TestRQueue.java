import java.util.Iterator;
public class TestRQueue
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
        int rand=0,eSize = 0, val;
        boolean bRes = true;
        Deque<Integer> tq = new Deque<Integer>();
        for(int i = 0; i < N;i++)
        {
            if(eSize > 0)
            {
                if(tq.isEmpty())
                {
                    bRes = false;
                    StdOut.printf("AddRemoveRand :: Failed isEmpty expected true \n");
                }
                
                if(tq.size() != eSize)
                {
                    bRes = false;
                    StdOut.printf("AddRemoveRand :: Failed size expected %d actual %d \n",eSize,tq.size());
                }
            }
            val = StdRandom.uniform(N*100);
            rand = StdRandom.uniform(4);
            switch(rand)
            {
                case 0:
                    tq.addFirst(val);
                     StdOut.printf("AddRemoveRand :: addFirst: %d , size:%d \n",val,tq.size());
                    break;
                case 1:
                    tq.addLast(val);
                    StdOut.printf("AddRemoveRand :: addLast %d size:%d \n",val,tq.size());
                    break;
                case 2:
                    if(!tq.isEmpty()){
                       val = tq.removeFirst();
                       StdOut.printf("AddRemoveRand :: removeFirst %d  size:%d \n",val,tq.size());
                }
                    break;
                case 3:
                    if(!tq.isEmpty()) {
                       val = tq.removeLast();
                       StdOut.printf("AddRemoveRand :: removeLast %d size:%d \n",val,tq.size());
                }
                    break;
            }
        }
        
        return bRes;
    }
    
    public boolean addIterTest(int N)
    {
        boolean bRes = true;
        Deque<Integer> tq = new Deque<Integer>();
        
        for(int i = 0 ;i <N ;i++)
        {
            StdOut.printf("addIterTest :: Adding val : %d \n", i);
            tq.addLast(i);
        }
        
        Iterator<Integer> iter = tq.iterator();
        int size = 0 ;
        while(iter.hasNext())
        {
            StdOut.printf("addIterTest :: %d \n", iter.next());
            size++;
            //StdOutiter.next()
        }
        
        
        if(size != N)
        {
            StdOut.printf("addIterTest ::  size did not match \n");
            bRes = false;
        }
        
       
        return bRes;
    }
    
    public static void main(String[] args)   // unit testing
   {
       
       for(int i =0 ; i <2 ; i++)
       {
           TestDeque ttq = new TestDeque();
           if(!ttq.addIterTest(10))
           {
               StdOut.printf("Failed , Failed, failed , failed");
               break;
           }
       }
   }
}