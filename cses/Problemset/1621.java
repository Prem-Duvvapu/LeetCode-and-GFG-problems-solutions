// Problem: Task
// Platform: cses
// Language: unknown
// Verdict: ACCEPTED
// URL: https://cses.fi/problemset/result/19133604/
// Solved on: 2026-10-20T12:47:02.560Z

import java.io.*;import java.util.*; public class DistinctNumbers {    public static void main(String[] args) throws IOException {        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        PrintWriter out = new PrintWriter(System.out);         int n = Integer.parseInt(br.readLine());        int[] arr = new int[n];         StringTokenizer st = new StringTokenizer(br.readLine());        for (int i = 0; i < n; i++)            arr[i] = Integer.parseInt(st.nextToken());         Solution solution = new Solution();        solution.solve(arr, n, out);         out.close(); // Important to flush output    }} class Solution {    public void solve(int[] arr, int n, PrintWriter out) {        Set<Integer> set = new HashSet<>();         for (int i = 0; i < n; i++)            set.add(arr[i]);         out.println(set.size());    }}