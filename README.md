# Determinants

Schreiben Sie in der Klasse det im Projekt Determinanten die Methoden 

    public static double calcDetRecursiv(double[][] A) und
    public static double calcDet(double[][] A).
    
calcDetRecursiv soll die Determinante der n x n -Matrix A rekursiv wie in Definition L.4.1.1 des Skripts berechnen, calcDet soll die Berechnung mit Hilfe der 1. Normalform von A ausführen. Testen Sie Ihre Methoden! In der Klasse testDet finden Sie dazu die Methoden

    public static double[][] readMatrixFromFile(String filename)und 
    public static void showMatrix(double[][] M,int nrOfDigits),
    
mit denen Sie eine Matrix aus der Datei Test.txt einlesen und ausgeben können. (Zwischen den Zahlen müssen sich mindestens 2 und höchstens 3 Leerzeichen befinden.) Testen Sie mit weiteren Beispielen!

Wie viele Multiplikationen / Divisionen benötigen Ihre Methoden zur Berechnung einer n x n -Determinante?

Finden Sie eine Matrix A für welche der Rundungsfehler in Ihrer Berechnung der Determinante besonders groß wird.
