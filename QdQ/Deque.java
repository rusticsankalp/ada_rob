public class Deque<Item> //implements Iterable<Item> {
{
   private class Node<T>
   {
       public Node(T value, Node<T> p, Node<T> n)
       {
           prev = p; 
           next = n;
       }
       public T value;
       public Node<T> prev, next;
   }
   
   private Node<Item> first, last;
   int size ;
   public Deque()                           // construct an empty deque
   {
       first = null;
       last = null;
       size = 0;
   }
   public boolean isEmpty()                 // is the deque empty?
   {
       if(size <=0)
           return true;
   }
   public int size()                        // return the number of items on the deque
   {
       return size;
   }
   public void addFirst(Item item)          // insert the item at the front
   {
       if(item == null)
           throw new NullPointerException("attempted to add null in addFirst");
       
   }
   
   private void add(Node<Item> node, Item item , bool start = true)
   {
       
   }
   public void addLast(Item item)           // insert the item at the end
   {
       if(item == null)
           throw new NullPointerException("attempted to add null in addLast");
   }
   public Item removeFirst()                // delete and return the item at the front
   {
       if(isEmpty())
           throw new java.util.NoSuchElementException("attempted to remove from emty q in removeFirst");
       return null;
   }
   public Item removeLast()                 // delete and return the item at the end
   {
       if(isEmpty())
           throw new java.util.NoSuchElementException("attempted to remove from emty q in removeLast");
       return null;
   }
//   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
//   {
//       return null;
//   }
   public static void main(String[] args)   // unit testing
   {
   }
}