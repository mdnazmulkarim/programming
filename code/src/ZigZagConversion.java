import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING",4));
       // System.out.println(new ZigZagConversion().convert("AB",1));
    }

    public String convert(String s, int numRows) {
        if(s.length() == 1 || numRows==1 || numRows >= s.length()) {
            return s;
        }
        List<List<Character>> list = new ArrayList<>();
        for(int i=0; i<numRows; i++) {
            list.add(new ArrayList<>());
        }

        boolean flag = true;

        int count = 0;
        int i = 0;
        while(count<s.length()) {
            if(flag) {
                list.get(i).add(s.charAt(count));
                i++;
                if (i % numRows == 0) {
                    flag = false;
                    i--;
                }
            }
            else if (!flag) {
                i--;
                list.get(i).add(s.charAt(count));
                if (i % numRows == 0) {
                    flag = true;
                    i++;
                }
            }
            count++;
        }

        AtomicReference<String> line = new AtomicReference<>("");

        list.forEach(l -> l.forEach(it -> line.updateAndGet(v -> v + it)));
        return line.get();
    }
}
