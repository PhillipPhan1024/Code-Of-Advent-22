import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class day1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day1Input.txt");
        partOne(file);
        partTwo(file);
    }

    public static void partOne(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        // Groups of numbers = one elf, space separates each elf
        int mostCalories = 0;
        int currCalories = 0;
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            if(!line.isEmpty()) {
                currCalories += Integer.parseInt(line);
            } else {
                if(currCalories > mostCalories) {
                    mostCalories = currCalories;
                }
                currCalories = 0;
            }
        }
        scan.close();
        System.out.println("The Elf carrying the most Calories has: " + mostCalories);
    }

    public static void partTwo(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        int[] topThree = new int[3];
        int currCalories = 0;
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            if(!line.isEmpty()) {
                currCalories += Integer.parseInt(line);
            } else {
                int replacement = currCalories;
                for(int i = 0; i < topThree.length; i++) {
                    if(replacement > topThree[i]) {
                        int temp = topThree[i];
                        topThree[i] = replacement;
                        replacement = temp;
                    }
                }
                currCalories = 0;
            }
        }
        scan.close();
        int mostTotal = topThree[0] + topThree[1] + topThree[2];
        System.out.println("The three Elves with the most Calories has: " + mostTotal);
    }
}