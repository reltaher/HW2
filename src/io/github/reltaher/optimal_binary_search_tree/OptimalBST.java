package io.github.reltaher.optimal_binary_search_tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class OptimalBST {

  public int[][] OptimalBSTE(int[] p, int[] q, int n) {

    int[][] e = new int[n+1][n+1];
    int[][] w = new int[n+1][n+1];
    int[][] root = new int[n][n];

    for (int i = 1; i < n+1; i++) {
      e[i][i-1] = q[i-1];
      w[i][i-1] = q[i-1];
    }

    for (int l = 1; l < n; l++) {
      for (int i = 1; i < n - l + 1; i++) {

        int j = i + l - 1;
        e[i][j] = Integer.MAX_VALUE;
        w[i][j] = w[i][j-1] + p[j] + q[j];

        for (int r = i; r < j; r++) {
          int t = e[i][r-1] + e[r+1][j] + w[i][j];
          if (t < e[i][j]) {
            e[i][j] = t;
            root[i][j] = r;
          }
        }
      }
    }

    return e;
  }

  public int[][] OptimalBSTRoot(int[] p, int[] q, int n) {

    int[][] e = new int[n+1][n+1];
    int[][] w = new int[n+1][n+1];
    int[][] root = new int[n+1][n+1];

    for (int i = 1; i < n+1; i++) {
      e[i][i-1] = q[i-1];
      w[i][i-1] = q[i-1];
    }

    for (int l = 1; l < n; l++) {
      for (int i = 1; i < n - l + 1; i++) {

        int j = i + l - 1;
        e[i][j] = Integer.MAX_VALUE;
        w[i][j] = w[i][j-1] + p[j] + q[j];

        for (int r = i; r < j; r++) {
          int t = e[i][r-1] + e[r+1][j] + w[i][j];
          if (t < e[i][j]) {
            e[i][j] = t;
            root[i][j] = r;
          }
        }
      }
    }

    return root;
  }

  public int[][] OptimalBSTW(int[] p, int[] q, int n) {

    int[][] e = new int[n+1][n+1];
    int[][] w = new int[n+1][n+1];
    int[][] root = new int[n][n];

    for (int i = 1; i < n+1; i++) {
      e[i][i-1] = q[i-1];
      w[i][i-1] = q[i-1];
    }

    for (int l = 1; l < n; l++) {
      for (int i = 1; i < n - l + 1; i++) {

        int j = i + l - 1;
        e[i][j] = Integer.MAX_VALUE;
        w[i][j] = w[i][j-1] + p[j] + q[j];

        for (int r = i; r < j; r++) {
          int t = e[i][r-1] + e[r+1][j] + w[i][j];
          if (t < e[i][j]) {
            e[i][j] = t;
            root[i][j] = r;
          }
        }
      }
    }

    return w;
  }

  public void storeTables(int keyAmount) throws IOException {
    Random rand = new Random();
    int[] keys = new int[keyAmount];
    int[] freq = new int[keyAmount];
    for (int i = 0; i < 10; i++) {
      keys[i] = rand.nextInt();
      freq[i] = rand.nextInt();
    }
    long start = System.nanoTime();
    int[][] e = OptimalBSTE(keys, freq, keys.length);
    int[][] root = OptimalBSTRoot(keys, freq, keys.length);
    int[][] w = OptimalBSTW(keys, freq, keys.length);
    long end = System.nanoTime();
    long elapsedTime = end - start;
    double milliseconds = (double)elapsedTime / 1000000;


    StringBuilder esb = new StringBuilder();
    StringBuilder rootsb = new StringBuilder();
    StringBuilder wsb = new StringBuilder();
    for (int i = 0; i < e.length; i++) {
      for (int j = 0; j < e.length; j++) {
        esb.append(e[i][j]);
        rootsb.append(root[i][j]);
        wsb.append(w[i][j]);
        if (j < e.length - 1) {
          esb.append(",");
          rootsb.append(",");
          wsb.append(",");
        }
      }
      esb.append("\n");
      rootsb.append("\n");
      wsb.append("\n");
    }
    BufferedWriter ewriter = new BufferedWriter(new FileWriter("cost_table.OBST." + keyAmount + ".keys.csv"));
    BufferedWriter rootwriter = new BufferedWriter(new FileWriter("root_table.OBST." + keyAmount + ".keys.csv"));
    BufferedWriter wwriter = new BufferedWriter(new FileWriter("w_table.OBST." + keyAmount + ".keys.csv"));
    ewriter.write(esb.toString());
    rootwriter.write(rootsb.toString());
    wwriter.write(wsb.toString());
    ewriter.close();
    rootwriter.close();
    wwriter.close();

    System.out.println("It took " + elapsedTime + " nanoseconds (" + milliseconds + " milliseconds).");
  }

}
