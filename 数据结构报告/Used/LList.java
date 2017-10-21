package ������;


class LList implements List{
	private Link head;//Pointer to list header
	private Link tail;//Pointer to last Object in list
	protected Link curr;//Pointer to current Object
	LList(int sz){setup();}
	LList(){setup();}
	private void setup() {
		// TODO �Զ����ɵķ������
		tail=head=curr=new Link(null);
	}
	
	@Override
	public void clear() {
		// TODO �Զ����ɵķ������
		head.setNext(null);
	}

	@Override
	public void insert(Object it) {
		// TODO �Զ����ɵķ������
		assert curr!=null:"No curr element";
		curr.setNext(new Link(it,curr.next()));
		if(tail == curr)
			tail = curr.next();
	}

	@Override
	public void append(Object it) {
		// TODO �Զ����ɵķ������
		tail.setNext(new Link(it,null));
		tail = tail.next();
	}

	@Override
	public Object remove() {
		// TODO �Զ����ɵķ������
		if(!isInList())return null;
		Object it = curr.next().element();
		if(tail == curr.next())tail = curr;
		curr.setNext(curr.next().next());
		return it;
	}

	@Override
	public void setFirst() {
		// TODO �Զ����ɵķ������
		curr=head;
	}

	@Override
	public void next() {
		// TODO �Զ����ɵķ������
		if(curr!=null)curr = curr.next();
	}

	@Override
	public void prev() {
		// TODO �Զ����ɵķ������
		if((curr == null)||(curr == head))
		{curr = null;return;}
		Link temp = head;
		while((temp!=null)&&(temp.next()!=curr))
			temp = temp.next();
		curr = temp;
	}

	@Override
	public int length() {
		// TODO �Զ����ɵķ������
		int cnt=0;
		for(Link temp=head.next();temp!=null;temp=temp.next())
			cnt++;
		return cnt;
	}

	@Override
	public void setPos(int pos) {
		// TODO �Զ����ɵķ������
		curr = head;
		for(int i=0;(curr!=null)&&(i<pos);i++)
			curr = curr.next();
	}

	@Override
	public void setValue(Object it) {
		// TODO �Զ����ɵķ������
		assert isInList();
		curr.next().setElement(it);
	}

	@Override
	public Object currValue() {
		// TODO �Զ����ɵķ������
		if(!isInList())return null;
		return curr.next().element();
	}

	@Override
	public boolean isEmpty() {
		// TODO �Զ����ɵķ������
		return head.next() == null;
	}

	@Override
	public boolean isInList() {
		// TODO �Զ����ɵķ������
		return (curr!=null)&&(curr.next()!=null);
	}

	@Override
	public void print() {
		// TODO �Զ����ɵķ������
		if(isEmpty())System.out.println("()");
		else{
			System.out.print("(");
			for(setFirst();isInList();next())
				System.out.print(currValue() + " ");
			System.out.println(")");
		}
	}

	@Override
	public void setcontent(Object it) {
		// TODO �Զ����ɵķ������
		assert isInList();
		curr.next().setcontent(it);
	}

	@Override
	public Object currcontent() {
		// TODO �Զ����ɵķ������
		if(!isInList())return null;
		return curr.next().content();
	}
	
}
