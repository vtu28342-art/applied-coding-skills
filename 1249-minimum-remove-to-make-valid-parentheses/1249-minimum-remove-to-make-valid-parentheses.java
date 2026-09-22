class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder str = new StringBuilder(s);
        int open = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                open++;
            } 
            else if (ch == ')') {
                if (open == 0) {
                    str.deleteCharAt(i);
                    i--;
                } else {
                    open--;
                }
            }
        }
        for (int i = str.length() - 1; i >= 0 && open > 0; i--) {
            if (str.charAt(i) == '(') {
                str.deleteCharAt(i);
                open--;
            }
        }
        return str.toString();
    }
}