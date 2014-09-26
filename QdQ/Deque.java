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
       else 
           return false;
   }
   public int size()                        // return the number of items on the deque
   {
       return size;
   }
   public void addFirst(Item item)          // insert the item at the front
   {
       if(item == null)
           throw new NullPointerException("attempted to add null in addFirst");
       
       Node<Item> p = null;
       Node<Item> v = first;
       Node<Item> n = new Node<Item>(item,p,v);
       
       if(first != null)
       {
           first.prev = n;
       }
       
       first  = n;
       
       if(last == null )
       {
           last = n;
       }
       size++;
   }
   
//   private void add(Node<Item> node, Item item , bool start = true)
//   {
//       if(start)
//       {
//           node<
//           
//       }else
//       {
//       }
//   }
   public void addLast(Item item)           // insert the item at the end
   {
       if(item == null)
           throw new NullPointerException("attempted to add null in addLast");
       
       Node<Item> p = last;
       Node<Item> v = null;
       Node<Item> n = new Node<Item>(item,p,v);
       
       if(last != null)
       {
           last.next = n;
       }
       
       last  = n;
       
       if(first == null )
       {
           first = n;
       }
       
       size++;
   }
   public Item removeFirst()                // delete and return the item at the front
   {
       if(isEmpty())
           throw new java.util.NoSuchElementException("attempted to remove from emty q in removeFirst");
       
       Node<Item> forget = first;
       Item item = forget.value;
       
       if(forget.next != null)
       {
           first = forget.next;
           first.prev = null;
       }
       
       forget.next = null;
       forget.prev = null;
       
       forget = null;
       
       return item;
   }
   public Item removeLast()                 // delete and return the item at the end
   {
       if(isEmpty())
           throw new java.util.NoSuchElementException("attempted to remove from emty q in removeLast");
       Node<Item> forget = last;
       Item item = forget.value;
       
       if(forget.prev != null)
       {
           last = forget.prev;
           first.prev = null;
       }
       
       forget.next = null;
       forget.prev = null;
       
       forget = null;
       
       return item;
       
   }
//   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
//   {
//       return null;
//   }
   public static void main(String[] args)   // unit testing
   {
   }
}