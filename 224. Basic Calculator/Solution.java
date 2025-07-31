class Solution {
    public int calculate(String s) {
        int num = 0;
        int res = 0;
        int sign = 1;
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = (num * 10) + (ch - '0');
            } else if (ch == '+') {
                res += (num * sign);
                num = 0;
                sign = 1;
            } else if (ch == '-')  {
                res += (num * sign);
                num = 0;
                sign = -1;
            } else if (ch == '(') {
                stk.push(res);
                stk.push(sign);
                num = 0;
                res = 0;
                sign = 1;
            } else if (ch == ')') {
                res += (num * sign);
                num = 0;

                int stk_sign = stk.peek();
                stk.pop();
                int last_res = stk.peek();
                stk.pop();

                res *= stk_sign;
                res += last_res;
            }
        }

        res += (num * sign);
        return res;
    }
}