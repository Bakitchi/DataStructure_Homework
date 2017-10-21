//Calc.java 布尔计算器
//引入输入类
import java.util.Scanner;
//引入栈类
import java.util.Stack;

public class Calc {
	//提示函数
    static void alert(String message) {
        System.out.println(message);
    }
    
    //比较优先级
    static boolean compare(char op1,char op2) {
        String ops = "!&|(";
        return ops.indexOf(op1) <= ops.indexOf(op2);
    }
    
    //计算函数
    static void calc(char op,Stack<Boolean> stack_num) {
        if(op == '&' || op == '|') {
            if(stack_num.size() < 2) {
                alert("nums exception");
            } else{
                boolean num1,num2;
                num1 = stack_num.pop();
                num2 = stack_num.pop();
                if(op == '&') {
                    stack_num.push(num1 && num2);
                } else{
                    stack_num.push(num1 || num2);
                }
            }
        }
        else if(op == '!') {
            if(stack_num.size() < 1) {
                alert("无运算数！");
            }
            else {
                stack_num.push(!stack_num.pop());
            }
        }
    }
    static boolean valid(String input) {
    	//运算数栈
        Stack<Boolean> stack_num = new Stack<Boolean>();
        //运算符栈
        Stack<Character> stack_op = new Stack<Character>();
        //获取表达式长度
        int len = input.length();
        for(int i = 0;i < len;i++) {
        	//根据索引号获得表达式中相应位置的字符
            char c = input.charAt(i);
            switch(c) {
                case 'T':
                	//压栈
                    stack_num.push(true);
                break;
                case 'F':
                	//压栈
                    stack_num.push(false);
                break;
                case ')':
                	//遇到右括号，弹栈
                    assert(stack_op.isEmpty() == false);
                    char preop = stack_op.pop();
                    while(preop != '(') {
                        calc(preop,stack_num);
                        assert(stack_op.isEmpty() == false);
                        preop = stack_op.pop();
                    }
                break;
                case '(':
                    stack_op.push('(');
                break;
                case '&':
                case '|':
                case '!':
                    if(stack_op.isEmpty()) {
                        stack_op.push(c);
                        break;
                    }
                    preop = stack_op.pop();
                    if(compare(c,preop)) {
                        stack_op.push(preop);
                        stack_op.push(c);
                    } else {
                        calc(preop,stack_num);
                        stack_op.push(c);
                    }
                break;
                default:
                    alert("非法字符！");
                break;
            }
        }
        //运算符栈非空
        while(!stack_op.isEmpty()) {
            char preop = stack_op.pop();
            calc(preop,stack_num);
        }
        return stack_num.pop();
    }
    //测试代码（输入）
    public static void main(String[] args) {
    	//scan未关闭，可以持续输入
        System.out.println("输入要计算的式子：");
        Scanner scan = new Scanner(System.in);
        while(true) {
            String input = scan.next();
            if(valid(input)) {
                alert("V");
            } else{
                alert("F");
            }
        }
    }
}
