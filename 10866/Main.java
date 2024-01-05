import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arrayDeque = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for(int loop=0; loop<N; loop++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    arrayDeque.add(0, Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    arrayDeque.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(arrayDeque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(arrayDeque.get(0));
                        arrayDeque.remove(0);
                    }
                    break;
                case "pop_back":
                    if(arrayDeque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(arrayDeque.get(arrayDeque.size() - 1));
                        arrayDeque.remove(arrayDeque.size() - 1);
                    }
                    break;
                case "size":
                    System.out.println(arrayDeque.size());
                    break;
                case "empty":
                    if(arrayDeque.isEmpty()) {
                        System.out.println("1");
                    }  else {
                        System.out.println("0");
                    }
                    break;
                case "front":
                    if(arrayDeque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(arrayDeque.get(0));
                    }
                    break;
                case "back":
                    if(arrayDeque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(arrayDeque.get(arrayDeque.size()-1));
                    }
                    break;
            }
        }

    }
}