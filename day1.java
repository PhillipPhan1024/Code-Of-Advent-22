import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class day1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day1Input.txt");
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
}