import java.util.Stack;

public class Solution2 {

    class Solution {
        public int solution(int[] A) {
            if (A.length == 1 || A.length == 2) {
                return A.length;
            }

            Stack<Integer> even = new Stack<>();
            Stack<Integer> odd = new Stack<>();
            even.push(A[0]);
            odd.push(A[1]);
            int longest = Integer.MIN_VALUE;
            for (int i = 2; i < A.length; i++) {
                int v = A[i];
                if (i % 2 == 0) {
                    if (even.peek() != v) {
                        if (even.size() + odd.size() > longest) {
                            longest = even.size() + odd.size();
                        }
                        even.clear();
                    }
                    even.push(v);
                } else {
                    if (odd.peek() != v) {
                        if (even.size() + odd.size() > longest) {
                            longest = even.size() + odd.size();
                        }
                        odd.clear();
                    }
                    odd.push(v);
                }
            }
            if (even.size() + odd.size() > longest) {
                longest = even.size() + odd.size();
            }
            return longest;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution2().new Solution();
        int[] A = {3, 2, 3, 2, 3};
        System.out.println(s.solution(A));
        int[] A1 = {3, -7, 3, -7, 3};
        System.out.println(s.solution(A1));
        int[] A2 = {4, 4, 4};
        System.out.println(s.solution(A2));
        int[] A3 = {5, 5, 4, 5, 4};
        System.out.println(s.solution(A3));
        int[] A4 = {-3, 2, 3};
        System.out.println(s.solution(A4));
        int[] A5 = {7, 4, -2, 4, -2, -9};
        System.out.println(s.solution(A5));
        int[] A6 = {-5, -5, -5};
        System.out.println(s.solution(A6));
        int[] A7 = {7, -1, 7};
        System.out.println(s.solution(A7));
        int[] A8 = {4};
        System.out.println(s.solution(A8));
        int[] A9 = {7, -5, -5, -5, 7, -1, 7};
        System.out.println(s.solution(A9));
        int[] A10 = {7, -5, -5, -5, -5, -5, -5, 7, -1, 7};
        System.out.println(s.solution(A10));
    }
}
