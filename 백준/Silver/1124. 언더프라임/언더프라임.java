import java.util.*;

public class Main {

    public static boolean isPrime(int number) {
        int primeNum = getNum(number);

        if(primeNum == 0 || primeNum == 1) return false;

        for(int i = 2; i <= Math.sqrt(primeNum); i++) {
            if(primeNum % i == 0) return false;
        }

        return true;
    }

    public static int getNum(int number) {
        List<Integer> list = new ArrayList<>();
        int idx = 2;

        while(idx <= number) {
            if(number % idx == 0) {
                list.add(idx);
                //소수를 구할 때와는 다르게 값을 직접 나눠줘야함
                number /= idx;
            } else {
                idx++;
            }
        }

        return list.size();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        int count = 0;
        for(int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            if(isPrime(i)) count++;
        }

        System.out.println(count);
    }
}
