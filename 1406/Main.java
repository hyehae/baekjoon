import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    // Stack<Character> str1 = new Stack<>();
    // 으로 해야지 시간초과 발생하지 않는다고 함.
    // String이나 StringTokenizer는 무거움

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> front = new Stack<>();
        Stack<Character> rear = new Stack<>();

        String initialString = br.readLine();
        for(int i=0; i<initialString.length(); i++) {
            front.push(initialString.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            String[] cmdStr = br.readLine().split(" ");
            char cmd = cmdStr[0].charAt(0);
            switch (cmd) {
                case 'L':
                    if(!front.isEmpty())
                        rear.push(front.pop());
                    break;
                case 'D':
                    if(!rear.isEmpty())
                        front.push(rear.pop());
                    break;
                case 'B':
                    if(!front.isEmpty())
                        front.pop();
                    break;
                case 'P':
                    front.push(cmdStr[1].charAt(0));
                    break;
            }
        }

        while(!front.isEmpty()) {
            rear.push(front.pop());
        }

        StringBuilder finalString = new StringBuilder();
        while(!rear.isEmpty()) {
            finalString.append(rear.pop());
        }
        System.out.println(finalString);
    }
}
