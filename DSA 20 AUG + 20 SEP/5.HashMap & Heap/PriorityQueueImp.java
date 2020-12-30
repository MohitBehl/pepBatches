import java.io.*;
import java.util.*;

public class PriorityQueueImp {

    public static class PriorityQueue<T> {
        ArrayList < T > data;
        Comparator< T > comp;

        public PriorityQueue() {
            data = new ArrayList < > ();
            comp = null;
        }

        public PriorityQueue(Comparator<T> comp) {
            data = new ArrayList < > ();
            this.comp = comp;
        }

        public void add(T val) {
            data.add(val);
            upHeapify(data.size()-1);
        }
        
        private void swap(int i,int j){
            T ith = data.get(i);
            T jth = data.get(j);
            
            data.set(i,jth);
            data.set(j,ith);
        }

        // compare(i,j); if(HOP voilated) return true otherwise return false;
        private boolean compare(int i,int j){
            if(comp == null){
                Comparable ith = (Comparable)data.get(i);
                Comparable jth = (Comparable)data.get(j);
                
                if(ith.compareTo(jth) < 0){
                    // HOP voilated
                    return true;
                }else{
                    // HOP not-voilated
                    return false;
                }
            }else{

                T o1 = data.get(i);
                T o2 = data.get(j);

                if(comp.compare(o1, o2) < 0){
                    // HOP voilated
                    return true;
                }else{
                    // HOP not-voilated
                    return false;
                }
            }
        }

        private void upHeapify(int idx){
            if(idx == 0){
                return;
            }
            
            int pidx = (idx-1)/2;
            if(compare(idx,pidx) == true){
                swap(pidx,idx);
                upHeapify(pidx);
            }
        }

        public T remove() {
            if(data.size() == 0){
                System.out.println("Underflow");
                return null;
            }
            
            swap(0,data.size()-1);
            T val = data.remove(data.size()-1);
            downHeapify(0);
            return val;
        }
        
        private void downHeapify(int pidx){
            int mini = pidx;
            
            int lidx = 2*pidx + 1;
            int ridx = 2*pidx + 2;
            
            if(lidx < data.size() && compare(lidx,mini) == true){
                mini = lidx;
            }
            
            if(ridx < data.size() && compare(ridx,mini) == true){
                mini = ridx;
            }
            
            if(mini != pidx){
                swap(mini,pidx);
                downHeapify(mini);
            }
            
        }

        public T peek() {
            if(data.size() == 0){
                System.out.println("Underflow");
                return null;
            }
            return data.get(0);
        }

        public int size() {
            return data.size();
        }
    }

    static class Student implements Comparable<Student>{
        String name;
        int ht;
        int wt;
        int marks;
        
        Student(String name,int ht,int wt,int marks){
            this.name = name;
            this.ht = ht;
            this.wt = wt;
            this.marks = marks;
        }
        
        public int compareTo(Student o){
            return this.marks-o.marks;
        }
        
        public String toString(){
            return "name :"+name+"\tht:"+ht+"\twt:"+wt+"\tmarks:"+marks;
        }
    }

    static class StudentHtComparator implements Comparator<Student>{
        public int compare(Student o1 , Student o2){
            return o1.ht-o2.ht;
        }
    }
    
    static class StudentWtComparator implements Comparator<Student>{
        public int compare(Student o1 , Student o2){
            return o1.wt-o2.wt;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(new StudentHtComparator());
        
        pq.add(new Student("alex",150,70,95));
        pq.add(new Student("abc",142,85,75));
        pq.add(new Student("def",160,76,80));
        pq.add(new Student("ghi",100,72,30));
        pq.add(new Student("jkl",145,65,45));
        
        while(pq.size() > 0){
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}