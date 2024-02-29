import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long modulo(long A, long B, long C) {
        /*
        * a^b * a^b = a^2b
        * (a%n * b%n)%n = (a * b)%n
        *
        * A^B mod C
        * = (A^(B/2) * A^(B/2)) mod C
        * = (A^(B/2) mod C * A^(B/2) mod C) mod C
        *
        * A^(B/2) mod C
        * = (A^(B/4) * A^(B/4)) mod C
        * = (A^(B/4) mod C * A^(B/4) mod C) mod C
        *
        * if (B == 2k+1)
        * A^(2k+1) mod C
        * = (A * A^k * A^k) mod C
        * = (A mod C * A^k mod C * A^k mod C) mod C
        * */

        if (B == 1) {
            return A % C;
        }

        long result = modulo(A, B/2, C);
        result = result * result % C;

        if (B%2 == 0) {
            return result;
        }

        return result * (A % C) % C;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);
        long C = Long.parseLong(input[2]);

        System.out.println(modulo(A, B, C));
    }
}