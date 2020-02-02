package pers.david.debug;

public class Press {
	
	public static void main(String[] args) {
		Writer writer=new Writer();
		Editor editor=new Editor();
		String book=editor.getBook(writer);
		System.out.println(book);
	}

}
