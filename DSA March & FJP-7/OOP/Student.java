package OOP;
public class Student {
    static int studentCount;
    private String name;
    private int rollno;

    // constructors
    Student(){
        studentCount += 1;
        System.out.println("YAY , we got a new admission");
        name = "-";
        rollno = 1;
    }
    Student(String name,int rollno){
        studentCount += 1;
        this.name = name;
        this.rollno = rollno;
    }

    // getters & setters
    static int getCount(){
        return studentCount;
    }
    String getname(){
        return name;
    }
    int getrollno(){
        return rollno;
    }
    void setname(String user_name){
        if(user_name.length() == 0){
            System.out.println("error");
            return;
        }
        name = user_name;
    }
    void setrollno(int user_rollno){
        if(user_rollno <= 0){
            System.out.println("error");
            return;
        }
        rollno = user_rollno;
    }
    //-------------------------------
    public void introduceYourself(){
        System.out.println("Hello , my name is "+name+". My rollno is "+rollno);
    }

}
