// Problem: Task
// Platform: cses
// Language: unknown
// Verdict: ACCEPTED
// URL: https://cses.fi/problemset/result/19133376/
// Solved on: 2026-10-20T12:23:38.269Z

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SlidingWindowSum {

  public static void main(String[] args) {
    FastReader fr = new FastReader();
    PrintWriter out = new PrintWriter(System.out); //take input
    int n = fr.nextInt();
    int k = fr.nextInt();
    long[] a = new long[4];
    for (int i = 0; i < 4; i++) {
      a[i] = fr.nextInt();
    }
    Solution solution = new Solution();
    solution.solve(n, k, a, out);
    out.close();
  }
}

class Solution {

  static final int MOD = 1_000_000_000 + 7; //write the logic here

  public void solve(int n, int k, long[] a, PrintWriter out) {
    long[] x = new long[n];
    x[0] = a[0];
    for (int i = 1; i < n; i++) {
      x[i] = (a[1] * x[i - 1] + a[2]) % a[3];
    }
    long sum = 0;
    for (int i = 0; i < k; i++) {
      sum += x[i];
    }
    long res = sum;
    for (int i = k; i < n; i++) {
      sum -= x[i - k];
      sum += x[i];
      res ^= sum;
    }
    out.println(res);
  }
}

class FastReader {

  BufferedReader br;
  StringTokenizer st;

  public FastReader() {
    br = new BufferedReader(new InputStreamReader(System.in));
  }

  String next() {
    while (st == null || !st.hasMoreElements()) {
      try {
        st = new StringTokenizer(br.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return st.nextToken();
  }

  int nextInt() {
    return Integer.parseInt(next());
  }

  long nextLong() {
    return Long.parseLong(next());
  }

  double nextDouble() {
    return Double.parseDouble(next());
  }

  String nextLine() {
    String str = "";
    try {
      str = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return str;
  }
}
