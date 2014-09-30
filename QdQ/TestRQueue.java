import java.util.Iterator;
public class TestRQueue
    {
    public boolean AddRemoveSeqFirst(int N)
    {
        boolean bRes = true;
        RandomizedQueue<Integer> tq = new RandomizedQueue<Integer>();
        
        for(int i =0 ;i <N ;i++)
        {
            StdOut.printf("AddRemoveSeq :: Adding val : %d", i);
            tq.enqueue(i);
        }
        
        for(int i =N-1 ;i >= 0;i--)
        {
            StdOut.printf("AddRemoveSeq :: Atempting ro remove ");
            Integer exp = tq.dequeue();
            StdOut.printf("AddRemoveSeq :: Removed value %d ",exp);
//            if(i != exp)
//            {
//                bRes = false;
//                StdOut.printf("AddRemoveSeq :: Failed :expected %d found %d \n",i ,exp);
//            }
        }
        
        return bRes;
    }
    
    public boolean AddRemoveRand(int N)
    {
        int rand=0,eSize = 0, val;
        boolean bRes = true;
        RandomizedQueue<Integer> tq = new RandomizedQueue<Integer>();
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
            rand = StdRandom.uniform(2);
            switch(rand)
            {
                case 0:
                    tq.enqueue(val);
                     StdOut.printf("AddRemoveRand :: addFirst: %d , size:%d \n",val,tq.size());
                    break;
//                case 1:
//                    tq.dequeue(val);
//                    StdOut.printf("AddRemoveRand :: addLast %d size:%d \n",val,tq.size());
//                    break;
                case 1:
                    if(!tq.isEmpty()){
                       val = tq.dequeue();
                       StdOut.printf("AddRemoveRand :: removeFirst %d  size:%d \n",val,tq.size());
                }
                    break;
//                case 3:
//                    if(!tq.isEmpty()) {
//                       val = tq.removeLast();
//                       StdOut.printf("AddRemoveRand :: removeLast %d size:%d \n",val,tq.size());
//                }
//                    break;
            }
        }
        
        return bRes;
    }
    
    public boolean addIterTest(int N)
    {
        boolean bRes = true;
        RandomizedQueue<Integer> tq = new RandomizedQueue<Integer>();
        
        for(int i = 0 ;i <N ;i++)
        {
            StdOut.printf("addIterTest :: Adding val : %d \n", i);
            tq.enqueue(i);
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
       
       for(int i =0 ; i <1 ; i++)
       {
           TestRQueue ttq = new TestRQueue();
           if(!ttq.addIterTest(1))
           {
               StdOut.printf("Failed , Failed, failed , failed");
               break;
           }
       }
   }
}