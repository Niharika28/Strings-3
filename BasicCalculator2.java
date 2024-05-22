// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Using stack approach
class Solution {
    public int calculate(String s) {
        s.trim();
        int result =0;
        Stack<Integer> st = new Stack<>();

        int currNum =0;
        char lastsign='+';

        for(int i=0;i < s.length();i++) {
            char c = s.charAt(i);

            // if it is a digit
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c -'0';
            }
            // if it is a operator
            if((!Character.isDigit(c) && c != ' ') || i == s.length()-1) {

                if(lastsign == '+') {
                    st.push(currNum);
                }else if(lastsign == '-') {
                    st.push(-currNum);
                }else if(lastsign == '*') {
                    st.push(currNum * st.pop());
                }else {
                    st.push(st.pop() / currNum);
                }

                currNum =0;
                lastsign = c;
            }
        }


        while(!st.isEmpty()) {
            result += st.pop();
        }
        return result;
    }
}
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// space optimization
class Solution {
    public int calculate(String s) {
        s.trim();
        int result =0;

        int currNum =0;
        char lastsign='+';
        int calc =0;
        int tail =0;

        for(int i=0;i < s.length();i++) {
            char c = s.charAt(i);

            // if it is a digit
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c -'0';
            }
            // if it is a operator
            if((!Character.isDigit(c) && c != ' ') || i == s.length()-1) {

                if(lastsign == '+') {
                    calc += currNum;
                    tail = currNum;
                }else if(lastsign == '-') {
                    calc -= currNum;
                    tail = -currNum;
                }else if(lastsign == '*') {
                    calc = (calc - tail) + (tail * currNum);
                    tail = tail * currNum;
                }else if(lastsign == '/') {
                    calc = (calc - tail) + (tail / currNum);
                    tail = tail / currNum;
                }

                currNum =0;
                lastsign = c;
            }
        }


        return calc;
    }
}