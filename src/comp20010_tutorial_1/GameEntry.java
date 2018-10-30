package comp20010_tutorial_1;

/**
 * GameEntry
 * 
 * @version 1.0 September 2017
 * 
 * @author Aonghus Lawlor
 */
public class GameEntry {
	/** name of the person earning this score */
	protected String name;

	/** the score value */
	protected int score;

	/** Constructor to create a game entry */
	public GameEntry(String name, int score) {
		setName(name);
		setScore(score);
	}

	/** Retrieves the name field */
	public String getName() {
		return name;
	}

	/** Retrieves the score field */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the name field
	 * 
	 * @param {String} name - Given a person's name
	 */
	public void setName(String name) {
		this.name = name;

	}

	/**
	 * Sets the score field
	 * 
	 * @param {int} score - Given the score the person got
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/** Returns a string representation of this entry */
	public String toString() {
		return "Name is: " + name + ". Score is: " + score;
	}
}