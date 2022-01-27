public class Sample {
    public static class example{
        int x;
        static int y;

        public String toString(){
            return "X : "+x+" Y : "+y;
        }
    }
    public static void main(String args[]){
        // example o1 = new example();
        // o1.x = 5;
        // o1.y = 10;
        // System.out.println(o1);

        // example o2 = new example();
        // o2.x = 1;
        // o2.y = 2;

        // System.out.println(o2);

        // System.out.println(o1);

        System.out.println(example.y);

        example.y = 1000;
        System.out.println(example.y);
    }
}
