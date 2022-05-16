public class Main {
    // public static class Person{
    //     String name;
    //     int age;
    // }   
    public static class Node{
        int data;
        Node next;
    }
    public static class LinkedList{
        Node head;
        Node tail;
        int size;

        void addLast(int val){
            Node node = new Node();
            node.data = val;

            if(this.size == 0){
                this.head = node;
                this.tail = node;
            }else{
                this.tail.next = node;
                this.tail = node;   
            }
            this.size++;
        }

        int size(){
            return this.size;
        }

        void display(){
            Node ptr = this.head;
            while(ptr != null){
                System.out.print(ptr.data+" ");
                ptr = ptr.next;
            }
            System.out.println();
        }

        void removeFirst(){
            
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
