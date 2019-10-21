package übung15;

import java.io.FileInputStream;
import java.util.Scanner;

public class Exceptions {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a;
		int b[] = new int[1];
		Integer i = null;

		try {
			System.out.println("Bitte geben Sie eine Zahl ein");
			String s = scanner.nextLine();

//			a)NumberFormatException 
			a = Integer.valueOf(s);

//			b)ArrayIndexOutOfBoundsException 			
			b[0] = a;

//			c)NullPointerException
//			i.toString();

//			d)OutOfMemoryError
//			throw new OutOfMemoryError();
//			e)
			FileInputStream fis = new FileInputStream("shit.html");
//			f) ArithmeticException
			a = 5 / 0;

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
