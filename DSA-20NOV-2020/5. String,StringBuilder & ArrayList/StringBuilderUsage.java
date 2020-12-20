public class StringBuilderUsage {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("hello");
        
        System.out.println(sb);
        
        sb.append(" world"); // to add string at the end
        System.out.println(sb); 
        
        System.out.println(sb.charAt(6)); // character get
        
        System.out.println(sb.length()); // to get number of characters
        
        String s = sb.toString();
        System.out.println(s); // toString() --> sb return value as string
        
        sb.insert(1,'t');
        
        System.out.println(sb);
        
        sb.deleteCharAt(3);
        
        System.out.println(sb);
        
        System.out.println(sb.reverse());
        
        // sb = sb.toString(); // error
    }
}
