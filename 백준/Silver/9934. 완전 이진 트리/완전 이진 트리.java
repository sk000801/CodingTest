import java.util.*;

//중위순회(왼-루-오)
//44분 왜 마지막 숫자가 안나오지ㅠㅠ
public class Main {
    static StringBuffer sb = new StringBuffer();
    static int count = 0;
    static int[] nodes;
    static List<List<Integer>> list = new ArrayList<>();

    public static void divide(int depth, int start, int end, int k) {
        if(depth == k) return;

        int mid = (start+end)/2;
        list.get(depth).add(nodes[mid]);

        divide(depth+1, start, mid, k);
        divide(depth+1, mid+1, end, k);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt(); //깊이
        nodes = new int[(int)Math.pow(2, k)-1];
        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = in.nextInt();
        }

        for(int i = 0; i < k; i++) {
            list.add(new ArrayList<>());
        }

        divide(0, 0, nodes.length-1, k);

        for(int i = 0; i < k; i++) {
            for(int j = 0; j < list.get(i).size(); j++) {
                sb.append(list.get(i).get(j)+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
