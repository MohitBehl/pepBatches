public class Main {
    public static void main(String[] args) {
        stringBuilderIntro();   
    }
    public static void stringBuilderIntro(){
        // creation
        StringBuilder sb = new StringBuilder("123");

        // print
        System.out.println("data : "+sb);

        sb.append("hello");

        System.out.println(sb);

        System.out.println(sb.toString());

        System.out.println(sb.length());

        System.out.println(sb.reverse());

        for(int i = 0 ; i < sb.length() ; i++){
            System.out.println(sb.charAt(i));
        }

        sb.deleteCharAt(2);

        System.out.println(sb);

        sb.insert(0,"world");
        System.out.println(sb);

        sb.setCharAt(0, 'z');

        System.out.println(sb);
    }

    public static String compression2(String str){
        StringBuilder ans = new StringBuilder();
        
        // String ans = ""+str.charAt(0);
        ans.append(str.charAt(0));
        int idx = 1;
        int count = 1;
        while(idx < str.length()){
            char curr = str.charAt(idx);
            char prev = str.charAt(idx-1);

            if(curr == prev){
                count++;
            }else{
                if(count > 1){
                    // ans = ans + count;
                    ans.append(count);
                }
                // ans = ans + curr;
                ans.append(curr);
                count = 1;
            }
            idx++;
        }
        if(count > 1){
            // ans = ans + count;
            ans.append(count);
        }

		return ans.toString();
	}
}
