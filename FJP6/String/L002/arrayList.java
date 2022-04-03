import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		System.out.println(list+" "+list.size());

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		System.out.println(list+" "+list.size());

		for(int i = 0 ; i < list.size() ; i++){
			System.out.println(list.get(i));
		}
		System.out.println("----------------------------");
		for(int vl : list){
			System.out.println(vl);
		}
		System.out.println("----------------------------");
		int rele = list.remove(0);
		System.out.println("removed ele : "+rele+" list : "+list);

		System.out.println(list);
		list.add(3,1000);
		System.out.println(list);
	}

}