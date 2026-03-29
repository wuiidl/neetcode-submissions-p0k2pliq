class Solution {
    public boolean isValid(String s) {

        if(s==null || s.length() < 2) return false;

        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()) {
            // is closing bracket
            if(closeToOpen.containsKey(c)) {
                if(!st.isEmpty() && st.peek() == closeToOpen.get(c)) {
                    st.pop();
                }else{
                    return false;
                }
            }else{
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}
