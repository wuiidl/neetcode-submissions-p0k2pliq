class Solution {

    private final Stack<Integer> ints = new Stack<>();
    private final String ops = "+-*/";

    private int op(int n1, int n2, String op) {
        if(op.equals("+")) {
            return n1 + n2;
        }else if(op.equals("-")) {
            return n2 - n1;
        }else if(op.equals("*")) {
            return n1 * n2;
        }else {
            return n2 / n1;
        }
    }



    public int evalRPN(String[] tokens) {
        for(String s : tokens) {
            if(s.equals("+")) {
                ints.push(ints.pop() + ints.pop());
            }else if(s.equals("-")) {
                int a = ints.pop();
                int b = ints.pop();
                ints.push(b - a);
            }else if(s.equals("*")) {
                ints.push(ints.pop() * ints.pop());
            }else if(s.equals("/")) {
                int a = ints.pop();
                int b = ints.pop();
                ints.push(b / a);
            }else {
                ints.push(Integer.parseInt(s));
            }
        }
        return ints.pop();
    }
}
