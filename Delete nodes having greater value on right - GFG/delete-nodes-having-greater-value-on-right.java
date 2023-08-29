//{ Driver Code Starts
import java.util.*;

class Node
{

    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class LinkedList
{
    
 

    /* Function to print linked list */
   public static void print(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }


    /* Driver program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }


            Node result = new Solution().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{
    Node compute(Node head)
    {
        List<Integer> list=new ArrayList<>();
        Node temp=head;
        while (temp!=null)
        {
            list.add(temp.data);
            temp=temp.next;
        }
        
        int n=list.size();
        int maxVal=list.get(n-1);
        for (int i=n-2;i>=0;i--)
        {
            if (list.get(i)>maxVal)
                maxVal=list.get(i);
            else
                list.set(i,maxVal);
        }
        
        temp=new Node(0);
        Node prev=temp;
        int pos=0;
        Node curr=head;
        
        while (curr!=null)
        {
            if (curr.data==list.get(pos))
            {
                prev.next=curr;
                prev=curr;
            }
            curr=curr.next;
            pos++;
        }
        
        return temp.next;
    }
}
  