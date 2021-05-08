public class SBIntro {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("hello");

        System.out.println(sb);

        char ch = sb.charAt(4);
        System.out.println(ch);

        // System.out.println(sb.reverse());
        // System.out.println(sb);

        sb.append('z');
        System.out.println(sb);

        sb.append(" world");
        sb.append(123);

        System.out.println(sb);
        System.out.println(sb.length());

        sb.setCharAt(0, 'y');

        System.out.println(sb);

        sb.deleteCharAt(0);
        System.out.println(sb);

        System.out.println(sb.substring(5));

        System.out.println(sb.toString()); // toString() : intern
    }
}
