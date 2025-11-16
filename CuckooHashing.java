import java.util.*;
public class CuckooHashing {
    private final int size;
    private int[] table1, table2;
    private final int maxLoop = 10;
    public CuckooHashing(int size) {
        this.size = size;
        table1 = new int[size];
        table2 = new int[size];
        Arrays.fill(table1, -1);
        Arrays.fill(table2, -1);
    }
    private int h1(int k) {
        return ((12 * k + 2) % 8191) % size;
    }
    private int h2(int k) {
        return ((5 * k + 1) % 8191) % size;
    }
    public void insert(int key) {
        int loop = 0;
        int pos = h1(key);
        while (loop < maxLoop) {
            if (table1[pos] == -1) {
                table1[pos] = key;
                return;
            }
            int displaced = table1[pos];
            table1[pos] = key;
            key = displaced;
            pos = h2(key);
            if (table2[pos] == -1) {
                table2[pos] = key;
                return;
            }
            displaced = table2[pos];
            table2[pos] = key;
            key = displaced;
            pos = h1(key);
            loop++;
        }
        System.out.println("Rehash needed for key: " + key);
    }
    public void printTable() {
        System.out.println("Table 1: " + Arrays.toString(table1));
        System.out.println("Table 2: " + Arrays.toString(table2));
    }
}
