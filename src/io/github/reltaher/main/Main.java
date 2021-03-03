package io.github.reltaher.main;

import io.github.reltaher.optimal_binary_search_tree.OptimalBST;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    OptimalBST obst = new OptimalBST();
    Scanner scan = new Scanner(System.in);
    int keyAmount = 0;
    boolean goodInput = false;
    while (!goodInput) {
      System.out.println(
          "Enter one of these numbers to store a specific key amount (Ex. Type 1 to store 10 keys):");
      System.out.println(" 1) 10\n 2) 100\n 3) 1000\n 4) 10000\n 5) 100000");
      int userInput = scan.nextInt();
      switch (userInput) {
        case 1:
          keyAmount = 10;
          goodInput = true;
          break;
        case 2:
          keyAmount = 100;
          goodInput = true;
          break;
        case 3:
          keyAmount = 1000;
          goodInput = true;
          break;
        case 4:
          keyAmount = 10000;
          goodInput = true;
          break;
        case 5:
          keyAmount = 100000;
          goodInput = true;
          break;
        default:
          System.out.println("Invalid entry. Please try again.");

      }
    }
    System.out.println("Tables were created and stored into a file.");
    obst.storeTables(keyAmount);

  }
}
