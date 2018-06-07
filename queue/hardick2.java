import java.util.Scanner;
class Node
{
int data;
Node next;
Node(int num)
{
data=num;
next=null;
}
public void PushToEnd(int num)
{
Node start=this;
if(start==null)
return;
while(start.next!=null)
{
start=start.next;
}
Node newnode=new Node(num);
start.next=newnode;
}
public Node PushToStart(int num)
{
Node start=this;
Node newnode=new Node(num);
newnode.next=start;
return newnode;
}
    public Node PushToPos(int num, int pos)
    {
        Node start=this;
        Node newnode=new Node(num);
        if(pos==1) {
newnode.next = start;
return newnode;
}
else
{
Node previous = start;
int count=1;
while(count< pos-1) {
previous = previous.next;
count++;
}

                    Node current = previous.next;
                    newnode.next = current;
                    previous.next = newnode;
                    return start;
                }
        }
        public Node deleteFirst(Node start)
        {
            if(start==null)
            {
                return start;
            }
    
           return start.next;
        }
        public Node deleteLast(Node start)
        {
            if(start == null)
            {
                return start;
            }
    
            Node last = start;
            Node previousToLast = null;
    
            while(last.next != null) {
                previousToLast = last;
                last = last.next;
            }
            previousToLast.next = null;
            return start;
        }
        public Node deletePos(Node start, int pos) {
            if(pos<1) {
                return start;
            }
    
            if(pos== 1)
            {
                start=null;
                return start;
            }
            else {
                Node previous = start;
                int count = 1;
                while(count < pos-1) {
                    previous = previous.next;
                    count++;
                }
    
                Node current = previous.next;
                previous.next = current.next;
                current.next = null;
                return start;
            }
        }
        public void PrintList()
        {
                Node start=this;
                log("list is");
                while(start!=null)
                {
                        log(start.data);
                        start=start.next;
                }
        }
        public void log(int num)
        {
                System.out.println(num);
        }
        public void log(String string)
        {
                System.out.println(string);
        }

}
public class hardick2
{
public static void main(String args[]) {
System.out.println("menu driven");
System.out.println("insertion ");
Node head=create();
printlist(head);

        }
    
        public static Node create()
        {
                Scanner in = new Scanner(System.in);
                System.out.println("Insert First Node");
                int num=in.nextInt();
                Node start = new Node(num);
                int ch=0;
                System.out.println("1. Insertion at start\n2. Insertion at end\n3. Insertion at position");
                System.out.println("4. Deletion at start\n5. Deletion at end\n6. Deletion at position \n 7. Exit");
                ch=in.nextInt();
                // System.out.println("more??");
                // num=in.nextInt();
                while(ch<8 && ch>0)
                {
                        if(ch==1)
                        {           
                               System.out.println("Value");
                               num=in.nextInt();
                               start=start.PushToStart(num);
                        }
                        else if(ch==2)
                        {
                               System.out.println("Value");
                               num=in.nextInt();
                                start.PushToEnd(num);
                        }
                        else if(ch==3)
                        {
                               System.out.println("Value");
                               num=in.nextInt();
                                System.out.println("enter position");
                                int pos=in.nextInt();
                                start=start.PushToPos(num, pos);
                        }
                        else if(ch==4)
                        {
                            start=start.deleteFirst(start);
                        }
                        else if(ch==5)
                        {
                            start=start.deleteLast(start);
                        }
                        else if(ch==6)
                        {
                                System.out.println("enter position");
                                int pos=in.nextInt();
                                start.deletePos(start, pos);
                        }
                        else
                        {
                            return start;
                        }
                        System.out.println("1. Insertion at start\n2. Insertion at end\n3. Insertion at position");
                        System.out.println("4. Deletion at start\n5. Deletion at end\n6. Deletion at position \n 7. Exit");
                                ch=in.nextInt();
                }
                return start;
        }
        public static void printlist(Node start)
        {
                start.PrintList();
        }

}
