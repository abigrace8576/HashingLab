import java.util.*;

public class PerfectHashing {
    private final int p = 8191;
    private final int m = 7;
    private List<List<Integer>> level1;
    private List<int[]> level2Tables;

    public PerfectHashing(List<Integer> keys) {
        level1 = new ArrayList<>(Collections.nCopies(m, null));
        for (int key : keys) {
            int bucket = key % m;
            if (level1.get(bucket) == null) level1.set(bucket, new ArrayList<>());
            level1.get(bucket).add(key);
        }
//tspmoicel like did i even type anything right 🥀🥀🥀🥀🥀
        level2Tables = new ArrayList<>();
        for (List<Integer> bucket : level1) {
            if (bucket == null) {
                level2Tables.add(null);
                continue;
            }
            int size = bucket.size() * bucket.size();
            int[] table = new int[size];
            Arrays.fill(table, -1);
            boolean success = false;
            Random rand = new Random();
            while (!success) {
                success = true;
                int a = rand.nextInt(p - 1) + 1;
                int b = rand.nextInt(p);
                Arrays.fill(table, -1);
                for (int key : bucket) {
                    int idx = ((a * key + b) % p) % size;
                    if (table[idx] != -1) {
                        success = false;
                        break;
                    }
                    table[idx] = key;
                }
            }
            level2Tables.add(table);
        }
    }
//AND THE OSCAR FOR BESTEST PARSING EVER? anyone but me.
    public void printTable() {
        for (int i = 0; i < level2Tables.size(); i++) {
            System.out.print("Bucket " + i + ": ");
            if (level2Tables.get(i) == null) {
                System.out.println("[]");
            } else {
                System.out.println(Arrays.toString(level2Tables.get(i)));
            }
        }
    }
}
//my fingies hurt
