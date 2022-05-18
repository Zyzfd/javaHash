package Hash;

//import java.util.LinkedList;
import Hash.LinkedList;

public class Hash_Chain {
    private LinkedList[] hash_field;
    private int number_fields;
    private final int hash_const = 999991;

    public Hash_Chain(int number_fields) {
        hash_field = new LinkedList[number_fields];
        this.number_fields = number_fields;
        for (int i = 0; i < number_fields; i++) {
            hash_field[i] = new LinkedList();
        }
    }

    public void add(String value) {
        hash_field[hash_func(value)].add(value);
    }

    public int[] search(String value) {
        int ind = hash_func(value);
        
        int count = 0;
        while (true) {
            if (count != hash_field[ind].size()+1) {
                if (hash_field[ind].get(count) == value) {
                    int[] arr = {ind, count};
                    return arr;
                } else {
                    count++;
                }
            } else {
                int[] arr = {-1, -1};
                return arr;
            }
        }
    }

    public int[] del(String value) {
        int ind = hash_func(value);
        
        int count = 0;
        while (true) {
            if (count != hash_field[ind].size()+1) {
                if (hash_field[ind].get(count) == value) {
                    hash_field[ind].remove(count);
                    int[] arr = {ind, count};
                    return arr;
                } else {
                    count++;
                }
            } else {
                int[] arr = {-1, -1};
                return arr;
            }
        }
    }

    private int hash_func(String value) {
        char ascii = value.charAt(value.length()-1);
        int temp = (int)ascii * hash_const;
        return temp % number_fields;
    }

    public void print_hash() {
        for (int i = 0; i < number_fields; i++) {
            System.out.printf("[%d] ", i);
            hash_field[i].print();
            System.out.printf("\n");
        }
    }
}