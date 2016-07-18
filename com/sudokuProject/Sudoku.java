package com.sudokuProject;

import com.sudokuProject.SudokuHelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Sudoku {

	/**
	 * State Variables of Sudoku Class
	 */
	protected int[][] sudokuPuzzle = new int[9][9];
	protected int[] probabilityArray = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	public void printSudokuPuzzle(int[][] sudokuPuzzle) {
		/**
		 * printSudokuPuzzle method outputs the sudokuPuzzle passed as a value.
		 */
		for (int iCounter = 0; iCounter < 9; iCounter++) {
			for (int jCounter = 0; jCounter < 9; jCounter++) {
				System.out.print(sudokuPuzzle[iCounter][jCounter] + " ");
			}
			System.out.println("");
		}
	}

	public void createProbabilityArray(int[][] sudokuPuzzle) {
		/**
		 * createProbabilityArray would eventually make the algorith much more efficient
		 * by having a set of sorted values in an array depending on the number of times
		 * they appear in the puzzle.
		 * More the number of appearances, the easier the chance to find out which fits 
		 * perfectly in the squares without much recursive calls to solveSudoku()
		 */
		for (int iCounter = 0; iCounter < 9; iCounter++) {
			for (int jCounter = 0; jCounter < 9; jCounter++) {
				if (sudokuPuzzle[iCounter][jCounter] != 0)
					this.probabilityArray[sudokuPuzzle[iCounter][jCounter]]++;
			}
		}
		int max=0;
		for(int iCounter = 0; iCounter < 9; iCounter++){
			if(this.probabilityArray[iCounter] > max)
				max = probabilityArray[iCounter];
		}
		

	}

	public static void main(String[] args) {
		int row, column;
		Sudoku sudoku = new Sudoku();
		SudokuHelper sudokuHelper = new SudokuHelper();
		Scanner scanner;
		/**
		 * Getting the path of the Input.txt file, to read the Sudoku Puzzle
		 */
		System.out.println("Enter the full path of the input file: ");
		scanner = new Scanner(System.in);
		String location = scanner.nextLine();
		scanner.close();

		try {
			scanner = new Scanner(new BufferedReader(new FileReader(location)));
			/**
			 * Feeding the Sudoku Puzzle values into the 2-Dimensional Array sudokuPuzzle[][]
			 */
			System.out.println("\n-------Sudoku Puzzle-------\n");
			for (int iCounter = 0; iCounter < 9; iCounter++) {
				for (int jCounter = 0; jCounter < 9; jCounter++) {
					sudoku.sudokuPuzzle[iCounter][jCounter] = scanner.nextInt();
					System.out.print(sudoku.sudokuPuzzle[iCounter][jCounter] + " ");
				}
				System.out.println();
			}
			scanner.close();
			row = 0;
			column = 0;
			/**
			 * solveSudoku generates the perfect solution for the sudoku
			 * boolean flag is the only way to determine if the solution to the puzzle
			 * has been found or not.
			 */
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
