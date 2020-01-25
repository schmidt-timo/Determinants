/*
    @author: Marie Lencer, Timo Schmidt, Lena Zellin
    @version: 2020-01-24
 */

public class det {
    public static int nrOfMult;
    
    //Berechnung mit 1. Normalform
    public static double calcDet(double[][] A){
        return Double.NaN; // Durch Ihren Code ersetzen!
    }

    // Source: http://professorjava.weebly.com/matrix-determinant.html
    public static double calcDetRec2(double[][] A) {

        // Länge der Matrix (Anzahl Spalten)
        int len = A.length;

        // Determinate initialisieren
        int det = 0;

        // Base case / Termination statement
        if (len == 1)
            return A[0][0];

        // Durch die Spalten der Matrix iterieren
        for (int i = 0; i < len; i++) {

            // Teilmatrix initialisieren
            double[][] partial = new double[len-1][len-1];

            // Teilmatrix erstellen
            for (int j = 1; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    if (k < i)
                        partial[j-1][k] = A[j][k];
                    else if (k > i) {
                        partial[j-1][k-1] = A[j][k];
                    }
                }
            }

            // Vorzeichen festlegen
            int sign = i % 2 == 0 ? 1 : -1;

            // Rekursiver Aufruf der Methode mit der Teilmatrix
            det+= sign * A[0][i] * calcDetRec2(partial);

        }
        return det;
    }

    //Rekursive Berechnung mit Def. L.4.1.1 Skript
    public static double calcDetRec(double[][] A) {
        // Länge der Matrix A bestimmen
        int len = A.length;

        // Base case: Beende die Rekursion, wenn
        if (len == 1)
            return A[0][0];
        else {
            // Determinate initialisieren
            double det = 0;

            // Alle Teildeterminaten rekursiv erstellen und zusammenaddieren
            for (int i = 0; i < len; i++)
                det += Math.pow(-1, i) * A[0][i] * calcDetRec(partialMatrix(A, 0, i));

            return det;
        }
    }

    /**
     * Rekursive Methode für die Teilmatrizen
     * @param A - Matrix
     * @param i - entferne die i. Zeile von A
     * @param j - entferne die j. Spalte von A
     * @return Teilmatrix
     */
    public static double[][] partialMatrix(double[][] A, int i, int j) {
        // Lönge der Matrix bestimmen
        int len = A.length;

        // Neue Teilmatrix erstellen mit der Länge
        double[][] partial = new double[len-1][len-1];

        // Indizes initialiseren
        int r = 0;
        int s = 0;

        // Durch alle Spalten iterieren
        for (int k = 0; k < len; k++) {
            // Zeile auslesen
            double[] row = A[k];

            if (k != i) {
                for (int l = 0; l < row.length; l++) {
                    if (l != j)
                        partial[r][s++] = row[l];
                }

                r++;
                s = 0;

            }
        }

        return partial;
    }

    public static void main(String[] args) {

        double[][] test = { // ergibt det = -6
                { 1, 2, 0 },
                { 2, 1, 3 },
                { 1, 3, 1 },
        };

        System.out.println(calcDetRec(test));

        // Test 1 rekursiv
        testDet A = new testDet("src/Test.txt");
        double[][] matrixA = A.getA();
        System.out.println(calcDetRec2(matrixA));

    }

}
