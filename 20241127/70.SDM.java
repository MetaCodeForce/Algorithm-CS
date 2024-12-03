package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _070 {
    public static void main(String args[]) {
        int n = 2;
        System.out.println(Solution(n));
    }

    public static int Solution(int n) {
        int result = 0;
        int A = 0;
        int B = 1;
        int C = 0;
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            C = A + B;
            A = B;
            B = C;
            resultList.add(C);
        }

        //System.out.println(resultList);

        result = resultList.get(n-1);
        return result;
    }
}
