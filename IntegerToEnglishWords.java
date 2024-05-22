// Time Complexity : O(1) -> since the while loop runs max of 4 times
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    String[] thousands = new String[]{"", " Thousand ", " Million ", " Billion "};

    String[] belowTwenty = {"","One", "Two", "Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};

    String[] tens = {"", "", "Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    public String numberToWords(int num) {
        String result = " ";

        int i=0;
        if(num == 0){
            result = "Zero";
        }
        while(num > 0) {
            int triplet = num % 1000;
            if(triplet != 0) {
                result = helper(triplet) + thousands[i] + result;
            }
            num = num /1000;
            i++;
        }

        return result.trim();
    }

    private String helper(int num) {
        String result = " ";

        if(num < 20) {
            result = belowTwenty[num];
        }else if(num < 100) {
            result = tens[num/10] +" "+ belowTwenty[num % 10];
        }else{
            result = belowTwenty[num /100] + " Hundred " + helper(num % 100);
        }

        return result.trim();
    }
}