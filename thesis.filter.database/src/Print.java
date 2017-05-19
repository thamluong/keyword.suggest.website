package print.Print;
import java.util.List;

public class Print {
	
	public static void print(String s){
		System.out.println(s);
	}

	public static void print(String temp, String s){
		System.out.println(temp + " = " + s);
	}
	
	public static void print(List<String> list){
		for(String s : list) 
			System.out.println(s);
	}
	
}
