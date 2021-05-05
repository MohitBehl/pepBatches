import java.io.*;
import java.util.*;

public class PQUsingHeap {

  public static class PriorityQueue<T> {
    ArrayList<T> data;
    Comparator<T> comp; // alternate logic for comparing two values

    public PriorityQueue() {
      data = new ArrayList<>();
      comp = null;
    }

    public PriorityQueue(Comparator<T> comp) {
      data = new ArrayList<>();
      this.comp = comp;
    }

    public void add(T val) {
      data.add(val);
      upHeapify(data.size()-1);
    }
    private boolean isSmaller(int cidx,int pidx){
      if(comp == null){
        Comparable child = (Comparable) data.get(cidx);
        Comparable par = (Comparable) data.get(pidx);
  
        if(child.compareTo(par) < 0){
          return true;
        }else{
          return false;
        }
      }else{
        T child =  data.get(cidx);
        T par =  data.get(pidx);

        if(comp.compare(child, par) < 0){
          return true;
        }else{
          return false;
        }
      }
    }
    public void upHeapify(int idx){
        if(idx == 0){
            return;
        }
        
        int pidx = (idx-1)/2;
        
        if(isSmaller(idx, pidx) == true){
            T cVal = data.get(idx);
            T pVal = data.get(pidx);
            data.set(pidx,cVal);
            data.set(idx,pVal);
            
            upHeapify(pidx);
        }
    }

    public T remove() {
      if(data.size() == 0){
          System.out.println("Underflow");
          return null;
      }
      T val = data.get(0);
      data.set(0,data.get(data.size()-1));
      data.remove(data.size()-1);
      downHeapify(0);
      return val;
    }
    
    public void downHeapify(int idx){
        int lidx = (2*idx)+1;
        int ridx = (2*idx)+2;
        
        int minIdx = idx;
        
        if(lidx < data.size() && isSmaller(lidx,minIdx) == true){
            minIdx = lidx;
        }
        
        if(ridx < data.size() && isSmaller(ridx,minIdx) == true){
            minIdx = ridx;
        }
        
        if(minIdx != idx){
            T val = data.get(idx);
            T minVal = data.get(minIdx);
            
            data.set(idx,minVal);
            data.set(minIdx,val);
            
            downHeapify(minIdx);
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
          return s2.rno - s1.rno;
      }
  }
  
  public static void main(String[] args) throws Exception {
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