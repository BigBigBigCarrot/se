package pers.david.designpattern.proxy;

import java.text.MessageFormat;

public class ActionObject implements Action {


	@Override
	public Object doSomething(String arg) {
		String messagePatter="do something ,arg:{0}";
		System.out.println(MessageFormat.format(messagePatter, arg));
		return "successful";
	}
}