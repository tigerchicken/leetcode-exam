import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * 根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 *
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 通过次数37,499提交次数75,075
 */
public class EvalRPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer>s=new Stack();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i]=="+"){
                int b=s.pop();
                int a=s.pop();
                s.push(a+b);
            }else if(tokens[i]=="-"){
                int b=s.pop();
                int a=s.pop();
                s.push(a-b);
            }else if(tokens[i]=="*"){
                int b=s.pop();
                int a=s.pop();
                s.push(a*b);
            }else if(tokens[i]=="/"){
                int b=s.pop();
                int a=s.pop();
                s.push(a/b);
            }else{
                int num=Integer.parseInt(tokens[i]);
                s.push(num);
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        String[]s={"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(s));
    }
}
