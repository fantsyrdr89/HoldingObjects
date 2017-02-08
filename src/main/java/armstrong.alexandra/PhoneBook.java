package armstrong.alexandra;

import java.util.Map;
import java.util.TreeMap;

class RecordNotPresent extends Exception{}


public class PhoneBook extends TreeMap {

    public String[] lookUp(String name) throws RecordNotPresent {
        try {
            if((String[]) get(name) == null){
                throw new RecordNotPresent();
            } else {
                return (String[]) get(name);
            }
        } catch (RecordNotPresent e){
            e.printStackTrace();
            String[] s = {"Record not found."};
            return s;
        }
    }

    public void add(String name, String[] number) {
        try {
            put(name, number);
        } catch(ClassCastException e){
            System.out.println("Not a valid entry");
        }
    }

    public void add(String name, int[][] number) {
        try {
            for (int i = 0; i < number.length; i++) {
                String fixedNumber = "(" + number[0][0] + number[0][1] + number[0][2] + ") " + number[0][3] + number[0][4] + number[0][5] + "-" + number[0][6] + number[0][7] + number[0][8] + number[0][9];
                put(name, fixedNumber);
            }
        } catch (NullPointerException e){
            System.out.println("Not a valid phone number");
        }
    }

    public void listAllNames() {
        for (Object x : keySet()) {
            System.out.println((String) x);
        }
    }

    public void listAllEntries() {
        for (Object x : keySet()) {
            System.out.println((String) x + get((String) x));
        }
    }

    public String reverseLookUp(String[] number) throws RecordNotPresent {
        try {
            String test = number[0];
            for (Object x : keySet()) {
                String[] temp = (String[]) get(x);
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i].equals(test)) {
                        return (String) x;
                    }
                }
            }
            throw new RecordNotPresent();
        } catch (RecordNotPresent e){
            e.printStackTrace();
            return "Number Not Listed.";
        }
    }
}
