/**
 * Solución al problema "Vacation" :

 *  - Tiempo de ejecución: O(n*m)
 *  - Espacio de memoria: O(n*m)
 *
 *  Descripción de la solución:
 *     La solución consiste en calcular la longitud de la subsecuencia común más larga (LCS) entre dos secuencias de lugares.
 *     Para ello, se utiliza programación dinámica y se crea una matriz de tamaño (n+1) x (m+1) donde n y m son las longitudes de las secuencias.
 *      La matriz memo[i][j] representa la longitud de la LCS entre los primeros i lugares de la primera secuencia y los primeros j lugares de la segunda secuencia.
 *
*        - Si los lugares i y j son iguales, entonces memo[i][j] = memo[i-1][j-1] + 1
 *       - Si los lugares i y j son diferentes, entonces memo[i][j] = max(memo[i-1][j], memo[i][j-1])
 *
 *        Finalmente, el resultado es memo[n][m], es decir, la longitud de la LCS entre las dos secuencias de lugares.
 *
 *        Para cada caso de prueba, se lee la primera secuencia de lugares y la segunda secuencia de lugares.
 *        Se calcula la longitud de la LCS entre las dos secuencias y se imprime el resultado.
 *
 *         El programa termina cuando la secuencia comienza con '#'.
 * */

import java.util.Scanner;

public class Main {
    // Método para calcular la subsecuencia común más larga (LCS) entre dos secuencias de lugares
    public static int lugaresComunes(String lugares1, String lugares2) {
        int[][] memo = new int[lugares1.length() + 1][lugares2.length() + 1];

        for (int i = 1; i <= lugares1.length(); i++) {
            for (int j = 1; j <= lugares2.length(); j++) {
                if (lugares1.charAt(i - 1) == lugares2.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        return memo[lugares1.length()][lugares2.length()];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int casos = 0;

        while (true) {
            String lugares1 = scanner.nextLine();
            if (lugares1.equals("#")) {
                break; // Terminar cuando la secuencia comience con '#'
            }
            String lugares2 = scanner.nextLine();
            casos++;
            int maxCiudades = lugaresComunes(lugares1, lugares2);
            System.out.println("Case #" + casos + ": you can visit at most " + maxCiudades + " cities.");
        }
    }
}