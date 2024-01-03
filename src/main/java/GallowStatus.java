public class GallowStatus {
    public int getCounter() {
        return counter;
    }

    private int counter;

    void mistakeCount() {
        counter++;
        updateGallowsStatus();
    }

    public void updateGallowsStatus() {
        switch (counter) {
            case (0):
                defaultStatus();
                break;
            case (1):
                firstMistake();
                break;
            case (2):
                secondMistake();
                break;
            case (3):
                thirdMistake();
                break;
            case (4):
                fourthMistake();
                break;
            case (5):
                finalMistake();
                break;
        }
    }

    void defaultStatus() {
        System.out.println("""
                   +---+
                   |   |
                       |
                       |
                       |
                       |
                =========
                """);
    }

    void firstMistake() {
        System.out.println("""
                   +---+
                   |   |
                   O   |
                   |   |
                       |
                       |
                =========
                """);
    }

    void secondMistake() {
        System.out.println("""
                   +---+
                   |   |
                   O   |
                   |   |
                   |   |
                       |
                =========
                """);
    }

    void thirdMistake() {
        System.out.println("""
                   +---+
                   |   |
                   O   |
                  /|   |
                   |   |
                       |
                =========
                """);
    }

    void fourthMistake() {
        System.out.println("""
                   +---+
                   |   |
                   O   |
                  /|\\  |
                   |   |
                       |
                =========
                """);
    }

    void finalMistake() {
        System.out.println("""
                   +---+
                   |   |
                   O   |
                  /|\\  |
                  / \\  |
                       |
                =========
                """);
    }
}
