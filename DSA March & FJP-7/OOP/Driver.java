package OOP;
public class Driver{
    public static void main(String args[]){
        Student s1 = new Student("mohit",10); // new object
        // s1.setname("xbvhasd");
        // s1.setrollno(0);
        // s1.introduceYourself();


        Student s2 = new Student("pep",3); // new object
        // s2.introduceYourself();

        System.out.println(s1.getCount());
        System.out.println(s2.getCount());
        System.out.println(Student.getCount());
        System.out.println(Student.studentCount);
    }
}