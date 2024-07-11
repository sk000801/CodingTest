import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        int[] ans = new int[n];

        String[] s = br.readLine().split("");
        for(int j = 0; j < n; j++) {
            temp1[j] = Integer.parseInt(s[j]);
            temp2[j] = temp1[j];
        }

        s = br.readLine().split("");
        for(int j = 0; j < n; j++) {
            ans[j] = Integer.parseInt(s[j]);
        }

        temp1[0] = 1-temp1[0];
        temp1[1] = 1-temp1[1];

        int count1 = 1;
        int count2 = 0;

        for(int i = 1; i < n; i++) {
            if(temp1[i-1] != ans[i-1]) {
                temp1[i-1] = 1-temp1[i-1];
                temp1[i] = 1-temp1[i];
                count1++;

                if(i != n-1) temp1[i+1] = 1-temp1[i+1];
            }

            if(temp2[i-1] != ans[i-1]) {
                temp2[i-1] = 1-temp2[i-1];
                temp2[i] = 1-temp2[i];
                count2++;

                if(i != n-1) temp2[i+1] = 1-temp2[i+1];
            }
        }

        if(temp1[n-1] != ans[n-1]) count1 = 100_000;
        if(temp2[n-1] != ans[n-1]) count2 = 100_000;

        if(count1 == 100_000 && count2 == 100_000) System.out.println(-1);
        else System.out.println(Math.min(count1, count2));
    }   
}
