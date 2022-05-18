package Hash;

class Node{
    String data;
    Node next=null;
    public Node(String data){
        this.data=data;
    }
    public Node(){}
    public void display() {  
        System.out.print(this.data);
   }  
}

public class LinkedList {
    Node head = new Node();
    int k = 0;

    public void add (String val) {
        Node newnode = new Node(val);
        if (head.next != null) {
            newnode.next = head.next;
        }
        if (k != 0) {
            head.next = newnode;
        } else {
            head = newnode;
        }
        k++;
    }

    public int size(){
        int size=0;
        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
            size++;
        }
        return size++;
    }

    public void remove(int ind){
        int count = 0;
        Node ptr = head;
        Node main = new Node();

        while (count != ind) {
            if (count == 0) {
                main = new Node(ptr.data);
            } else {
                main.next = new Node(ptr.data);
            }
            ptr = ptr.next;
            count++;
        }

        
        ptr = ptr.next;
        while (ptr != null) {
            if (count == 0) {
                main = new Node(ptr.data);
            } else {
                main.next = new Node(ptr.data);
            }
            ptr = ptr.next;
        }
        head = main;
        k--;
    }

    public String get(int ind) {
        int count = 0;
        Node ptr = head;
        while (count != ind) {
            ptr = ptr.next;
            count++;
        }
        return ptr.data;
    }

    public void print() {
        Node ptr = head;
        for (int i = 0; i <= this.size(); i++) {
            if (i == 0) {
                System.out.print(ptr.data);
            } else {
                System.out.print("->" + ptr.data);
            }
            ptr = ptr.next;
        }
    }
}

