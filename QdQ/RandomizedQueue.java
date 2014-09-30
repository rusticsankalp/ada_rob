import java.util.Iterator;
public class RandomizedQueue<Item> implements Iterable<Item> 
{
   public RandomizedQueue()                 // construct an empty randomized queue
   {
       size = 0;
       //:Bug order was different
       minSize = 10;
       capacity = minSize;
       
       items = (Item[])new Object[capacity];
   }
   private Item[] items;
   private int size, minSize;
   private int capacity;
   public boolean isEmpty()                 // is the queue empty?
   {
       //bug:size should be greater than capacity
       return size<=0 ;
   }
   public int size()                        // return the number of items on the queue
   {
       return size;
   }
   
   private void checkNresize()
   {
      int exp = 10;
      float ratio = size;
      ratio = ratio/capacity;
      boolean bRes = false;
      int nCap = capacity;
      
      StdOut.printf("checkNresize :: ratio : %f m size: %d, capacity: %d  \n",ratio,size,capacity);
      
      if(ratio <= .25 && capacity > (minSize) )
      {
          nCap = ((int)capacity/2);
          bRes = true;
      }
      else if ( ratio >.9)
      {
         nCap = ((int)capacity*2);
         bRes = true;
      }
      
      if(bRes)
      {
          StdOut.printf("checkNresize :: attempting to set newCap : %d \n",nCap);
         resize(nCap);
         capacity = nCap;
      }
       
   }
   public void enqueue(Item item)           // add the item
   
   {
       if(item == null)
           throw new NullPointerException("attempted to add null in enqueue");
//       if(size>1)
//       {
//           npos= StdRandom.uniform(size);
//           Item swap = items[npos];
//           items[npos] = item;
//           items[size++] = swap;
//       }
//       else 
//       {
       //items[size] = new Item();
//       StdOut.printf("enqueue ::  adding to items at posistion : %d",size);
//       if(items == null)
//       {
//           StdOut.printf("enqueue :: items is null");
//       }
           checkNresize();
           items[size++] = item;
           //StdOut.printf("enqueue ::  before checkNResize");
//                  for(int i =0 ; i < size;i++)
//       {
//           StdOut.printf("%d ",items[i]);
//       }
       StdOut.printf("\n ");
       //}
   }
   public Item dequeue()                    // delete and return a random item
   {
       if(isEmpty())
           throw new java.util.NoSuchElementException("attempted to remove from empty q in dequeue");
       //StdOut.printf("deq 1 : ");
       checkNresize();
       //StdOut.printf("deq 2 : ");
       int npos= StdRandom.uniform(size);
       if(size ==1)
       {
           npos = 0;
       }
       Item item = items[npos];
       //bug: shold be --size instead of size--;
       items[npos] = items[--size];
       //StdOut.printf("------Removing at pos: %d \n ",npos);
//       for(int i =0 ; i < size;i++)
//       {
//           StdOut.printf("%d ",items[i]);
//       }
       StdOut.printf("\n ");
       //StdOut.printf("deq 3 : \n");
       return item;
   }
   public Item sample()                     // return (but do not delete) a random item
   {
       if(isEmpty())
           throw new java.util.NoSuchElementException("attempted to sample from empty q in sample");
       return null;
   }
   
   private void resize(int nsize)
   {
       //:bug used size instead of nsize
       Item []nArr = (Item[])new Object[nsize];
       for(int i = 0; i < size; i++)
       {
           nArr[i] = items[i]; 
       }
       
       //capacity = nsize;
       items = nArr;
   }
   
   private class RQIterator implements Iterator<Item>
   {
       RQIterator(Item [] arr, int sz)
       {
           size = sz;
           //:Bug assigning to wrong variable
           items = (Item[])new Object[size];
           items = arr;
           int npos;
           Item swap;
           //StdOut.printf("RQIterator ::  size : %d\n",size);
           for(int i =0  ; i < size; i++)
           {
               items[i] = arr[i];
//               if(items[i] ==null )
//               {
//                   StdOut.printf("RQIterator :: is null \n");
//               }
           }
           for(int i =0  ; i < size; i++)
           {
               npos = StdRandom.uniform(size); 
               swap = items[npos];
               items[npos] = items[i];
               items[i] = swap;
//               if(items[i] ==null )
//               {
//                   StdOut.printf("RQIterator :: is null 2 \n");
//               }
           }
           pos = 0;
       }
       Item [] items;
       int size, pos;
       
       public boolean hasNext() 
       {
           //:bug incorrect comparison
           return pos < size;
       }
       public void remove() 
       {
           throw new java.util.NoSuchElementException(
                "Remove is not supported for this iterator");
       }
       public Item next() 
       { 
           if(!hasNext())
               throw new java.util.NoSuchElementException("no more items");
       
           return items[pos++]; 
       }
   }
   public Iterator<Item> iterator()         // return an independent iterator over items in random order
   {
       return new RQIterator(items,size);
   }
   public static void main(String[] args)   // unit testing
   {
   }
}