/**
 * This class extends the Letter class, adding a content field and a family classification.
 * ExtendedLetters can also be marked as related to other letters.
 */
public class ExtendedLetter extends Letter {

    /** The string content of the ExtendedLetter. */
    private String content;

    /** The family identifier of the ExtendedLetter. */
    private int family;

    /** Flag indicating whether the ExtendedLetter is related to another letter. */
    private boolean related;

    /** Constant that represents a singleton ExtendedLetter (i.e., without a family). */
    public static final int SINGLETON = -1;

    /**
     * Constructs an ExtendedLetter with the given content string. The letter has no family and is not related.
     *
     * @param s The content string.
     */
    public ExtendedLetter(String s) {
        super(' ');
        this.content = s;
        this.related = false;
        this.family = SINGLETON;
    }

    /**
     * Constructs an ExtendedLetter with the given content string and family identifier. The letter is not related.
     *
     * @param s The content string.
     * @param fam The family identifier.
     */
    public ExtendedLetter(String s, int fam) {
        super(' ');
        this.content = s;
        this.related = false;
        this.family = fam;
    }

    /**
     * Compares this ExtendedLetter to another object. If the other object is an ExtendedLetter of the same family,
     * marks them as related. ExtendedLetters are considered equal if they have the same content.
     *
     * @param other The object to compare.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ExtendedLetter)) {
            return false;
        }
        ExtendedLetter otherLetter = (ExtendedLetter) other;
        if (this.family == otherLetter.family) {
            this.related = true;
        }
        return this.content.equals(otherLetter.content);
    }

    /**
     * Returns a string representation of the ExtendedLetter. If the letter is unused and related, its content is enclosed in dots.
     *
     * @return The string representation.
     */
    @Override
    public String toString() {
        if (isUnused() && related) {
            return "." + this.content + ".";
        } else {
            return decorator() + this.content + decorator();
        }
    }

    /**
     * Creates an array of ExtendedLetters from arrays of content strings and codes. If codes is null,
     * creates ExtendedLetters without a family.
     *
     * @param content An array of content strings.
     * @param codes An array of codes representing family identifiers, or null.
     * @return An array of ExtendedLetters.
     */
    public static Letter[] fromStrings(String[] content, int[] codes) {
        Letter[] letters = new Letter[content.length];
        for (int i = 0; i < content.length; i++) {
            if (codes == null) {
                letters[i] = new ExtendedLetter(content[i]);
            } else {
                letters[i] = new ExtendedLetter(content[i], codes[i]);
            }
        }
        return letters;
    }
}

