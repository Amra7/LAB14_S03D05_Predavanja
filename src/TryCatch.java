import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
	public static void main(String[] args) {
	Scanner s = new Scanner (System.in);
	int broj=0;
	
	try {
		 broj = s.nextInt();
		
	} catch (InputMismatchException e){
		System.out.println("broj!!!");
		return;
	} finally  {
		s.close();
	}
	System.out.println("Unijeli ste broj " + broj);

}
}
