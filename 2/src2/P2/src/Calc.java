//Calc.java ����������
//����������
import java.util.Scanner;
//����ջ��
import java.util.Stack;

public class Calc {
	//��ʾ����
    static void alert(String message) {
        System.out.println(message);
    }
    
    //�Ƚ����ȼ�
    static boolean compare(char op1,char op2) {
        String ops = "!&|(";
        return ops.indexOf(op1) <= ops.indexOf(op2);
    }
    
    //���㺯��
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
                alert("����������");
            }
            else {
                stack_num.push(!stack_num.pop());
            }
        }
    }
    static boolean valid(String input) {
    	//������ջ
        Stack<Boolean> stack_num = new Stack<Boolean>();
        //�����ջ
        Stack<Character> stack_op = new Stack<Character>();
        //��ȡ���ʽ����
        int len = input.length();
        for(int i = 0;i < len;i++) {
        	//���������Ż�ñ��ʽ����Ӧλ�õ��ַ�
            char c = input.charAt(i);
            switch(c) {
                case 'T':
                	//ѹջ
                    stack_num.push(true);
                break;
                case 'F':
                	//ѹջ
                    stack_num.push(false);
                break;
                case ')':
                	//���������ţ���ջ
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
                    alert("�Ƿ��ַ���");
                break;
            }
        }
        //�����ջ�ǿ�
        while(!stack_op.isEmpty()) {
            char preop = stack_op.pop();
            calc(preop,stack_num);
        }
        return stack_num.pop();
    }
    //���Դ��루���룩
    public static void main(String[] args) {
    	//scanδ�رգ����Գ�������
        System.out.println("����Ҫ�����ʽ�ӣ�");
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
