package 解释器;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class 用户界面 extends JFrame {

	private JPanel contentPane;
	private 开散列 h;

	private String replace(String value) {// 将变量的实际数值代替含变量的表达式
		for (int j = 0; j < 26; j++) {
			for (h.HList[j].setFirst(); h.HList[j].isInList(); h.HList[j].next()) {
				value = value.replace((String) h.HList[j].currValue(), (String) h.HList[j].currcontent());
			}
		}
		return value;
	}

	public void 解释操作(String s, JTextArea text) {
		String[] linecontent = s.split("\n");
		for (int i = 0; i < linecontent.length; i++) {
			String[] spacecontent = linecontent[i].split(" ");
			if (spacecontent[0].equals("ASSIGN")) {
				if (h.find(spacecontent[1]) == null) {
					表达式计算 c = new 表达式计算();
					String value = spacecontent[2];
					value = replace(value);
					value = c.Evaluate(value + "=");
					Link l = h.add(spacecontent[1]);// 将变量名存入散列中
					l.setcontent(value);// 设置变量值
					text.append("assigning " + value + " to " + spacecontent[1] + "\n");
				} else {
					Link l = h.find(spacecontent[1]);
					表达式计算 c = new 表达式计算();
					String value = spacecontent[2];
					value = replace(value);
					value = c.Evaluate(value + "=");
					l.setcontent(value);// 将变量名指向的存储值改变
					text.append("assigning " + value + " to " + spacecontent[1] + "\n");
				}
			} else if (spacecontent[0].equals("DEFINE")) {
				text.append("Defining " + spacecontent[1] + "\n");
				Link l = h.add(spacecontent[1]);// 函数名存入哈希表中
				i = i + 1;// 转到下一行开始读取函数体
				// 函数体保存到哈希表
				spacecontent = linecontent[i].split(" ");
				String 函数 = "";
				while (!(spacecontent[0].equals("END"))) {
					函数 = 函数 + linecontent[i] + "\n";
					i++;
					spacecontent = linecontent[i].split(" ");
				}
				l.setcontent(函数);// 保存函数体
			} else if (spacecontent[0].equals("CALL")) {
				text.append("Calling " + spacecontent[1] + "\n");
				解释操作((String) (h.find(spacecontent[1]).content()), text);
			} else if (spacecontent[0].equals("FOR")) {
				表达式计算 c = new 表达式计算();
				String a = spacecontent[1];
				a = replace(a);
				a = c.Evaluate(a + "=");
				int count = Integer.parseInt(a);// 循环次数
				for (int i1 = 0; i1 < count; i1++) {
					if (spacecontent[2].equals("ASSIGN")) {
						if (h.find(spacecontent[3]) == null) {
							表达式计算 c1 = new 表达式计算();
							String value = spacecontent[4];
							value = replace(value);
							value = c1.Evaluate(value + "=");
							Link l = h.add(spacecontent[3]);
							l.setcontent(value);
							if(i1==count-1)
							text.append("assigning " + value + " to " + spacecontent[3] + "\n");
						} else {
							Link l = h.find(spacecontent[3]);
							表达式计算 c1 = new 表达式计算();
							String value = spacecontent[4];
							value = replace(value);
							value = c1.Evaluate(value + "=");
							l.setcontent(value);
							System.out.println(value);
							if(i1==count-1)
							text.append("assigning " + value + " to " + spacecontent[3] + "\n");
						}
					} else if (spacecontent[2].equals("CALL")) {
						text.append("Calling " + spacecontent[3] + "\n");
						解释操作((String) (h.find(spacecontent[3]).content()), text);
					}
				}

			}

		}

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					用户界面 frame = new 用户界面();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public 用户界面() {
		setTitle("\u5FAE\u578B\u89E3\u91CA\u5668");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 996, 748);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(0, 30, 410, 671);
		contentPane.add(textArea);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea_1.setBounds(503, 30, 380, 671);
		contentPane.add(textArea_1);

		JButton btnNewButton = new JButton("\u5F00\u59CB\u89E3\u91CA");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 13));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea_1.setText("");
				h = new 开散列();// 初始化哈希表
				解释操作(textArea.getText(), textArea_1);// 开始代码解释
			}
		});
		btnNewButton.setBounds(880, 13, 98, 42);
		contentPane.add(btnNewButton);

		JLabel label = new JLabel("\u539F\u7A0B\u5E8F");
		label.setBounds(0, 12, 335, 18);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u89E3\u91CA\u7A0B\u5E8F");
		label_1.setBounds(514, 6, 335, 18);
		contentPane.add(label_1);
	}
}
