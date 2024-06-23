import java.io.*;
import java.util.*;

// 결국은 iterator를 사용해야 시간 복잡도에 안걸리는 풀이
// stack을 활용한 것은.. 포오기...
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split("");

        LinkedList<String> list = new LinkedList<>();
        for(int i = 0; i < s.length; i++) {
            list.add(s[i]);
        }

        ListIterator<String> iter = list.listIterator();
        while(iter.hasNext()) {
            iter.next();
        }

        int command = Integer.parseInt(br.readLine());
        for(int i = 0; i < command; i++) {
            String[] ss = br.readLine().split(" ");

            if(ss[0].equals("P")) {
                iter.add(ss[1]);
            }

            if(ss[0].equals("L")) {
                if(iter.hasPrevious()) iter.previous();
            }

            if(ss[0].equals("D")) {
                if(iter.hasNext()) iter.next();
            }

            if(ss[0].equals("B")) {
                if(iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            }
        }

        System.out.println(String.join("", list));
    }
}
