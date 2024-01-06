import java.util.*;

// 왜 자꾸 틀리나 했더니 if문으로 continue 안해줘서 그런듯 
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        int answer = 0;


        for(int i = 0; i < n; i++) {
            int num = arr[i];

            int left = 0;
            int right = n-1;

            while(left < right) {
                if(left == i) left++;
                else if(right == i) right--;

                if(left >= right) break;

                if(arr[left]+arr[right] < num) left++;
                else if(arr[left]+arr[right] > num) right--;
                else {
                    answer++;
                    break;
                }                
            }         
        }

        System.out.println(answer);
    }
}
