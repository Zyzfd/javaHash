package Hash;

public class Hash_Linear {
    private String[][] hash_field;
    private int number_fields;
    private final int hash_const = 999991;

    public Hash_Linear(int number_fields) {
        hash_field = new String[number_fields][2];
        this.number_fields = number_fields;

        for (int i = 0; i < number_fields; i++) {
            hash_field[i][0] = null;
            hash_field[i][1] = "0";
        }
    }

    public void add(String value) {
        if (is_not_full() == 0) {
            System.out.println("Hash table is full");
            return;
        }

        int ind = hash_func(value);

        while (true) {
            if (hash_field[ind][0] == null) {
                hash_field[ind][0] = value;
                hash_field[ind][1] = "0";
                return;
            } else {
                if (ind < number_fields-1) {
                    ind++;
                } else {
                    ind = 0;
                }
            }
        }
    }

    public int search(String value) {
        int ind = hash_func(value);
        
        int count = 0;
        while (true) {
            if (count != number_fields) {
                if (hash_field[ind][0] == value && (hash_field[ind][0] != null || hash_field[ind][1] == "1")) {
                    return ind;
                } else {
                    if (ind < number_fields-1) {
                        ind++;
                    } else {
                        ind = 0;
                    }
                    count++;
                }
            } else {
                return -1;
            }
        }
    }

    public int del(String value) {
        int ind = hash_func(value);

        int count = 0;
        while (true) {
            if (count != number_fields) {
                if (hash_field[ind][0] == value) {
                    hash_field[ind][0] = null;
                    hash_field[ind][1] = "1";
                    return ind;
                } else {
                    if (ind < number_fields-1) {
                        ind++;
                    } else {
                        ind = 0;
                    }
                    count++;
                }
            } else {
                return -1;
            }
        }
    }

    public int is_not_full() {
        int count = 0;
        for (int i = 0; i < hash_field.length; i++) {
            if (hash_field[i][0] == null) {
                count++;
            }
        }
        return count;
    }

    private int hash_func(String value) {
        char ascii = value.charAt(value.length()-1);
        int temp = (int)ascii * hash_const;
        return temp % number_fields;
    }

    public void print_hash() {
        for (int i = 0; i < number_fields; i++) {
            System.out.printf("[%d] ", i);
            System.out.print(hash_field[i][0]);
            System.out.printf("\n");
        }
    }
}
