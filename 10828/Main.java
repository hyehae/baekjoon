import java.io.*;
import java.util.StringTokenizer;

interface Stack {
    void push(int num);
    int pop();
    int size();
    boolean isEmpty();
    int top();
}

class ArrayStack implements Stack {
    private int[] array;
    private boolean isEmpty;
    private int curTop;

    public ArrayStack() {
        this.array = new int[10001];
        this.isEmpty = true;
        this.curTop = 0;
    }

    @Override
    public void push(int num) {
        this.isEmpty = false;
        this.curTop++;
        array[curTop] = num;
    }

    @Override
    public int pop() {
        if(this.isEmpty) {
            return -1;
        } else {
            this.curTop--;
            if(curTop == 0) {
                this.isEmpty = true;
            }
            return array[curTop+1];
        }
    }

    @Override
    public int size() {
        return this.curTop;
    }

    @Override
    public boolean isEmpty() {
        return this.isEmpty;
    }

    @Override
    public int top() {
        if(this.isEmpty) {
            return -1;
        } else {
            return array[curTop];
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayStack arrayStack = new ArrayStack();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for(int loop=0; loop<N; loop++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    arrayStack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(arrayStack.pop());
                    break;
                case "size":
                    System.out.println(arrayStack.size());
                    break;
                case "empty":
                    if(arrayStack.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "top":
                    System.out.println(arrayStack.top());
                    break;
            }
        }
    }
}
