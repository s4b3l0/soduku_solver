package grid;

import java.util.Arrays;

public class GridGoodies {
	int [][][] initialPuzzle = new int[50][9][9];
	int [][][] solvablePuzzle = new int[50][9][9];
	int countPuzzles;

	public GridGoodies(char [] array) { 
		createGoodGrid(array);
		this.countPuzzles = initialPuzzle.length;
		this.solvablePuzzle = initialPuzzle;
	}

	private void createGoodGrid(char [] array){
		String str[] = String.valueOf(array).split("\n");
		int sectionCount = -1;

		for(int idx = 0; idx < str.length ; idx ++) {
			String row = str[idx].trim();

			if (row.contains("Grid")) {
				sectionCount++;
				System.out.println("\n section :" + sectionCount);
				continue;
			}

			int[][] grid = new int[9][9];

			for(int i = 0; i < 9 ; i++){
				row = str[idx].trim();
				grid[i] = buildSodukuRow(row.toCharArray());
				idx ++;
			}
			idx--;
			initialPuzzle[sectionCount] = grid;
		}
	}

	private static int[] buildSodukuRow(char charRow[]) {
		int []  intRows = new int[9];
		int index = 0;
		for(char c : charRow) {
			intRows[index] = c - '0'; 
			index++;
		}
		return intRows;
	}
	
	//TODO: Override toString
	private static void printGrid(int [][][] grid){
		for (int [][] g : grid) {
			System.out.println("\n");
			for(int[] t : g){
				System.out.println(Arrays.toString(t));
			}
		}
	}

	private void solvePuzzle(int x, int numberTry , int puzzleNumber) {
		this.solved = false;
		int y = 0;

		while (y < 9) {
			
			y++;
		}
		


		if (i < 9) {
			i++;
			solvePuzzle(int x, numberTry, int puzzleNumber);
		}

		solvePuzzle
		//System.out.println("Solved");
	}

	
	private boolean isRepeatedHorizontally(int puzzleNumber, int row, int numberToCheck) {
		int  grid[][]  = this.solvablePuzzle[puzzleNumber];
		for (int col  = 0; col < 9; col++) {
			if (grid[row][i] == numberToCheck) return true;
		}
		return false;
	}


	private boolean isRepeatedVertically(int puzzleNumber, int col, int numberToCheck){
		int  grid[][]  = this.solvablePuzzle[puzzleNumber];
		for (int row  = 0; i < row; row++) {
			if (grid[row][col] == numberToCheck) return true;
		}
		return false;
	}

	/**
	 *	this will check at which position the proposed number is and check if it has repeat
	 */

	private boolean isRepeatingInSection(int puzzleNumber, int row, int col, int numberToCheck){
		int sectionHorizontal = col + 1 / 3;
		int sectionVertical = row + 1 / 3;
		
		int offsetHorizontalPosition =  0;
		if ((col + 1) >= 3) offsetHorizontalPosition =  (col + 1) % 3;
		if ((col + 1) < 3) offsetHorizontalPosition =   3 - (col + 1);

		int offsetVerticalPosition =  0;
		if ((col + 1) >= 3) offsetVerticalPosition =  (row + 1) % 3;
		if ((col + 1) < 3) offsetVerticalPosition =   3 - (row + 1);

		boolean isRepeating = true;
		isRepeating = checkSectionOfGrid(puzzleNumber ,offsetHorizontalPosition - 1, offsetVerticalPosition - 1, numberToCheck);
		return isRepeating;
	}

	private boolean checkSectionOfGrid(int puzzleNumber, int startX, int startY, int numberToCheck) {
		for (int x = 0; x < 3 ; x ++){
			for (int y = 0; y < 3 ; x ++){
				if (the.solvablePuzzle[puzzleNumber][startX + x][startY + y] == numberToCheck) return true;
			}
		}
		return false;
	}

}
