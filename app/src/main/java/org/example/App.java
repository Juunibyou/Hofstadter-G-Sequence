package org.example;

public class App {
    public static void main(String[] args) {
      Hofstadter hofstadter = new Hofstadter();

      int[] testValues = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
      int trials = 10;

      System.out.println("| Benchmark Results|");

      for (int n : testValues) {
        long totalNaive = 0;
        long totalMemo = 0;
        int resultNaive = 0;
        int resultMemo = 0;

        for (int t = 0; t < trials; t++) {
        // Naive
          long startNaive = System.nanoTime();
          resultNaive = hofstadter.gNaive(n);
          long endNaive = System.nanoTime();
          totalNaive += (endNaive - startNaive);

        // Memoized
          int[] memory = new int[n + 1];
          for (int j = 0; j <= n; j++) memory[j] = -1;
            long startMemo = System.nanoTime();
            resultMemo = hofstadter.gMemorized(n, memory);
            long endMemo = System.nanoTime();
            totalMemo += (endMemo - startMemo);
        }

        long avgNaive = totalNaive / trials;
        long avgMemo = totalMemo / trials;

      System.out.println("n = " + n);
      System.out.println("   Naive: G(" + n + ") = " + resultNaive + " | avg time = " + avgNaive + " ns");
      System.out.println("   Memorized:  G(" + n + ") = " + resultMemo + " | avg time = " + avgMemo + " ns");
      }
    }
}
