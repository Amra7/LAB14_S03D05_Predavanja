public class ZadatakSaMatricom {
	public static void main(String[] args) {

		System.out.print(" Unesi visinu: ");
		int visina = TextIO.getlnInt();
		System.out.print(" Unesi sirinu: ");
		int sirina = TextIO.getlnInt();

		int[][] matrica = kreirajMatricu(visina, sirina);
		ispisiMatricu(matrica);

		postaviVrijednost(matrica);
		ispisiMatricu(matrica);

		boolean trebaPonavlajti=true;
		
		do {
			matrica = postaviVrijednost(matrica);
			
			for ( int i =0; i < matrica.length; i++) {
				if ( sviIstiURedu(matrica[i]) == true &&  matrica[i][0] !=0) {
					trebaPonavlajti=false;
				}
			}
			
			for ( int i =0; i < matrica[0].length; i++) {
				if ( sviIstiUKoloni(matrica, i) == true &&  matrica[0][i]!=0){
					trebaPonavlajti=false;
				}
			}
			
			if ( sviIstiDijagonala(matrica ) == true &&  matrica[0][0]!=0){
				trebaPonavlajti=false;
			}
			
			if ( sviIstiKontraDijagonala(matrica ) == true &&  matrica[0][matrica.length -1]!=0){
				trebaPonavlajti=false;
			}

		} while (imaNule(matrica) == true);
		
		

	}

	public static int[][] postaviVrijednost(int[][] matrica) {

		int x = 0;
		int y = 0;

		do {
			System.out.print("Unesi kordinate matrice: ");
			System.out.print(" Unesi x: ");
			x = TextIO.getlnInt();
			while ((x < 0) || (x >= matrica.length)) {
				System.out.print("Unesi koordinatu koja je validna :");
				x = TextIO.getlnInt();
			}

			System.out.print(" Unesi y: ");
			y = TextIO.getlnInt();
			while ((y < 0) || (y >= matrica[x].length)) {
				System.out.print("Unesi koordinatu koja je validna :");
				y = TextIO.getlnInt();
			}

		} while (matrica[x][y] != 0);
		
		System.out.println("Unesi vrijednost koju zelis postaviti: ");
		int vrijednost = TextIO.getlnInt();
		matrica[x][y] = vrijednost;

		return matrica;

	}

	public static boolean imaNule(int[][] matrica) {
		boolean nemaNule = false;
		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica.length; j++) {
				if (matrica[i][j] == 0) {
					return true;
				}
			}
		}
		return nemaNule;
	}

	public static int[][] kreirajMatricu(int visina, int sirina) {
		int[][] matrica = new int[visina][sirina];
		return matrica;
	}

	public static void ispisiMatricu(int[][] matrica) {

		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica[i].length; j++) {
				System.out.print(matrica[i][j] + " ");

			}
			System.out.println();
		}
	}

	public static boolean sviIstiDijagonala(int[][] matrica) {
		boolean yes = true;
		for (int i = 1; i < matrica.length; i++) {
			for (int j = 1; j < matrica.length; j++) {
				if (matrica[i][j] != matrica[i][j]) {
					return false;
				}

			}
		}
		return yes;

	}

	public static boolean sviIstiKontraDijagonala(int[][] matrica) {
		int j = matrica.length - 1;
		for (int i = 1; i < matrica.length; i++) {
			int k = j - 1;
			if (matrica[i - 1][k + 1] != matrica[i][k]) {
				return false;
			}
		}
		return true;
	}

	private static boolean sviIstiUKoloni(int[][] matrica, int j) {
		boolean yes = true;
		for (int i = 1; i < matrica.length; i++) {
			if (matrica[i][j] != matrica[i - 1][j]) {
				return false;
			}
		}
		return yes;
	}

	private static boolean sviIstiURedu(int[] red) {
		boolean yes = true;
		for (int j = 0; j < red.length; j++) {
			if (red[0] != red[j]) {
				return false;
			}
		}
		return yes;
	}
}
