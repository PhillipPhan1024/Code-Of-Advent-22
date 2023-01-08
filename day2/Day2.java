import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        partOne();
    }

    public static void partOne() throws FileNotFoundException {
        File file = new File("Day2Input.txt");
        // 1 for rock, 2 for sci, 3 for paper
        // 0 L, 3 T, 6 W
        int totalScore = 0;
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()) {
            String first = scan.next();
            String second = scan.next();
            if(second.equals("X")) {
                if(first.equals("A")) {
                    totalScore += 3;
                    // B is loss.
                } else if(first.equals("C")) {
                    totalScore += 6;
                }
                totalScore += 1;
            } else if(second.equals("Y")) {
                if(first.equals("A")) {
                    totalScore += 6;
                } else if(first.equals("B")) {
                    totalScore += 3;
                } // C is loss.
                totalScore += 2;
            } else {
                if(first.equals("B")) {
                    totalScore += 6;
                } else if(first.equals("C")) {
                    totalScore += 3;
                }
                totalScore += 3;
            }
        }
        scan.close();
        System.out.println(totalScore);
    }
}
