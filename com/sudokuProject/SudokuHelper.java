package com.sudokuProject;

import com.sudokuProject.Sudoku;

public class SudokuHelper {

	public boolean checkSubGridValues(int number, Sudoku sudoku, int row, int column) {
		/**
		 * checkSubGridValues method checks the 3x3 matrix for the values that
		 * is equal to the number that is passed as a parameter to the method.
		 */
		int subGridRow, subGridColumn;
		subGridRow = (row / 3) * 3;
		subGridColumn = (column / 3) * 3;
		for (int iRow = subGridRow; iRow <= subGridRow + 2; iRow++) {
			for (int jColumn = subGridColumn; jColumn <= subGridColumn + 2; jColumn++) {
				if (sudoku.sudokuPuzzle[iRow][jColumn] == number) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean checkRowAndColumnValues(int number, Sudoku sudoku, int row, int column) {
		/**
		 * checkRowAndColumnValues method checks the rows and columns for the
		 * values that is equal to the number that is passed as a parameter to
		 * the mathod.
		 */
		for (int counter = 0; counter < 9; counter++) {
			if (sudoku.sudokuPuzzle[row][counter] == number) {
				return false;
			}
			if (sudoku.sudokuPuzzle[counter][column] == number) {
				return false;
			}
		}
		return true;
	}

	public boolean solveSudoku(Sudoku sudoku, int row, int column) {
		/**
		 * solveSudoku is the method that actually uses recursive calls to apply
		 * backtracking in the sudoku problem to generate the accurate result.
		 */
		int nextNumber = 1;
		if (row == 9)
			return true;

		if (sudoku.sudokuPuzzle[row][column] == 0) {
			for (nextNumber = 1; nextNumber < 10; nextNumber++) {
				if (this.checkSubGridValues(nextNumber, sudoku, row, column)) {
					if (this.checkRowAndColumnValues(nextNumber, sudoku, row, column)) {
						sudoku.sudokuPuzzle[row][column] = nextNumber;
						if (column == 8) {
							if (this.solveSudoku(sudoku, row + 1, 0))
								return true;
						} else {
							if (this.solveSudoku(sudoku, row, column + 1))
								return true;

						}
					}
				}
				sudoku.sudokuPuzzle[row][column] = 0;
			}
			return false;
		} else {
			if (column == 8) {
				if (this.solveSudoku(sudoku, row + 1, 0))
					return true;
			} else {
				if (this.solveSudoku(sudoku, row, column + 1))
					return true;
			}
			return false;
		}
	}
}