public static class Node {
    int data;
    Node next;
}

public static class LinkedList {
    Node head;
    Node tail;
    int size;

    void addLast(int val) {
        Node node = new Node(); // node creation
        node.data = val;

        if (size == 0) {
            // first addition to the list
            head = tail = node;
        } else if (size != 0) {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public int size() {
        return size;
    }

    public void display() {
        for (Node tmp = head; tmp != null; tmp = tmp.next) {
            System.out.print(tmp.data + " ");
        }
        System.out.println();
    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
        } else {
            // removal
            //  1. store nextHead
            Node nextHead = head.next;
            //  2. remove the connection from the main list
            head.next = null;
            //  3. set head to it's proper place
            head = nextHead;

            // decrease the size
            size--;

            if (size == 0) {
                tail = null;
            }
        }
    }

    public void addFirst(int val) {
        Node node = new Node();
        node.data = val;

        if (size == 0) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }

        size++;
    }

    public int getFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        return head.data;
    }

    public int getLast() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        return tail.data;
    }

    public int getAt(int idx) {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }

        if (idx < 0 || idx >= size) {
            //   invalid idx
            System.out.println("Invalid arguments");
            return -1;
        } else {
            //   valid idx
            if (idx == 0) {
                return getFirst();
            } else if (idx == size - 1) {
                return getLast();
            } else {
                Node tmp = head;
                for (int count = 0; count < idx; count++) {
                    tmp = tmp.next;
                }
                return tmp.data;
            }
        }
    }

    public void addAt(int idx, int val) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid arguments");
            return;
        }

        if (idx == 0) {
            addFirst(val);
        } else if (idx == size) {
            addLast(val);
        } else {
            Node tmp = head;
            int count = 1;
            while (count < idx) {
                tmp = tmp.next;
                count++;
            }

            Node node = new Node();
            node.data = val;

            Node newPtr = tmp.next;
            tmp.next = node;
            node.next = newPtr;

            size++;
        }
    }


    public void removeLast() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }
        if (size == 1) {
            // head = tail = null;
            // size--;
            removeFirst();
            return;
        }

        Node tmp = head;

        while (tmp.next != tail) {
            tmp = tmp.next;
        }

        //   tmp --> prev of tail
        tmp.next = null;
        tail = tmp;
        size--;
    }

    public void removeAt(int idx) {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
        } else {
            if (idx == 0) {
                removeFirst();
            } else if (idx == size - 1) {
                removeLast();
            } else {
                Node tmp = head;

                int count = 1;
                while (count < idx) {
                    tmp = tmp.next;
                    count++;
                }

                Node nextPtr = tmp.next.next;
                tmp.next.next = null;
                tmp.next = nextPtr;

                size--;
            }
        }
    }

}