import java.util.*;

//덱 자료구조?? (양방향 연결리스트)
//앞/뒤 중 어느곳을 바라보는지 변수로 두고 판별
public class Main {
    static StringBuffer sb = new StringBuffer();

    public static void execute(String command, ArrayDeque<Integer> dq) {
        boolean isFront = true;

        for(int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);

            if(c == 'R') {
                isFront = !isFront;
            } else if(c == 'D') {
                if(isFront) {
                    if(dq.pollFirst() == null) {
                        sb.append("error\n");
                        return;
                    }
                } else {
                    if(dq.pollLast() == null) {
                        sb.append("error\n");
                        return;
                    }
                }
            }
        }

        sb.append("[");
        if(dq.size() > 0) {
            if(isFront) {
                sb.append(dq.pollFirst());

                while(!dq.isEmpty()) {
                    sb.append(",").append(dq.pollFirst());
                }
            } else {
                sb.append(dq.pollLast());

                while(!dq.isEmpty()) {
                    sb.append(",").append(dq.pollLast());
                }
            }
        }
        sb.append("]\n");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());
        for(int i = 0; i < t; i++) {
            String s = in.nextLine();
            int n = Integer.parseInt(in.nextLine());
            
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            String s2 = in.nextLine();
            String[] value = s2.substring(1, s2.length()-1).split(",");

            for(int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(value[j]));
            }

            execute(s, deque);
        }

        System.out.println(sb);
    }   
}
