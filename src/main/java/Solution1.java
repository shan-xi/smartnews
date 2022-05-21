import java.sql.Array;
import java.util.*;

public class Solution1 {

    class Solution {


        public int solution(int[][] A) {
            Map<String, String> head = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    String key = i + "" + j;
                    head.putIfAbsent(key, key);

                    // up
                    if ((i - 1 >= 0) && A[i][j] == A[i - 1][j]) {
                        head.put(key, head.get((i - 1) + "" + j));
                    }
                    // down
                    if ((i + 1 < A.length) && A[i][j] == A[i + 1][j]) {
                        head.put((i + 1) + "" + j, head.get(i + "" + j));
                    }
                    // left
                    if ((j - 1) >= 0 && A[i][j] == A[i][j - 1]) {
                        head.put(key, head.get(i + "" + (j - 1)));
                    }
                    // right
                    if ((j + 1 < A[i].length) && A[i][j] == A[i][j + 1]) {
                        if (head.get(i + "" + (j + 1)) == null) {
                            head.put(i + "" + (j + 1), head.get(i + "" + j));
                        } else {
                            head.put(i + "" + j, head.get(i + "" + (j + 1)));
                        }
                    }
                }
            }
            Set<String> d = new HashSet();
            for(String key : head.keySet()){
                d.add(head.get(key));
            }

            return d.size();
        }
    }

    public static void main(String[] args) {
        Solution1.Solution s = new Solution1().new Solution();
        int[][] A = new int[][]{
                {5, 4, 4},
                {4, 3, 4},
                {3, 2, 4},
                {2, 2, 2},
                {3, 3, 4},
                {1, 4, 4},
                {4, 1, 1},};
        System.out.println(s.solution(A));

        int[][] A1 = new int[][]{
                {4, 4, 4},
                {4, 3, 4},
                {3, 2, 4},
                {2, 2, 2},
                {3, 3, 4},
                {1, 4, 4},
                {4, 1, 1},};
        System.out.println(s.solution(A1));

    }
}
