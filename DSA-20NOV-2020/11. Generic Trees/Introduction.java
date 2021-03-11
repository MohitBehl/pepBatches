import java.util.*;

public class Main {
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    
    public static Node Construct(Integer input[]){
        Node root = new Node();
        root.data = input[0];
        Stack<Node> st = new Stack<>();
        st.push(root);
        for(int idx = 1 ; idx < input.length ; idx++){
            Integer val = input[idx];
            if(val == null){
                st.pop();
            }else{
                Node node = new Node();
                node.data = val;
                st.peek().children.add(node);
                st.push(node);
            }
        }
        return root;
    }
    
    public static void display(Node node){
        // self printing 
        System.out.print(node.data+"->");
        for(Node childNode : node.children){
            System.out.print(childNode.data+" ");
        }
        System.out.println(".");
        
        for(Node childNode : node.children){
            display(childNode);
        }
    }
    public static int size(Node node){
        int ans = 0;
        for(Node child : node.children){
            ans += size(child);
        }
        ans += 1;
        return ans;
    }
    

    public static boolean find(Node node, int ele) {
        if(node.data == ele){
            return true;
        }
        
        for(Node child : node.children){
            if(find(child,ele)){
                return true;
            }
        }
        
        return false; //imply : element doesn't exist in this tree-node
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int ele){
        if(node.data == ele){
            ArrayList<Integer> al  = new ArrayList<Integer>();
            al.add(node.data);
            return al;
        }
        
        for(Node child : node.children){
            ArrayList<Integer> path = nodeToRootPath(child,ele);
            if(path.size() != 0){
                path.add(node.data);
                return path;
            }
        }
        
        return new ArrayList<Integer>();
     }

     public static int lca(Node node, int d1, int d2) {
        ArrayList<Integer> al1 = nodeToRootPath(node,d1);
        ArrayList<Integer> al2 = nodeToRootPath(node,d2);
        
        int i = al1.size()-1 , j = al2.size()-1;
        
        while(i >= 0 && j >= 0){
            int v1 = al1.get(i);
            int v2 = al2.get(j);
            if(v1 == v2){
                i--;
                j--;
            }else{
                break;
            }
        }
        
        return al1.get(i+1);
      }

      public static int distanceBetweenNodes(Node node, int d1, int d2){
        ArrayList<Integer> al1 = nodeToRootPath(node,d1);
        ArrayList<Integer> al2 = nodeToRootPath(node,d2);
        
        int i = al1.size()-1 , j = al2.size()-1;
        
        while(i >= 0 && j >= 0){
            int v1 = al1.get(i);
            int v2 = al2.get(j);
            if(v1 == v2){
                i--;
                j--;
            }else{
                break;
            }
        }
        
        i++;
        j++;
        
        return i+j;
      }


  static int state = -1;
  static Node predecessor;
  static Node successor;
  public static void predecessorAndSuccessor(Node node, int ele) {
      if(state == -1){
          if(node.data == ele){
              state = 0;
          }else{
              predecessor = node;
          }
      }else if(state == 0){
          successor = node;
          state = 1;
      }else if(state == 1){
          // do nothing
      }
      
    for(Node child : node.children){
        predecessorAndSuccessor(child,ele);
    }
  }


  static int ceil;
  static int floor;
  public static void ceilAndFloor(Node node, int ele) {
      if(node.data > ele){
          // larger
          if(node.data < ceil){
              // minimum
              ceil = node.data;
          }
      }else if(node.data < ele){
          // smaller
          if(node.data > floor){
              // maximum
              floor = node.data;
          }
      }
    for(Node child : node.children){
        ceilAndFloor(child,ele);
    }
  }
  

    public static void main(String[] args) {
        Integer input[] = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = Construct(input);
        System.out.println(root.data);
        display(root);
    }
}
