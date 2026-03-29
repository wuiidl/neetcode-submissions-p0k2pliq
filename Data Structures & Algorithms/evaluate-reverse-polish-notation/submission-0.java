class Solution {
    public int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> t = new Stack<>();
        for(String s: tokens) {
            if(s.equals("+")) {
                t.push(t.pop() + t.pop());
            }else if(s.equals("-")) {
                int b = t.pop();
                int a = t.pop();
                t.push(a - b);
            }else if(s.equals("*")) {
                t.push(t.pop() * t.pop());
            }else if(s.equals("/")) {
                int b = t.pop();
                int a = t.pop();
                t.push(a / b);
            }else{
                t.push(Integer.parseInt(s));
            }
        }
        return t.peek();
    }
}
