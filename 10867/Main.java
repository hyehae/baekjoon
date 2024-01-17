import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            int tmp = Integer.parseInt(input[i]);
            if(!integerArrayList.contains(tmp)) {
                integerArrayList.add(tmp);
            }
        }

        Collections.sort(integerArrayList);

        for(int a : integerArrayList) {
            System.out.print(a + " ");
        }
    }
}
