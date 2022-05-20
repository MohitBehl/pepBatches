import java.util.*;
public class Main {
    // public static class Person{
    //     String name;
    //     int age;
    // }   
    public static class Node{
        int data;
        Node next;
    }
    // public static class LinkedList{
    //     Node head;
    //     Node tail;
    //     int size;

    //     void addLast(int val){
    //         Node node = new Node();
    //         node.data = val;

    //         if(this.size == 0){
    //             this.head = node;
    //             this.tail = node;
    //         }else{
    //             this.tail.next = node;
    //             this.tail = node;   
    //         }
    //         this.size++;
    //     }

    //     int size(){
    //         return this.size;
    //     }

    //     void display(){
    //         Node ptr = this.head;
    //         while(ptr != null){
    //             System.out.print(ptr.data+" ");
    //             ptr = ptr.next;
    //         }
    //         System.out.println();
    //     }

    //     void removeFirst(){
    //         if(this.size == 0) System.out.println("List is empty");
    //         else if(this.size == 1){
    //             this.head = this.tail = null;
    //             this.size = 0;
    //         }else{
    //             Node nbr = this.head.next;
    //             this.head.next = null;
    //             this.head = nbr;
    //             this.size--;
    //         }
    //     }

    //     int getFirst(){
    //         if(this.size == 0){
    //             System.out.println("List is empty");
    //             return -1;
    //         }
    //         return this.head.data;
    //     }
    //     int getLast(){
    //         if(this.size == 0){
    //             System.out.println("List is empty");
    //             return -1;
    //         }
    //         return this.tail.data;
    //     }
    //     int getAt(int idx){
    //         if(this.size == 0){
    //             System.out.println("List is empty");
    //             return -1;
    //         }
    //         if(idx < 0 || idx >= this.size){
    //             System.out.println("Invalid arguments");
    //             return -1;
    //         }
    //         Node ptr = this.head;
    //         while(idx != 0){
    //             ptr = ptr.next;
    //             idx--;
    //         }
    //         return ptr.data;
    //     }

    //     void addFirst(int val){
    //         Node node = new Node();
    //         node.data = val;

    //         if(this.size == 0){
    //             this.head = this.tail = node;
    //         }else {
    //             node.next = this.head;
    //             this.head = node;
    //         }

    //         this.size++;
    //     }

    //     void removeLast(){
    //         if(this.size == 0) System.out.println("List is empty");
    //         else if(this.size == 1){ this.head = this.tail = null; this.size = 0; }
    //         else {
    //             Node ptr = this.head;
    //             while(ptr.next != this.tail) ptr = ptr.next;

    //             ptr.next = null;
    //             this.tail = ptr;
    //             this.size--;
    //         }
    //     }
    //     void removeAt(int idx) {
    //         if(this.size == 0) System.out.println("List is empty");
    //         else if(idx < 0 || idx >= this.size) System.out.println("Invalid arguments");
    //         else if(idx == 0) this.removeFirst();
    //         else if(idx == this.size-1) this.removeLast();
    //         else {
    //             Node curr = this.head , prev = null;

    //             while(idx != 0){prev = curr; curr = curr.next; idx--;}

    //             prev.next = curr.next;
    //             curr.next = null;
    //             this.size--;
    //         }
    //     }
    //     // void addAt(int idx,int val){
    //     // }

    //     int kthFromLast(int k){
    //         Node slow , fast;
    //         slow = fast = this.head;

    //         while(k != 0){
    //             fast = fast.next;
    //             k--;
    //         }

    //         while(fast != this.tail){
    //             slow = slow.next;
    //             fast = fast.next;
    //         }

    //         return slow.data;
    //     }

    //     public static int findIntersection(LinkedList one, LinkedList two){
    //         int diff = one.size - two.size;
    //         Node p1 = one.head , p2 = two.head;
    //         if(diff < 0){
    //             while(diff != 0){
    //                 p2 = p2.next;
    //                 diff--;
    //             }
    //         }else if(diff > 0){
    //             while(diff != 0){
    //                 p1 = p1.next;
    //                 diff--;
    //             }
    //         }

    //         while(p1 != p2){
    //             p1 = p1.next;
    //             p2 = p2.next;
    //         }

    //         return p1.data;
    //     }
    // }

    public static class LLToStackAdapter {
        LinkedList<Integer> list;
    
        public LLToStackAdapter() {
          list = new LinkedList<>();
        }
        int size() {
            return list.size();
        }
        void push(int val) {
            list.addFirst(val);
        }
        int pop() {
            if(list.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            return list.removeFirst();
        }
        int top() {
            if(list.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            return list.getFirst();
        }
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        System.out.println(ll.size());
        ll.display();
        // Person p1 = new Person();
        // System.out.println(p1.name+" "+p1.age);
        // p1.name = "rohit";
        // p1.age = 23;
        // System.out.println(p1.name+" "+p1.age);
    }
}
