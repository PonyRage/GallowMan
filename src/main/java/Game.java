import java.util.*;

public class Game {
    private String wordToGuess;
    private Set<Character> guessedLetters;
    private int incorrectGuesses;
    Words words = new Words();
    List<String> wordList = words.WORDS;
    GallowStatus gallowsStatus = new GallowStatus();
    Scanner sc = new Scanner(System.in);

    public Game() {
        wordToGuess = getRandomWord();
        guessedLetters = new HashSet<>();
        incorrectGuesses = 0;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    private String getRandomWord() {
        Random random = new Random();
        int index = random.nextInt(wordList.size());
        return wordList.get(index).toLowerCase();
    }

    public boolean guessLetter(char letter) {

        if (guessedLetters.contains(letter)) {
            System.out.println("Ты уже вводил этот символ!");
            return false;
        }

        guessedLetters.add(letter);

        if (wordToGuess.indexOf(letter) == -1) {
            incorrectGuesses++;

            System.out.println("Такого символа нет в загаданном слове");
            System.out.println("Количество ошибок: " + incorrectGuesses);
            gallowsStatus.mistakeCount();
            return false;
        }

        System.out.println("Есть такая буква!");
        System.out.println("Количество ошибок: " + incorrectGuesses);
        gallowsStatus.updateGallowsStatus();
        return true;
    }

    public boolean isGameWon() {
        for (char letter : wordToGuess.toCharArray()) {
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }

    public boolean isGameOver() {
        return incorrectGuesses >= 5;
    }

    public String maskWordToGuess() {
        StringBuilder maskedWord = new StringBuilder();

        for (char letter : wordToGuess.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                maskedWord.append(letter);
            } else {
                maskedWord.append("_");
            }
        }
        return maskedWord.toString();
    }

    public void start() {
        while (true) {
            System.out.println("Начать игру: напишите \"с\"");
            System.out.println("Для выхода из игры: напишите \"в\"");

            String input = sc.next();
            if (input.equalsIgnoreCase("с")) {
                System.out.println("Да начнется игра!");
                gameProcess();

            } else if (input.equalsIgnoreCase("в")) {
                System.out.println("Жаль, " +
                        "что Вы так быстро сдались, до скорой встречи!");
                break;
            } else {
                System.out.println("Вы ввели некорректное слово, попробуйте еще раз.");
            }

        }

    }

    public void gameProcess() {
        gallowsStatus.defaultStatus();
        while (!isGameOver() && !isGameWon()) {

            System.out.println("Слово: " + maskWordToGuess());
            System.out.println("Угадай букву: ");
            checkLetter();
            System.out.println();
        }

        System.out.println("Слово: " + maskWordToGuess());

        if (isGameWon()) {
            System.out.println("Поздравляем! Вы отгадали слово!");
        } else {
            System.out.println("Игра окончена! Загаданное слово было: " + getWordToGuess());
        }
        resetGame();
    }

    private void checkLetter() {
        String input = sc.next();

        if (input.length() == 1) {
            char letter = input.charAt(0);
            if (Character.isLetter(letter)) {
                guessLetter(letter);
            } else {
                System.out.println("Пожалуйста, введите букву.");
            }
        } else {
            System.out.println("Пожалуйста, введите только одну букву.");
        }
    }

    public void resetGame() {
        wordToGuess = getRandomWord();
        guessedLetters.clear();
        incorrectGuesses = 0;

    }
}
