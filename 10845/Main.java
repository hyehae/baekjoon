import java.io.*;
import java.util.StringTokenizer;

interface Queue {
    void push(int num);
    int pop();
    int size();
    boolean isEmpty();
    int front();
    int back();
}

class ArrayQueue implements Queue {
    private int[] array;
    private boolean isEmpty;
    private int size;
    private int curFront;
    private int curBack;

    public ArrayQueue() {
        this.array = new int[10001];
        this.isEmpty = true;
        this.size = 0;
        this.curFront = 0;
        this.curBack = 0;
    }

    @Override
    public void push(int num) {
        if(this.isEmpty) {
            this.isEmpty = false;
            this.curFront++;
        }
        this.size++;
        this.curBack++;
        array[curBack] = num;
    }

    @Override
    public int pop() {
        if(this.isEmpty) {
            return -1;
        } else {
            this.size--;
            this.curFront++;
            if(curFront > curBack) {
                curBack = curFront;
                this.isEmpty = true;
            }
            return array[curFront-1];
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.isEmpty;
    }

    @Override
    public int front() {
        if(this.isEmpty) {
            return -1;
        } else {
            return array[curFront];
        }
    }

    @Override
    public int back() {
        if(this.isEmpty) {
            return -1;
        } else {
            return array[curBack];
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayQueue arrayQueue = new ArrayQueue();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for(int loop=0; loop<N; loop++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    arrayQueue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(arrayQueue.pop());
                    break;
                case "size":
                    System.out.println(arrayQueue.size());
                    break;
                case "empty":
                    if(arrayQueue.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "front":
                    System.out.println(arrayQueue.front());
                    break;
                case "back":
                    System.out.println(arrayQueue.back());
                    break;
            }
        }
    }
}
