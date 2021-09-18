import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import grid.GridGoodies;

public class SodukuSolver {
	public static void main(String [] args) {
		System.out.println("Lets begin");
		//Read input from a File
		char [] array = new char[10000];
		try {
			final FileInputStream file = new FileInputStream("./resources/puzzles/grids.txt");
			final InputStreamReader input = new InputStreamReader(file);
			input.read(array);
			input.close();
		}catch (Exception e) {
			System.out.println("Oopsie ");
			e.printStackTrace();
		}
		final GridGoodies grid = new GridGoodies(array);
		//Apply the numbers to an array
		//start solving the stuff
	}
}
