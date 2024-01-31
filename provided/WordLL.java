/**
 * The WordLL class represents a simple linked list of words that's used to keep track 
 * of guesses for a mystery word. The class utilizes the LinearNode and Word classes. 
 * The design approach revolved around creating a maintainable, efficient, and understandable 
 * data structure, hence the choice of a singly linked list.
 * A challenge faced during development was determining how to effectively manage the history 
 * of guesses. This was resolved by inserting each new guess at the start of the history, 
 * leveraging the natural order of a singly linked list. 
 * The tryWord method was created to encapsulate the process of guessing a word, including 
 * adding it to history and checking if it matches the mystery word. 
 * The class was thoroughly tested by creating instances with different mystery words and 
 * various sequences of guesses, ensuring that the history and guess verification functionality 
 * worked as expected. 
 * The code demonstrates a clear understanding of linked list data structures and their application.
 */
public class WordLL {
    
    /** The mystery word to be guessed. */
    private Word mysteryWord;

    /** A linked list node that keeps track of the history of guessed words. */
    private LinearNode<Word> history;

    /**
     * Constructs a WordLL with the given mystery word. The history is initially empty.
     *
     * @param mystery The mystery word.
     */
    public WordLL(Word mystery) {
        this.mysteryWord = mystery;
        this.history = null; // Initially, there are no guesses, so history is null.
    }

    /**
     * Tries a guessed word. The guessed word is added to the history, and it is checked against the mystery word.
     *
     * @param guess The guessed word.
     * @return true if the guess matches the mystery word, false otherwise.
     */
    public boolean tryWord(Word guess) {
        // Wrap the guess in a node.
        LinearNode<Word> newGuess = new LinearNode<>(guess);
        
        // Add the new guess at the beginning of the history list.
        newGuess.setNext(history);
        history = newGuess;

        // Label the guessed word and check if it matches the mystery word.
        return guess.labelWord(mysteryWord);
    }

    /**
     * Returns a string representation of the WordLL, which includes a list of all guessed words.
     *
     * @return The string representation of the WordLL.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinearNode<Word> currentNode = history;
        
        // Traverse the history from newest to oldest guess, adding each to the string.
        while (currentNode != null) {
            sb.append(currentNode.getElement().toString()).append("\n");
            currentNode = currentNode.getNext();
        }
        
        return sb.toString();
    }
}

