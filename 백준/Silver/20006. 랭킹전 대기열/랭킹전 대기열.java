import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> player = new LinkedHashMap<>();

        for(int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            player.put(name, l);
        }

        List<String> names = new ArrayList<>(player.keySet());

        boolean[] visited = new boolean[p+1];

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < p; i++) {
            String name1 = names.get(i);
            int level1 = player.get(name1);
            
            if(visited[i]) continue;
            
            List<String> list = new ArrayList<>();
            for(int j = i; j < p; j++) {
                if(list.size() == m) break;

                String name = names.get(j);
                int level = player.get(name);

                if(!visited[j] && level1 - 10 <= level && level1 + 10 >= level) {
                    visited[j] = true;
                    list.add(name);
                }
            }

            Collections.sort(list);

            if(list.size() == m) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }

            for(String s : list) {
                sb.append(player.get(s)).append(" ").append(s).append("\n");
            }
        }

        System.out.println(sb);
    }
}
