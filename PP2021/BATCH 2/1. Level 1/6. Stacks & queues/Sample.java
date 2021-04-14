public class Sample{
    public static void main(String args[]){
       Area obj = new Area();

       System.out.println(obj.showLen());
    }
}

class Area{
    private int l = 5;
    private int b = 10;

    public int area(){
        return area(l,b);
    }
    public int showLen(){
        return l;
    }
    private int area(int x,int y){
        return x*y;
    }
}