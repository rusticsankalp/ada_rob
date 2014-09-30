import java.util.Iterator;
public class Deque<Item> implements Iterable<Item>
{
   private class Node<T>
   {
       public Node(T val, Node<T> p, Node<T> n)
       {
           //StdOut.printf("Node \n");
           prev = p; 
           next = n;
           //:BugResolved , this statement was missing
           value = val;
       }
       public T value;
       public Node<T> prev, next;
   }
   
   private class DQIterator implements Iterator<Item>
   {
       DQIterator(Node<Item> vn)
       {
           node = vn;
       }
       Node<Item> node;
       
       //:BugResolved i was checking node.next!=null
       public boolean hasNext() 
       {
           return (node != null);
       }
       public void remove() 
       {
           throw new java.util.NoSuchElementException(
                "Remove is not supported for this iterator");
       }
       public Item next() 
       { 
           Item item = node.value; 
           node = node.next; 
           return item; 
       }
   }
   
   private Node<Item> first, last;
   private int size;
   public Deque()                           // construct an empty deque
   {
       first = null;
       last = null;
       size = 0;
       //StdOut.printf("Deque :: contructor \n");
   }
   public boolean isEmpty()                 // is the deque empty?
   {
       //StdOut.printf("isEmpty :: %B \n", size <= 0);
       if (size <= 0)
           return true;
       else 
           return false;
   }
   public int size()             // return the number of items on the deque
   {
       return size;
   }
   public void addFirst(Item item) // insert the item at the front
   {
       //StdOut.printf("addFirst \n");
       if (item == null)
           throw new NullPointerException("attempted to add null in addFirst");
       
       Node<Item> p = null;
       Node<Item> v = first;
       Node<Item> n = new Node<Item>(item, p, v);
       
       if (first != null)
       {
           first.prev = n;
       }
       
       first  = n;
       
       if (last == null)
       {
           last = n;
       }
       
       //StdOut.printf("addFirst :: first.value : %d ", first.value);
       //StdOut.printf(" ,first.next : %B ",first.next != null );
       //StdOut.printf(" ,first.prev : %B \n",first.prev != null );
       //StdOut.printf("addFirst :: last.value : %d ", last.value);
       //StdOut.printf(" ,last.next : %B ",last.next != null );
       //StdOut.printf(" ,last.prev : %B \n",last.prev != null );
       
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
       if (item == null)
           throw new NullPointerException("attempted to add null in addLast");
       
       Node<Item> p = last;
       Node<Item> v = null;
       Node<Item> n = new Node<Item>(item, p, v);
       
       if (last != null)
       {
           last.next = n;
       }
       
       last  = n;
       
       if (first == null)
       {
           first = n;
       }
       size++;
   }
   public Item removeFirst() // delete and return the item at the front
   {
       //StdOut.printf("removeFirst \n");
       if (isEmpty())
           throw new java.util.NoSuchElementException(
                   "attempted to remove from empty q in removeFirst");
       
       Node<Item> forget = first;
       Item item = forget.value;
       
//       if(item == null)
//       {
//           StdOut.printf("removeFirst :: item is null \n");
//       }
       
       //StdOut.printf("removeFirst :: forget.value received \n");
       
       if (forget.next != null)
       {
           first = forget.next;
           first.prev = null;
           //StdOut.printf("removeFirst :: next !=null \n");
       }
//       else
//       {
//           StdOut.printf("removeFirst :: next ==null \n");
//       }
       //StdOut.printf("removeFirst :: next null check ok\n");
       forget.next = null;
       forget.prev = null;
       
       forget = null;
       
       //StdOut.printf("removeFirst :: ready to return ok\n");
       size--;
       return item;
   }
   public Item removeLast()  // delete and return the item at the end
   {
       if (isEmpty())
           throw new java.util.NoSuchElementException(
                "attempted to remove from empty q in removeLast");
       Node<Item> forget = last;
       Item item = forget.value;
       
       if (forget.prev != null)
       {
           last = forget.prev;
           first.prev = null;
       }
       
       forget.next = null;
       forget.prev = null;
       
       forget = null;
       size--;
       
       return item;
       
   }
   
   // return an iterator over items in order from front to end
   public Iterator<Item> iterator()         
   {
       return new DQIterator(first);
   }
   
   
   public static void main(String[] args)   // unit testing
   {
       
   }
}