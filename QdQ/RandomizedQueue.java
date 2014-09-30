import java.util.Iterator;
public class RandomizedQueue<Item> implements Iterable<Item> 
{
   public RandomizedQueue()                 // construct an empty randomized queue
   {
       size = 0;
       capacity = 0;
       minSize = 10;
       Item []nArr = (Item[])new Object[minSize];
   }
   private Item[] items;
   private int size, minSize;
   private int capacity;
   public boolean isEmpty()                 // is the queue empty?
   {
       return size <= 0;
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
      
      if(ratio <= .25 && capacity > (minSize*2) )
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
         resize(nCap);
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
           items[size++] = item;
           checkNresize();
       //}
   }
   public Item dequeue()                    // delete and return a random item
   {
       if(isEmpty())
           throw new java.util.NoSuchElementException("attempted to remove from empty q in dequeue");
       
       checkNresize();
       int npos= StdRandom.uniform(size); 
       Item item = items[npos];
       items[npos] = items[size--];
       
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
       Item []nArr = (Item[])new Object[nsize];
       for(int i = 0; i < size; i++)
       {
           nArr[i] = items[i]; 
       }
       
       capacity = nsize;
       items = nArr;
   }
   
   private class RQIterator implements Iterator<Item>
   {
       RQIterator(Item [] arr, int sz)
       {
           size = sz;
           items = arr;
           int npos;
           Item swap;
           
           for(int i =0  ; i < size; i++)
           {
               npos = StdRandom.uniform(size); 
               swap = items[npos];
               items[npos] = items[i];
               items[i] = swap;
           }
           pos = 0;
       }
       Item [] items;
       int size, pos;
       
       public boolean hasNext() 
       {
           return pos > size;
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