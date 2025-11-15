import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
// this should print all the tables i need... gulp
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> input = new ArrayList<>();
        Scanner scanner = new Scanner(new File("TestSequence.txt"));
        while (scanner.hasNextInt()) {
            input.add(scanner.nextInt());
        }
//will this work???? yeahhhhhh
        System.out.println("=== Perfect Hashing ===");
        PerfectHashing perfect = new PerfectHashing(input);
        perfect.printTable(); //yeah ur so perfect
        System.out.println("\n=== Cuckoo Hashing ===");
        CuckooHashing cuckoo = new CuckooHashing(13);
        for (int key : input) {
            cuckoo.insert(key);
        }
        cuckoo.printTable();

        System.out.println("\n=== Hopscotch Hashing ===");
        HopscotchHashing hopscotch = new HopscotchHashing(16, 4);
        for (int key : input) {
            hopscotch.insert(key);
        }
        hopscotch.printTable();
    }
}
