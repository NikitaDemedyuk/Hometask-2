package com.company;

import java.util.Scanner;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello!\n 1 - random matrix\n 2 - fixed matrix\n");
        System.out.print("Enter number: ");

        Scanner in = new Scanner(System.in);
        int variant = in.nextInt();

        if (variant == 1) {
            System.out.print("1) Enter the number of lines in matrix: ");
            int line = in.nextInt();

            System.out.print("2) Enter the number of columns in matrix: ");
            int column = in.nextInt();

            int[][] matrix = new int[line][column];
            for (int i = 0; i < line; ++i) {
                for (int k = 0; k < column; ++k) {
                    matrix[i][k] = (int) (Math.random() * 10);
                }
            }
            System.out.println("3) Matrix: ");

            for (int i = 0; i < line; ++i) {
                System.out.print("\n");
                for (int k = 0; k < column; ++k) {
                    System.out.print(matrix[i][k] + " ");
                }
            }
            System.out.print("\n");
            ChangeLines(matrix, line, column);

            System.out.println("4) New matrix: ");

            for (int i = 0; i < line; ++i) {
                System.out.print("\n");
                for (int k = 0; k < column; ++k) {
                    System.out.print(matrix[i][k] + " ");
                }
            }

            System.out.println("\n\n5) Lines, which have 0 on the main diagonal: ");
            FindZeroElements(matrix, line, column);
        }

        if(variant == 2) {
            int line = 5;
            int column = 5;
            int[][] matrix = {{3, 7, 8, 5, 1}, {1, 0, 7, 2, 3}, {4, 3, 0, 6, 6}, {2, 1, 5, 0, 9}, {1, 8, 7, 3, 0}};

            System.out.println("1) Matrix: ");

            for (int i = 0; i < line; ++i) {
                System.out.print("\n");
                for (int k = 0; k < column; ++k) {
                    System.out.print(matrix[i][k] + " ");
                }
            }
            System.out.print("\n");

            ChangeLines(matrix, line, column);

            System.out.println("2) New matrix: ");

            for (int i = 0; i < line; ++i) {
                System.out.print("\n");
                for (int k = 0; k < column; ++k) {
                    System.out.print(matrix[i][k] + " ");
                }
            }

            System.out.println("\n\n3) Lines, which have 0 on the main diagonal: ");
            FindZeroElements(matrix, line, column);
        }

        System.out.println("\n\nEnd of program ");

    }

    static void ChangeLines(int[][] matrix, int line, int column) {
        int max_element = 0;
        int min_element = 100000;
        int line_max_element = 0;
        int line_min_element = 0;
        for (int i = 0; i < line; ++i) {
            for (int k = 0; k < column; ++k) {
                if (matrix[i][k] > max_element) {
                    max_element = matrix[i][k];
                    line_max_element = i;
                }
                if (matrix[i][k] < min_element) {
                    min_element = matrix[i][k];
                    line_min_element = i;
                }
            }
        }
        System.out.print("\nNumber of line with max element:" + (line_max_element + 1) + "\nNumber of line with min element: " + (line_min_element + 1) + "\n\n");
            int tmp;
            for (int k = 0; k < column; ++k) {
                tmp = matrix[line_max_element][k];
                matrix[line_max_element][k] = matrix[line_min_element][k];
                matrix[line_min_element][k] = tmp;
        }
    }

    static void FindZeroElements(int[][] matrix, int line, int column) {
        int counter_lines = 0;
        int[] max_line_element = new int[line];
        for (int i = 0; i < line; ++i) {
            for (int k = 0; k < column; ++k) {
                if (matrix[i][k] > max_line_element[i]) {
                    max_line_element[i] = matrix[i][k];
                }
            }
        }

        for (int i = 0; i < line; ++i) {
            for (int k = 0; k < column; ++k) {
                if ((i == k) && (matrix[i][k] == 0)) {
                    ++counter_lines;
                    System.out.println("Number of line: " + (i + 1) + "\nMax element: " + max_line_element[i]);
                    System.out.println("------------------------------------------------------------");
                }
            }
        }
        if (counter_lines == 0) {
            System.out.println("Matrix hasn't got such lines");
        }
    }

}

