/**
 * Represents a letter in a text or word.
 */
public class Letter {

    /**
     * The actual character.
     */
    private char letter;
    
    /**
     * The state of the letter.
     */
    private int label;
    
    /**
     * The position of the letter in the string.
     */
    private int position;

    /**
     * The state for the unset letter.
     */
    public static final int UNSET = 0;
    
    /**
     * The state for the unused letter.
     */
    public static final int UNUSED = 1;
    
    /**
     * The state for the used letter.
     */
    public static final int USED = 2;
    
    /**
     * The state for the correct letter.
     */
    public static final int CORRECT = 3;

    /**
     * Constructor that creates a new Letter object with a specific character.
     *
     * @param c the character
     */
    public Letter(char c) {
        this.letter = c;
        this.label = UNSET;
    }

    /**
     * Checks if this Letter is equal to another object.
     *
     * @param otherObject the other object
     * @return true if the other object is a Letter and has the same character, false otherwise
     */
    public boolean equals(Object otherObject) {
        if (otherObject instanceof Letter) {
            Letter otherLetter = (Letter) otherObject;
            return this.letter == otherLetter.letter;
        }
        return false;
    }

    /**
     * Returns a string that represents the state of the letter.
     *
     * @return a string representation of the letter's state
     */
    public String decorator() {
        switch (label) {
            case UNUSED:
                return "-";
            case USED:
                return "+";
            case CORRECT:
                return "!";
            default:
                return " ";
        }
    }

    /**
     * Returns a string that represents this Letter.
     *
     * @return a string representation of this Letter
     */
    public String toString() {
        return decorator() + letter + decorator();
    }

    /**
     * Sets this Letter to unused.
     */
    public void setUnused() {
        this.label = UNUSED;
    }

    /**
     * Sets this Letter to used.
     */
    public void setUsed() {
        this.label = USED;
    }

    /**
     * Sets this Letter to correct.
     */
    public void setCorrect() {
        this.label = CORRECT;
    }

    /**
     * Checks if this Letter is unused.
     *
     * @return true if this Letter is unused, false otherwise
     */
    public boolean isUnused() {
        return this.label == UNUSED;
    }

    /**
     * Creates an array of Letter objects from a string.
     *
     * @param s the string
     * @return an array of Letter objects
     */
    public static Letter[] fromString(String s) {
        Letter[] letters = new Letter[s.length()];
        for (int i = 0; i < s.length(); i++) {
            letters[i] = new Letter(s.charAt(i));
            letters[i].position = i;
        }
        return letters;
    }

    /**
     * Returns the position of this Letter in the string.
     *
     * @return the position of this Letter
     */
    public int getPosition() {
        return position;
    }
}
