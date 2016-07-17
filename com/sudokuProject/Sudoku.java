package com.sudokuProject;

import com.sudokuProject.SudokuHelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Sudoku {

	protected int[][] sudokuPuzzle = new int[9][9];

	public void printSudokuPuzzle(int[][] sudokuPuzzle) {
		for (int iCounter = 0; iCounter < 9; iCounter++) {
			for (int jCounter = 0; jCounter < 9; jCounter++) {
				System.out.print(sudokuPuzzle[iCounter][jCounter] + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		int row, column;
		Sudoku sudoku = new Sudoku();
		SudokuHelper sudokuHelper = new SudokuHelper();
		Scanner scanner;
		System.out.println("Enter the full path of the input file: ");
		scanner = new Scanner(System.in);
		String location = scanner.nextLine();
		scanner.close();

		try {
			scanner = new Scanner(new BufferedReader(new FileReader(location)));
			System.out.println("\n-------Sudoku Puzzle-------\n");
			for (int iCounter = 0; iCounter < 9; iCounter++) {
				for (int jCounter = 0; jCounter < 9; jCounter++) {
					sudoku.sudokuPuzzle[iCounter][jCounter] = scanner.nextInt();
					System.out.print(sudoku.sudokuPuzzle[iCounter][jCounter] + " ");
				}
				System.out.println();
			}
			row = 0;
			column = 0;
			boolean flag = sudokuHelper.solveSudoku(sudoku, row, column);
			if (flag == true) {
				System.out.println("\n-------The Solved Sudoku-------\n");
				sudoku.printSudokuPuzzle(sudoku.sudokuPuzzle);
			} else {
				System.out.println("Couldn't Solve");
				sudoku.printSudokuPuzzle(sudoku.sudokuPuzzle);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
