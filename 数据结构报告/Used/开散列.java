package 解释器;

public class 开散列 {
	public LList[] HList;

	public 开散列() {
		HList = new LList[26];
		for (int i = 0; i < 26; i++) {
			HList[i] = new LList();
		}
	}

	boolean check(String it) {
		if (it.length() > 8) {// 不超过8个字符
			return false;
		}
		for (int i = 0; i < it.length(); i++) {
			if (it.charAt(i) < 65 || (it.charAt(i) > 90 && it.charAt(i) < 97) || it.charAt(i) > 122) {// 仅包含英文字母大小写
				return false;
			}
		}
		return true;
	}

	public Link find(String it) {// 寻找变量及函数体
		int a = it.charAt(0);
		if ((a - 65) < 26 && (a - 65) >= 0) {
			for (HList[a - 65].setFirst(); HList[a - 65].isInList(); HList[a - 65].next()) {
				if ((HList[a - 65].currValue() != null) && (HList[a - 65].currValue().equals(it)))
					return HList[a - 65].curr.next();
			}
		} else if ((a - 97) < 26 && (a - 97) >= 0) {
			for (HList[a - 97].setFirst(); HList[a - 97].isInList(); HList[a - 97].next()) {
				if ((HList[a - 97].currValue() != null) && (HList[a - 97].currValue().equals(it)))
					return HList[a - 97].curr.next();
			}
		}
		return null;
	}

	public Link add(String it) {
		if (!check(it)) {
			System.out.println("格式错误,请输入8位字母以内的变量名");
			return null;
		}
		int a = it.charAt(0);
		if ((a - 65) < 26 && (a - 65) >= 0) {
			HList[a - 65].append(it);
			for (HList[a - 65].setFirst(); HList[a - 65].isInList(); HList[a - 65].next())
				;
			return HList[a - 65].curr;
		} else {
			HList[a - 97].append(it);
			for (HList[a - 97].setFirst(); HList[a - 97].isInList(); HList[a - 97].next())
				;
			return HList[a - 97].curr;
		}

	}

	public void print() {
		for (int i = 0; i < 26; i++) {
			HList[i].print();
		}
	}
}
