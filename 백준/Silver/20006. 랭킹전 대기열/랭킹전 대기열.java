import java.util.*;

public class Main {

    public static class Player implements Comparable<Player> {
        int level;
        String name;
        boolean flag;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player p1) {
            return name.compareTo(p1.name);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        String[] s = in.nextLine().split(" ");
        int p = Integer.parseInt(s[0]);   
        int m = Integer.parseInt(s[1]);  
        Player[] players = new Player[p];

        for (int i = 0; i < p; i++) {
            s = in.nextLine().split(" ");
            int level = Integer.parseInt(s[0]);
            String name = s[1];
            players[i] = new Player(level, name);
        }

        for (int i = 0; i < p; i++) {
            ArrayList<Player> list = new ArrayList<>();
            if (!players[i].flag) {
                for (int j = i; j < p; j++) {
                    if (list.size() == m) {
                        break;
                    }
                    int level = players[j].level;
                    String name = players[j].name;
                    if (!players[j].flag && players[i].level - 10 <= level && players[i].level + 10 >= level) {
                        players[j].flag = true;
                        list.add(new Player(level, name));
                    }
                }

                Collections.sort(list);
                if (list.size() == m) {
                    sb.append("Started!").append("\n");
                } else {
                    sb.append("Waiting!").append("\n");
                }

                for (int r = 0; r < list.size(); r++) {
                    Player player = list.get(r);
                    sb.append(player.level).append(" ").append(player.name).append("\n");
                }
            }

        }
        System.out.println(sb);
    }
}
