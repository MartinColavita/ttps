import java.util.Scanner;

class Main {

    // Método  para resolver el problema de knapsack
    public static boolean knapsack(int[] bars, int target) {
        if (target == 0) return true;

        // dp[j] indica si es posible formar una barra de longitud 'j'
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Siempre podemos formar una barra de longitud 0

        // recorre cada barra disponible
        for (int bar : bars) {
            // actualiza dp[] de mayor a menor para evitar sobrescribir valores anteriores
            for (int j = target; j >= bar; j--) {
                dp[j] = dp[j] || dp[j - bar];
            }
        }

        // Si dp[target] es true, se puede  formar una barra de longitud 'target'
        return dp[target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Número de casos de prueba

        for (int tc = 0; tc < t; tc++) {
            int targetLength = sc.nextInt();  // Longitud de barra objetivo
            int p = sc.nextInt();  // Cantidad de barras disponibles
            int[] bars = new int[p];

            // carga de las longitudes de barras disponibles
            for (int i = 0; i < p; i++) {
                bars[i] = sc.nextInt();
            }

            // llamada al método knapsack
            if (knapsack(bars, targetLength)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}