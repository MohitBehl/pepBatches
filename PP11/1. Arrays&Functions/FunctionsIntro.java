public class FunctionsIntro {
    
    public static void saysHello(){
        System.out.println("Hello from user !!");
    }
    
    public static int add(int v1,int v2){
        return v1+v2;
    }
    
    public static boolean isEven(int num){
        return (num%2)==0;
    }
    
    public static int area(int side){
        return side*side;
    }
    public static int area(int len,int bre){
        return len*bre;
    }
    public static void main(String[] args) {
        // saysHello();
        // System.out.println(add(1646,365));
        // isEven(226);
        
        int areaOfSq = area(10);
        int areaOfRect = area(5,25);
        
        System.out.println(areaOfSq);
        System.out.println(areaOfRect);
    }
}
