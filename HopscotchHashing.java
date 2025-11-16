import java.util.*;
public class HopscotchHashing {
    private final int[] table;
    private final int H;
    private final int size;
    public HopscotchHashing(int size, int H) {
        this.size = size;
        this.H = H;
        table = new int[size];
        Arrays.fill(table, -1);
    }
    private int hash(int k) {
        return ((12 * k + 2) % 8191) % size;
    }
    public void insert(int key) {
        int idx = hash(key);
        for (int i = 0; i < H; i++) {
            int pos = (idx + i) % size;
            if (table[pos] == -1) {
                table[pos] = key;
                return;
            }
        }
        System.out.println("Failed to insert " + key + " — rehash needed.");
    }
    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.printf("Index %2d: %s\n", i, table[i] == -1 ? "-" : table[i]);
        }
    }
}
