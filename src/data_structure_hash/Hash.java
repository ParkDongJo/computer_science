package data_structure_hash;

/**
 * Created by parkdongjo on 2017. 11. 1..
 */
public class Hash {

    private String[] hashArray;
    private int size;

    public Hash(int size) {
        this.size = size;
        this.hashArray = new String[size];
    }

    public int add(String data) {
        int code = division(data);
        if(isColision(code)) {
           probing(code);
        }else{
            hashArray[code] = data;
        }

        return code;
    }

    public int delete(int code) {
        int result = -1;

        if(!isEmpty(code)) {
            hashArray[code] = null;
            result = 1;
        }
        return result;
    }

    public String search(int code) {
        return hashArray[code];
    }

    private int division(String data) {
        return sumChar(data) % this.size;
    }

    private int probing(int code) {
        code++;
        if(!isColision(code)) {
            return code;
        }
        return probing(code);
    }

    private int sumChar(String data) {
        int sum = 0;
        for(int i=0; i<data.length(); i++) {
            Character c = data.charAt(i);
            sum += c;
        }

        return sum;
    }

    private boolean isColision(int code) {
        return this.hashArray[code] != null ? true : false;
    }

    private boolean isEmpty(int code) {
        return hashArray[code] == null ? true : false;
    }
}
