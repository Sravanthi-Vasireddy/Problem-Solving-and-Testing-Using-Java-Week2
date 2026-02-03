import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

public class Solution {

    public static PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++)
                if (n % i == 0) return false;
            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return n -> {
            int original = n, reverse = 0;
            while (n > 0) {
                reverse = reverse * 10 + n % 10;
                n /= 10;
            }
            return original == reverse;
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of test cases:");
        int T = sc.nextInt();

        while (T-- > 0) {
            System.out.println("Enter choice (1=Odd, 2=Prime, 3=Palindrome) and number:");
            int choice = sc.nextInt();
            int num = sc.nextInt();

            boolean result = false;

            if (choice == 1) result = isOdd().check(num);
            else if (choice == 2) result = isPrime().check(num);
            else if (choice == 3) result = isPalindrome().check(num);

            if (choice == 1) System.out.println(result ? "ODD" : "EVEN");
            else if (choice == 2) System.out.println(result ? "PRIME" : "COMPOSITE");
            else if (choice == 3) System.out.println(result ? "PALINDROME" : "NOT PALINDROME");
        }

        sc.close();
    }
}
