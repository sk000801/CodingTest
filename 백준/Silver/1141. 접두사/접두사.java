import java.util.*;

// 접두사 x집합 = 집합의 한 단어가 다른 단어의 접두어가 되지 않는 집합
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String[] text = new String[n];

        for(int i = 0; i < n; i++) {
            text[i] = in.nextLine();
        }

        Arrays.sort(text, (a, b) -> a.length()-b.length());

        int count = 0;

        for(int i = 0; i < n; i++) {
            String ori = text[i];

            boolean flag = false;
            for(int j = i+1; j < n; j++) {
                if(i != j) {
                    String comp = text[j];

                    if(comp.startsWith(ori)){
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag) count++;
        }

        System.out.println(count);
    }
}
