import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<Integer> strLen = new ArrayList<>();

        String tmp;
        for (int i=0; i<N; i++) {
            tmp = br.readLine();
            if(!stringArrayList.contains(tmp)) {
                stringArrayList.add(tmp);
            }
        }

        for(String s : stringArrayList) {
            if(!strLen.contains(s.length())) {
                strLen.add(s.length());
            }
        }

        Collections.sort(strLen);
        Collections.sort(stringArrayList);

        String outputTmp;
        for(int len : strLen) {
            for(int i=0; i< stringArrayList.size(); i++) {
                outputTmp = stringArrayList.get(i);
                if(outputTmp.length() == len) {
                    System.out.println(outputTmp);
                }
            }
        }
    }
}
