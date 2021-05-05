import java.util.*;

public class PQUsage {

    static class Student implements Comparable<Student>{
        int rno , marks , rank;

        Student(int rno,int marks,int rank){
            this.rno = rno;
            this.marks = marks;
            this.rank = rank;
        }
        public int compareTo(Student o){
            return this.marks - o.marks;
        }

        public String toString(){
            return "rno : "+this.rno+" marks : "+this.marks+" rank : "+this.rank;
        }
    }

    static class StudentRankComparator implements Comparator<Student>{
        // s1-s2 : min
        // s2-s1 : max
        public int compare(Student s1 , Student s2){
            return s2.rank - s1.rank;
        }
    }

    static class StudentRollComparator implements Comparator<Student>{
        // s1-s2 : min
        // s2-s1 : max
        public int compare(Student s1 , Student s2){
            return s1.rno - s2.rno;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(new StudentRollComparator());
        pq.add(new Student(5,50,25));
        pq.add(new Student(16,75,10));
        pq.add(new Student(1,0,30));
        pq.add(new Student(10,25,28));
        pq.add(new Student(7,30,27));
        pq.add(new Student(12,60,20));

        while(pq.size() > 0){
            System.out.println(pq.remove());
        }
        
        
    }
    
}
