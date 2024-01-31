/**
 * This class represents a word, structured as a linked list of Letters.
 * Each Letter is wrapped in a LinearNode, forming a chain that makes up the word.
 */
public class Word {
    /**
     * The first node in the linked list of Letters that forms the word.
     */
    private LinearNode<Letter> firstLetter;

    /**
     * Constructs a Word from an array of Letters. Each Letter is wrapped in a LinearNode,
     * and the nodes are linked together to form a linked list.
     *
     * @param letters the array of Letters that forms the word.
     */
    public Word(Letter[] letters) {
        LinearNode<Letter> previousLetter = null;
        LinearNode<Letter> currentLetter;
        for (Letter letter : letters) {
            currentLetter = new LinearNode<>(letter);
            if (previousLetter == null) {
                this.firstLetter = currentLetter;
            } else {
                previousLetter.setNext(currentLetter);
            }
            previousLetter = currentLetter;
        }
    }

    /**
     * Returns a string representation of the word, created by appending each Letter's toString value.
     *
     * @return a string representing the Word.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Word: ");
        LinearNode<Letter> currentNode = firstLetter;
        while (currentNode != null) {
            sb.append(currentNode.getElement().toString()).append(" ");
            currentNode = currentNode.getNext();
        }
        return sb.toString();
    }

    /**
     * Checks if a Letter is in the word. This is a helper method used in the labelling process.
     *
     * @param letter the Letter to be checked.
     * @return true if the letter is in the word, false otherwise.
     */
    private boolean contains(Letter letter) {
        LinearNode<Letter> currentNode = firstLetter;
        while (currentNode != null) {
            if (currentNode.getElement().equals(letter)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    /**
     * Labels the current word based on a given mystery word. Each Letter in this Word is labelled as correct, used, or unused,
     * depending on whether it appears in the same position in the mystery word, appears in a different position,
     * or does not appear at all. This method also checks if this word is equal to the mystery word.
     *
     * @param mystery the mystery word used for labelling and comparison.
     * @return true if this word is equal to the mystery word, false otherwise.
     */
    public boolean labelWord(Word mystery) {
        LinearNode<Letter> otherNode = mystery.firstLetter;
        LinearNode<Letter> thisNode = this.firstLetter;
        boolean isEqual = true;

        while (thisNode != null && otherNode != null) {
            if (thisNode.getElement().equals(otherNode.getElement())) {
                thisNode.getElement().setCorrect();
            } else {
                if (mystery.contains(thisNode.getElement())) {
                    thisNode.getElement().setUsed();
                } else {
                    thisNode.getElement().setUnused();
                }
                isEqual = false;
            }

            thisNode = thisNode.getNext();
            otherNode = otherNode.getNext();
        }

        while (thisNode != null) {
            thisNode.getElement().setUnused();
            thisNode = thisNode.getNext();
            isEqual = false;
        }       

        return isEqual && otherNode == null;
    }
}

