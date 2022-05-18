import java.util.Hashtable;
import java.util.Random;

import Hash.Hash_Chain;
import Hash.Hash_Linear;

public class zyzf {
    
    public static void main(String[] args) {
        final int kolvo_proverok = 500;
        for (int kolvo = 0; kolvo < 200000; kolvo += 10000) {
            long memObjNow = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            //Hash_Linear hash_lin = new Hash_Linear(200000);
            //Hash_Chain hash_ch = new Hash_Chain(200000);
            Hashtable<Integer, String> hash = new Hashtable<Integer, String>(200000);
            long memObj = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

            //long time = 0;
            //long timeNow = 0;

            Random rand = new Random();
            String[] value = new String[kolvo];

            for (int i = 0; i < kolvo; i++) {
                value[i] = String.valueOf(rand.nextInt(100));
            }

            long memNow = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            //timeNow = System.currentTimeMillis();
            for (int i = 0; i < kolvo; i++) {
                //hash_ch.add(value[i]);
                //hash_lin.add(value[i]);
                hash.put(i, value[i]);
            }
            long mem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            //time = System.currentTimeMillis() - timeNow;

            // if (kolvo != 0) {
            //     timeNow = System.currentTimeMillis();
            //     for (int i = 0; i < kolvo_proverok; i++) {
            //         //hash_ch.search(value[kolvo-67]);
            //         //hash_lin.search(value[kolvo-67]);
            //         hash.containsValue(value[kolvo-67]);
            //     }
            //     time = System.currentTimeMillis() - timeNow;
            // }
            

            // timeNow = System.currentTimeMillis();
            // for (int i = 0; i < kolvo; i++) {
            //     hash_ch.del(value[i]);
            //     //hash_lin.del(value[i]);
            //     //hash.remove(i);
            // }
            // time = System.currentTimeMillis() - timeNow;

            //System.out.println(time);
            System.out.println(((mem-memNow)/1024) + ((memObj-memObjNow)/1024));
        }
    }

}
