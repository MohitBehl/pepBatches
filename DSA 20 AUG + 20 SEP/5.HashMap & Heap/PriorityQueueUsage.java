import java.util.*;

public class PriorityQueueUsage {
    
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
            return o2.ht-o1.ht;
        }
    }
    
    static class StudentWtComparator implements Comparator<Student>{
        public int compare(Student o1 , Student o2){
            return o1.wt-o2.wt;
        }
    }


    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(new StudentWtComparator());
        
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