package comp20010_tutorial_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @version 1.0 September 2017
 * 
 * @author Aonghus Lawlor
 */
public class ScoreBoard {
	private int maxEntries;
	private int numEntries; // number of actual entries
	private GameEntry[] board; // array of game entries (name and scores)

	public ScoreBoard(int capacity) {
		maxEntries = capacity;
		numEntries = 0;
		board = new GameEntry[capacity];
		for (int i = 0; i < board.length; i++) {
			board[i] = new GameEntry("", 0);
		}
	}

	/** Attempts to add a new score to the collection (if it is high enough). */
	// best should go at the start
	public void add(GameEntry currEntry) {
		try {
			int cEScore = currEntry.score;
			int indexToInsert = -1;

			// find index of place to insert new entry
			for (int i = 0; i < board.length; i++) {
				if (board[i].score < cEScore) {
					indexToInsert = i;
					break;
				}
			}

			if (indexToInsert != -1) {
				// move all the entries
				for (int i = board.length - 1; i > indexToInsert; i--) {
					board[i] = board[i - 1];
				}
				// insert entry
				board[indexToInsert] = currEntry;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		numEntries++;
	}

	/** Attempts to remove an existing score from the collection */
	public GameEntry remove(int i) throws IndexOutOfBoundsException {
		GameEntry removed = board[i];
		board[i] = null;
		return removed;
	}

	public String toString() {
		String stringified;
		stringified = "[\n";
		for (int i = 0; i < board.length; i++) {
			stringified += board[i].getName() + " : " + board[i].getScore() + ",\n";
		}
		return stringified + "]";
	}

	public static void main(String[] args) {

		ScoreBoard myScoreBoard = new ScoreBoard(10);

		System.out.println("running main");

		File file = new File("scores.txt");
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				Scanner lineReader = new Scanner(line).useDelimiter(",\\s?+"); // comma followed by any number of spaces
				GameEntry temp = new GameEntry(lineReader.next(), Integer.parseInt(lineReader.next()));
				myScoreBoard.add(temp);
				lineReader.close();
			}
			scanner.close();
			System.out.println(myScoreBoard.toString());
		} catch (FileNotFoundException e) {
			System.out.println("the file scores.txt was not found");
		}
	}

}
