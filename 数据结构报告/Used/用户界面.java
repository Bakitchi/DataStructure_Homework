package ������;

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

public class �û����� extends JFrame {

	private JPanel contentPane;
	private ��ɢ�� h;

	private String replace(String value) {// ��������ʵ����ֵ���溬�����ı��ʽ
		for (int j = 0; j < 26; j++) {
			for (h.HList[j].setFirst(); h.HList[j].isInList(); h.HList[j].next()) {
				value = value.replace((String) h.HList[j].currValue(), (String) h.HList[j].currcontent());
			}
		}
		return value;
	}

	public void ���Ͳ���(String s, JTextArea text) {
		String[] linecontent = s.split("\n");
		for (int i = 0; i < linecontent.length; i++) {
			String[] spacecontent = linecontent[i].split(" ");
			if (spacecontent[0].equals("ASSIGN")) {
				if (h.find(spacecontent[1]) == null) {
					���ʽ���� c = new ���ʽ����();
					String value = spacecontent[2];
					value = replace(value);
					value = c.Evaluate(value + "=");
					Link l = h.add(spacecontent[1]);// ������������ɢ����
					l.setcontent(value);// ���ñ���ֵ
					text.append("assigning " + value + " to " + spacecontent[1] + "\n");
				} else {
					Link l = h.find(spacecontent[1]);
					���ʽ���� c = new ���ʽ����();
					String value = spacecontent[2];
					value = replace(value);
					value = c.Evaluate(value + "=");
					l.setcontent(value);// ��������ָ��Ĵ洢ֵ�ı�
					text.append("assigning " + value + " to " + spacecontent[1] + "\n");
				}
			} else if (spacecontent[0].equals("DEFINE")) {
				text.append("Defining " + spacecontent[1] + "\n");
				Link l = h.add(spacecontent[1]);// �����������ϣ����
				i = i + 1;// ת����һ�п�ʼ��ȡ������
				// �����屣�浽��ϣ��
				spacecontent = linecontent[i].split(" ");
				String ���� = "";
				while (!(spacecontent[0].equals("END"))) {
					���� = ���� + linecontent[i] + "\n";
					i++;
					spacecontent = linecontent[i].split(" ");
				}
				l.setcontent(����);// ���溯����
			} else if (spacecontent[0].equals("CALL")) {
				text.append("Calling " + spacecontent[1] + "\n");
				���Ͳ���((String) (h.find(spacecontent[1]).content()), text);
			} else if (spacecontent[0].equals("FOR")) {
				���ʽ���� c = new ���ʽ����();
				String a = spacecontent[1];
				a = replace(a);
				a = c.Evaluate(a + "=");
				int count = Integer.parseInt(a);// ѭ������
				for (int i1 = 0; i1 < count; i1++) {
					if (spacecontent[2].equals("ASSIGN")) {
						if (h.find(spacecontent[3]) == null) {
							���ʽ���� c1 = new ���ʽ����();
							String value = spacecontent[4];
							value = replace(value);
							value = c1.Evaluate(value + "=");
							Link l = h.add(spacecontent[3]);
							l.setcontent(value);
							if(i1==count-1)
							text.append("assigning " + value + " to " + spacecontent[3] + "\n");
						} else {
							Link l = h.find(spacecontent[3]);
							���ʽ���� c1 = new ���ʽ����();
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
						���Ͳ���((String) (h.find(spacecontent[3]).content()), text);
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
					�û����� frame = new �û�����();
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
	public �û�����() {
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
		btnNewButton.setFont(new Font("����", Font.PLAIN, 13));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea_1.setText("");
				h = new ��ɢ��();// ��ʼ����ϣ��
				���Ͳ���(textArea.getText(), textArea_1);// ��ʼ�������
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
