package org.example;

public class Hofstadter {
  // Recall that you can calculate the nth term, G(n), using:
  // G(n) = n - G(G(n-1))
  // G(0) = 0

  public int gNaive(int n) {
    if (n == 0){
      return 0;
    } else {
      return n - gNaive(gNaive(n - 1));
    }
  }

  public int gMemorized(int n, int[] arr){
    if (n == 0){
      return 0;
    }
    if (arr[n] != -1){
      return arr[n];
    } else {
      arr[n] = n - gMemorized(gMemorized(n - 1, arr), arr);
      return arr[n];
    }
  }
}

