 
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
    public class hardick
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
                    int num=in.nextInt();
                    Node start = new Node(num);
                    int ch=0;
                    num=in.nextInt();
                    while(num!=-1)
                    {
                            System.out.println("1. Insertion at start\n2. Insertion at end");
                            ch=in.nextInt();
                            if(ch==1)
                            {           
                                    start=start.PushToStart(num);
                            }
                            else
                            {
                                    start.PushToEnd(num);
                            }
                            System.out.println("more??");
                                    num=in.nextInt();
                    }
                    return start;
            }
            public static void printlist(Node start)
            {
                    start.PrintList();
            }
    }
