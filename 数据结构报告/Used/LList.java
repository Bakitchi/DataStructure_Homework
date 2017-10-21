package 解释器;


class LList implements List{
	private Link head;//Pointer to list header
	private Link tail;//Pointer to last Object in list
	protected Link curr;//Pointer to current Object
	LList(int sz){setup();}
	LList(){setup();}
	private void setup() {
		// TODO 自动生成的方法存根
		tail=head=curr=new Link(null);
	}
	
	@Override
	public void clear() {
		// TODO 自动生成的方法存根
		head.setNext(null);
	}

	@Override
	public void insert(Object it) {
		// TODO 自动生成的方法存根
		assert curr!=null:"No curr element";
		curr.setNext(new Link(it,curr.next()));
		if(tail == curr)
			tail = curr.next();
	}

	@Override
	public void append(Object it) {
		// TODO 自动生成的方法存根
		tail.setNext(new Link(it,null));
		tail = tail.next();
	}

	@Override
	public Object remove() {
		// TODO 自动生成的方法存根
		if(!isInList())return null;
		Object it = curr.next().element();
		if(tail == curr.next())tail = curr;
		curr.setNext(curr.next().next());
		return it;
	}

	@Override
	public void setFirst() {
		// TODO 自动生成的方法存根
		curr=head;
	}

	@Override
	public void next() {
		// TODO 自动生成的方法存根
		if(curr!=null)curr = curr.next();
	}

	@Override
	public void prev() {
		// TODO 自动生成的方法存根
		if((curr == null)||(curr == head))
		{curr = null;return;}
		Link temp = head;
		while((temp!=null)&&(temp.next()!=curr))
			temp = temp.next();
		curr = temp;
	}

	@Override
	public int length() {
		// TODO 自动生成的方法存根
		int cnt=0;
		for(Link temp=head.next();temp!=null;temp=temp.next())
			cnt++;
		return cnt;
	}

	@Override
	public void setPos(int pos) {
		// TODO 自动生成的方法存根
		curr = head;
		for(int i=0;(curr!=null)&&(i<pos);i++)
			curr = curr.next();
	}

	@Override
	public void setValue(Object it) {
		// TODO 自动生成的方法存根
		assert isInList();
		curr.next().setElement(it);
	}

	@Override
	public Object currValue() {
		// TODO 自动生成的方法存根
		if(!isInList())return null;
		return curr.next().element();
	}

	@Override
	public boolean isEmpty() {
		// TODO 自动生成的方法存根
		return head.next() == null;
	}

	@Override
	public boolean isInList() {
		// TODO 自动生成的方法存根
		return (curr!=null)&&(curr.next()!=null);
	}

	@Override
	public void print() {
		// TODO 自动生成的方法存根
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
		// TODO 自动生成的方法存根
		assert isInList();
		curr.next().setcontent(it);
	}

	@Override
	public Object currcontent() {
		// TODO 自动生成的方法存根
		if(!isInList())return null;
		return curr.next().content();
	}
	
}
