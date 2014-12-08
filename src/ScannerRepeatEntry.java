import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerRepeatEntry {
	public static void main(String[] args) {
		
		int broj=0;
		boolean fail = true;
        Scanner s = null;

		do {
			try {
				s = new Scanner ( System.in);
				System.out.println("Unesite broj: ");
				broj = s.nextInt();
				fail = false;
			} catch (InputMismatchException e) {
				System.out.println("molimo  vas da unesete broj!!!");

			} finally {
				s.close();
			}
		} while (fail);

		System.out.println("Unijeli ste broj " + broj);

	}
}
