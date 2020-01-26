/*
    @author: Marie Lencer, Timo Schmidt, Lena Zellin
    @version: 2020-01-24
 */

public class det {
	public static long nrOfMult;
	public static int nrOfDiv;

	// Berechnung der Determinante mit 1. Normalform
	public static double calcDet(double[][] A) {
		// Normalform von A berechnen
		firstNormalForm(A);

		double det = 1;
		for (int i = 0; i < A.length; i++) {
			// Alle Zahlen der Diagonale multiplizieren
			det *= A[i][i];
			// Anzahl der Multiplikationen zählen
			nrOfMult++;
		}

		return det;
	}

	// Umformung von A in die erste Normalform
	public static void firstNormalForm(double[][] A) {

		// Anzahl der Spalten
		for (int j = 0; j < A.length; j++) {
			// Anzahl der verbleibenden Zeilen
			for (int i = j + 1; i < A.length; i++) {
				// Zahlen in der Diagonale
				double a = A[j][j];
				// Faktor zum berechnen der Nullen in der j-ten Spalte
				double factor = A[i][j] / a;
				nrOfDiv++;
				// Subtraktion der Zeilen
				for (int k = 0; k < A.length; k++) {
					A[i][k] = A[i][k] - factor * A[j][k];
					// Multipilkationen zählen
					nrOfMult++;
				}
			}
		}
	}

	// Rekursive Berechnung mit Def. L.4.1.1 Skript
	// Source: http://professorjava.weebly.com/matrix-determinant.html
	public static double calcDetRec(double[][] A) {

		// LÃ¤nge der Matrix (Anzahl Spalten)
		int len = A.length;

		// Determinate initialisieren
		double det = 0;

		// Base case / Termination statement
		if (len == 1)
			return A[0][0];

		// Durch die Spalten der Matrix iterieren
		for (int i = 0; i < len; i++) {

			// Teilmatrix initialisieren
			double[][] partial = new double[len - 1][len - 1];

			// Teilmatrix erstellen
			for (int j = 1; j < len; j++) {
				for (int k = 0; k < len; k++) {
					if (k < i)
						partial[j - 1][k] = A[j][k];
					else if (k > i) {
						partial[j - 1][k - 1] = A[j][k];
					}
				}
			}

			// Vorzeichen festlegen
			int sign = i % 2 == 0 ? 1 : -1;

			// Rekursiver Aufruf der Methode mit der Teilmatrix
			det += sign * A[0][i] * calcDetRec(partial);
			nrOfMult++;

		}
		return det;
	}

	public static void main(String[] args) {

		double[][] test = { // ergibt det = -6
				{ 1, 2, 0 }, { 2, 1, 3 }, { 1, 3, 1 }, };

		// Test 0 - 5x5 Matrix
		testDet A = new testDet("src/Test.txt");

		System.out.println("----------------------------------");

		// Test 1 - nicht quadratisch
		testDet B = new testDet("src/Test1.txt");

		System.out.println("----------------------------------");

		// Test 2 - 9x9 Matrix
		testDet C = new testDet("src/Test2.txt");

		System.out.println("----------------------------------");

		// Test 3 - 5x5 Matrix mit teilweise negativen Zahlen
		testDet D = new testDet("src/Test3.txt");

		System.out.println("----------------------------------");

		// Test 4 - 3x3 nur negative Zahlen
		testDet E = new testDet("src/Test4.txt");

		System.out.println("----------------------------------");

		// Test 5 - 4x4 Einheitsmatrix
		testDet F = new testDet("src/Test5.txt");

		System.out.println("----------------------------------");

		// Test 6 - 4x4 Hilbertmatrix
		testDet G = new testDet("src/Test6.txt");

		System.out.println(calcDetRec(test));
		firstNormalForm(test);

		System.out.println(calcDet(test));
		double[][] matrixA = A.getA();
		System.out.println(calcDetRec(matrixA));

	}

}