import java.util.ArrayList;
// import java.util.Random;

public class PuzzleTest {
    public static void main(String[] args) {

        PuzzleJava generator = new PuzzleJava();

        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println(randomRolls);

        System.out.println("Random letter: " + generator.getRandomLetter());

        System.out.println("Random password: " + generator.generatePassword());

        System.out.println("New Password Set: " + generator.getNewPasswordSet(8));

    }

}