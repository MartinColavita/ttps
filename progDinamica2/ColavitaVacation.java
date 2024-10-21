

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