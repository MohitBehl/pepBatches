public class Main{
    public static class Node{
        int data;
        Node left,right;
    }
    public static Node construct(int input[],int lo,int hi){
        if(lo > hi)
            return null;
        int mid = (lo+hi)/2;
        Node node =  new Node();

        node.data = input[mid];
        node.left = construct(input,lo,mid-1);
        node.right = construct(input,mid+1,hi);

        return node;
    }
    public static void display(Node node){
        if(node == null){
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data;
        str += " <- "+node.data+" -> ";
        str += node.right == null ? "." : node.right.data;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    public static int size(Node node){
        if(node == null){
            return 0;
        }
        int lSize = size(node.left);
        int rSize = size(node.right);
        return lSize + rSize + 1;
    }

    public static int sum(Node node){
        if(node == null){
            return 0;
        }
        int lSum = sum(node.left);
        int rSum = sum(node.right);
        return lSum + rSum + node.data;
    }

    public static int max(Node node){
        if(node.right == null){
            return node.data;
        }
        
        return  max(node.right);
    }

    public static int min(Node node){
        if(node.left == null){
            return node.data;
        }
        
        return  min(node.left);
    }
    
    public static boolean find(Node node ,int ele){
        if(node == null){
            return false;
        }
        if(ele == node.data){
            return true;
        }else if(ele > node.data){
            return find(node.right,ele);
        }else{
            return find(node.left,ele);
        }
    }

    public static int LCA(Node node,int d1,int d2){
        if(d1 < node.data && d2 < node.data){
            return LCA(node.left,d1,d2);
        }else if(d1 > node.data && d2 > node.data){
            return LCA(node.right,d1,d2);
        }else{
            return node.data;
        }
    }

    static int sum = 0;
    public static void rwsol(Node node){
        if(node == null){
            return;
        }

        rwsol(node.right);
        
        int val = node.data;
        node.data = sum;
        sum += val;

        rwsol(node.left);
    }

    public static void pir(Node node, int d1, int d2) {
        if(node == null){
            return;
        }else if(d1 < node.data && d2 < node.data){
            pir(node.left,d1,d2);
        }else if(d1 > node.data && d2 > node.data){
            pir(node.right,d1,d2);
        }else{
            pir(node.left,d1,d2);
            System.out.println(node.data);
            pir(node.right,d1,d2);
        }
    }

    private static void targetSumPair1(Node node,ArrayList<Integer> list){
        if(node == null){
            return;
        }
        targetSumPair1(node.left,list);
        list.add(node.data);
        targetSumPair1(node.right,list);
    }
    public static void targetSumPair1(Node root,int target){
        ArrayList<Integer> list = new ArrayList<>();
        targetSumPair1(root,list);

        int p1 = 0 , p2 = list.size()-1;
        while(p1 < p2){
            int v1 = list.get(p1);
            int v2 = list.get(p2);

            if(v1+v2 < target){
                p1++;
            }else if(v1 + v2 > target){
                p2--;
            }else{
                System.out.println(v1+" "+v2);
                p1++;
                p2--;
            }
        }
    }

        public static void targetSumPair2(Node node,Node root,int target){
            if(node == null){
                return;
            }

            targetSumPair2(node.left,target);
            int cVal = target - node.data;

            if(node.data < cVal){
                if(find(root,cVal)){
                    System.out.println(node.data+" "+cVal);
                }
            }

            targetSumPair2(node.right,target);
        }   
    public static void main(String args[]){
        int input[] = {12,25,30,37,50,62,70,75,87};

        Node root = construct(input,0,input.length-1);

        display(root);
    }
}