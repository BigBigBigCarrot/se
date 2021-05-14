package pers.david.se.str;

import java.util.regex.Pattern;

public class RegularExpressionDemo {

	public RegularExpressionDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// String content = "I am noob " + "from runoob.com.";
		// String pattern = ".*runoob.*";
		// boolean isMatch = Pattern.matches(pattern, content);
		// System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);

		String content;
		String pattern;
//		content = "啊a";
//		pattern = ".{2}";

//		content = "ab";
//		//pattern = "a|b{2}";
//		pattern = "[ab]{2}";

//		content = "abcab";
//		//content = "abcabc";
//		pattern = "[abc]{1,5}";

//		content = "abcab3423423ewf";
//		//content = "a3=";
//		pattern = "[[0-9][aA-zZ]]*";

//		content = "abc";
//		pattern = "abc";

//		content = "123";
//		pattern = "[0-9]{1,}[\\.]{0,1}[0-9]{0,}";
//		//pattern = "\\d*";

		content = "aAbB";
		pattern = "[aA-zZ]+";
		//pattern = "\\d*";
		
		boolean isMatch = Pattern.matches(pattern, content);
		System.out.println(isMatch);
	}
}
