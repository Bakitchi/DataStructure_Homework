package ������;
public class Link {
	private Object element;// Object for this node
	private Object content;
	private Link next;// Pointer to next node in list

	Link(Object it, Link nextval) {
		element = it;
		next = nextval;
	}

	Link(Link nextval) {
		next = nextval;
	}

	Link next() {
		return next;
	}

	Link setNext(Link nextval) {
		return next = nextval;
	}

	Object element() {
		return element;
	}

	Object setElement(Object it) {
		return element = it;
	}

	Object content() {//��������ֵ�ͺ������ݵĴ洢
		return content;
	}

	Object setcontent(Object it) {
		return content = it;
	}
}
