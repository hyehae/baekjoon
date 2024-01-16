import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] coordinate = new int[N][2];
        ArrayList<Integer> xCo = new ArrayList<>();

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            coordinate[i][0] = Integer.parseInt(input[0]);
            coordinate[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(coordinate, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        for(int i=0; i<N; i++) {
            System.out.println(coordinate[i][0] + " " + coordinate[i][1]);
        }
    }
}
