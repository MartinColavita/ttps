/***
 * El algoritmo implementado utiliza programación dinámica para calcular el costo mínimo de energía para que Spiderman alcance el último edificio (N). Se utiliza un array `dp` donde `dp[i]` almacena el costo mínimo para llegar al edificio i.
 * Los saltos permitidos son aquellos donde la diferencia entre los números de edificios es una potencia de 2.
 *
 * Complejidad temporal: O(N log N) donde N es el número de edificios.
 *
 * Entrada:
 * La primera línea contiene un entero N, el número de edificios.
 * La segunda línea contiene N enteros separados por espacios, las alturas de los edificios.
 *  1 <= N <= 10^5
 *  1 <= Altura de los edificios <= 10^9
 *
 *
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class SpidermanAndJump {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Lee el número de edificios (N)
        String line = br.readLine();
        if (line == null || line.isEmpty()) {
            return;  // Si la línea es nula o vacía, termina el programa
        }

        int N = Integer.parseInt(line);

        // Lee las alturas de los edificios
        line = br.readLine();
        if (line == null || line.isEmpty()) {
            return;  // Si la línea es nula o vacía, termina el programa
        }

        String[] heightStr = line.split(" ");
        int[] heights = new int[N];

        // Convertir el array de alturas a enteros
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(heightStr[i]);
        }

        // Arreglo dp donde dp[i] almacena el costo mínimo para llegar al edificio i
        long[] dp = new long[N];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;  // El costo de estar en el primer edificio es 0

        // Proceso para calcular el costo mínimo para alcanzar cada edificio
        for (int i = 0; i < N; i++) {
            int power = 1;
            while (i + power < N) {
                int j = i + power;
                dp[j] = Math.min(dp[j], dp[i] + Math.abs(heights[j] - heights[i]));
                power *= 2;  // Consideramos saltos de potencias de 2
            }
        }

        // Imprimir el costo mínimo para alcanzar el edificio N (último edificio)
        System.out.println(dp[N - 1]);
    }
}
