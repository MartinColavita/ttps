
import java.util.*;
import java.lang.*;
import java.io.*;

class SpidermanAndJump {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Lee el número de edificios (N)
        String line = br.readLine();
        if (line == null || line.isEmpty()) {
            return;
        }

        int N = Integer.parseInt(line);

        // Lee las alturas de los edificios
        line = br.readLine();
        if (line == null || line.isEmpty()) {
            return;
        }

        String[] heightStr = line.split(" ");
        int[] heights = new int[N];

        // convierte el array de alturas a enteros
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(heightStr[i]);
        }

        // Arreglo dp donde dp[i] almacena el costo mínimo para llegar al edificio i
        long[] dp = new long[N];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;  // El costo de estar en el primer edificio es 0

        // calcula el costo mínimo para alcanzar cada edificio
        for (int i = 0; i < N; i++) {
            int power = 1;
            while (i + power < N) {
                int j = i + power;
                dp[j] = Math.min(dp[j], dp[i] + Math.abs(heights[j] - heights[i]));
                power *= 2;  //  saltos de potencias de 2
            }
        }

        // imprime el costo mínimo para alcanzar el edificio N (último edificio)
        System.out.println(dp[N - 1]);
    }
}
