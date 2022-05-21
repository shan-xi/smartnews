import java.util.Arrays;

public class Demo {

    class Solution {
        public int solution(int[] A) {
            Arrays.sort(A);
            if (A[A.length - 1] < 0) {
                return 1;
            }
            int min = A[A.length - 1] + 1;
            for (int i = A.length - 1; i > 0; i--) {
                if (A[i] - A[i - 1] > 1) {
                    if (A[i - 1] + 1 < min) {
                        min = A[i - 1] + 1;
                    }
                }
            }
            return min;
        }
    }

    public static void main(String[] args) {
        Solution s = new Demo().new Solution();
        int[] A = {1, 3, 6, 4, 1, 2};
        System.out.println(s.solution(A));
        int[] A1 = {1, 2, 3};
        System.out.println(s.solution(A1));
        int[] A2 = {-1, -3};
        System.out.println(s.solution(A2));
        int[] A3 = {1, 100};
        System.out.println(s.solution(A3));
    }

}
