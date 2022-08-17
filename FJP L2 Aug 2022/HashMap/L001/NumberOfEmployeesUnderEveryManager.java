import java.io.*;
import java.util.*;
class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    HashMap<String,HashSet<String>> tree = new HashMap<>();
    String ceo = "";
    for(int i = 0 ; i < n ; i++){
        String emp = scn.next() , manager = scn.next();

        if(emp.equals(manager)){
            ceo = emp;
            continue;
        }

        HashSet<String> emplist = tree.get(manager);
        if(emplist == null){
            emplist = new HashSet<>();
            emplist.add(emp);
            tree.put(manager,emplist);
        }else{
            emplist.add(emp);
        }
    }

    HashMap<String,Integer> ans = new HashMap<>();
    traverse(tree,ceo,ans);

    for(String manager : ans.keySet()){
        int freq = ans.get(manager);
        System.out.println(manager+" "+freq);
    }
  }

  public static int traverse(HashMap<String,HashSet<String>> tree,String manager,HashMap<String,Integer> ans){
      HashSet<String> empList = tree.get(manager);
      if(empList == null){
          ans.put(manager,0);
          return 1;
      }
      int size = 0;
      for(String emp : empList){
        size +=  traverse(tree,emp,ans);
      }
      
      ans.put(manager,size);

      return size+1;
  }

}