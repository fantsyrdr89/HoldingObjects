package armstrong.alexandra;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBook extends TreeMap {

    public String[] lookUp(String name) {
        return (String[]) get(name);
    }

    public void add(String name, String[] number) {
        put(name, number);
    }

    public void add(String name, int[][] number) {
        for(int i = 0; i < number.length; i++) {
            String fixedNumber = "(" + number[0][0] + number[0][1] + number[0][2] + ") " + number[0][3] + number[0][4] + number[0][5] + "-" + number[0][6] + number[0][7] + number[0][8] + number[0][9];
            put(name, fixedNumber);
        }
    }

    public void listAllNames() {
        for (Object x : keySet()) {
            System.out.println((String) x);
        }
    }

    public void listAllEntries() {
        for (Object x : keySet()) {
            System.out.println((String) x + lookUp((String) x));
        }
    }

    public String reverseLookUp(String[] number) {
        String test = number[0];
        for (Object x : keySet()) {
            String[] temp = (String[])get(x);
            for(int i = 0; i < temp.length; i++) {
                if (temp[i].equals(test)) {
                    return (String) x;
                }
            }
        }
        return "Number Not Listed.";
    }
}
