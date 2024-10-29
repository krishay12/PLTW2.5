public class Board {
    private String solvedPhrase;
    private String phrase;
    private int currentLetterValue;

    /**
     * Constructs a new Board object.
     */
    public Board() {
        solvedPhrase = "";
        phrase = loadRandomPhrase();
        generateRandomLetterValue();
        System.out.println("Phrase: " + phrase); // Temporary test code
    }

    /**
     * Generates a random letter value for the current game.
     */
    public void generateRandomLetterValue() {
        int randomInt = (int) ((Math.random() * 10) + 1) * 100;
        currentLetterValue = randomInt;
    }

    /**
     * Checks if the game is solved by comparing the guessed phrase.
     *
     * @param guess The guessed phrase.
     * @return True if the guessed phrase matches the original phrase.
     */
    public boolean isSolved(String guess) {
        return phrase.equals(guess);
    }

    /**
     * Loads a random phrase from a file and initializes the solved phrase with underscores.
     *
     * @return The loaded random phrase.
     */
    private String loadRandomPhrase() {
        String tempPhrase = "";
        int numOfLines = 0;

        try {
            Scanner sc = new Scanner(new File("phrases.txt"));
            while (sc.hasNextLine()) {
                tempPhrase = sc.nextLine().trim();
                numOfLines++;
            }
        } catch (Exception e) {
            System.out.println("Error reading or parsing phrases.txt");
        }

        int randomInt = (int) ((Math.random() * numOfLines) + 1);

        try {
            int count = 0;
            Scanner sc = new Scanner(new File("phrases.txt"));
            while (sc.hasNextLine()) {
                count++;
                String temp = sc.nextLine().trim();
                if (count == randomInt) {
                    tempPhrase = temp;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading or parsing phrases.txt");
        }

        solvedPhrase = initializeSolvedPhrase(tempPhrase);
        return tempPhrase;
    }

    /**
     * Initializes the solved phrase with underscores for each letter and spaces for spaces.
     *
     * @param phrase The original phrase.
     * @return The initial solved phrase with underscores and spaces.
     */
    private String initializeSolvedPhrase(String phrase) {
        StringBuilder initialSolvedPhrase = new StringBuilder();

        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == ' ') {
                initialSolvedPhrase.append("  ");
            }
            else {
                initialSolvedPhrase.append("_ ");
            }
        }

        return initialSolvedPhrase.toString();
    }

    /**
     * Guess a letter in the phrase and update the solved phrase if the letter is found.
     *
     * @param guess The guessed letter.
     * @return True if the guessed letter is found in the phrase.
     */
    public boolean guessLetter(String guess) {
        boolean foundLetter = false;
        StringBuilder newSolvedPhrase = new StringBuilder();

        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == guess.charAt(0)) {
                newSolvedPhrase.append(guess).append(" ");
                foundLetter = true;
            } else {
                newSolvedPhrase.append(solvedPhrase.charAt(i * 2)).append(" ");
            }
        }

        solvedPhrase = newSolvedPhrase.toString();
        return foundLetter;
    }
}



        Paste a copy of the PhaseSolver class below and copy into your notebook, showing the 
        class declaration, the instance  variables  and the modified constructor:

public class PhraseSolver {
    private Player player1;
    private Player player2;
    private Board board;
    private boolean solved;

    /**
     * Constructs a new PhraseSolver game.
     */
    public PhraseSolver() {
        player1 = null;
        player2 = null;
        board = null;
        solved = false;
    }

    /**
     * Starts and manages the game between two players.
     */
    public void play() {
        int currentPlayer = 1;
        Scanner input = new Scanner(System.in);

        while (!solved) {
            if (currentPlayer == 1) {
                currentPlayer = 2;
            } else {
                currentPlayer = 1;
            }

            // Get player's input here

            // Check if the game is solved

        }
    }

    /**
     * Get a player's input, handle their guess, and update game status.
     *
     * @param currentPlayer The current player making a guess.
     * @return True if the guess is correct, false otherwise.
     */
    private boolean handlePlayerGuess(int currentPlayer) {
        // Get the player's input (guess)

        // Check if the guess is correct and update the game status

        // Return true if the guess is correct, false otherwise
        return false;
    }

    /**
     * Check if the game is solved and update the 'solved' flag accordingly.
     */
    private void checkGameStatus() {
        // Implement game status checking logic here

        // Update the 'solved' flag if the game is solved
    }
}
