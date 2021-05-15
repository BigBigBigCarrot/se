package pers.david.se.annotation;

import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class UseCaseTracker {

	public UseCaseTracker() {
	}

	public static void main(String[] args) {
		List<Integer> idList=new ArrayList<Integer>();
		trackUseCases(idList,PasswordUtils.class);
	}
	
	/**
	 * @param useCaseId
	 * @param cl
	 */
	public static void trackUseCases(List<Integer> useCaseId,Class<?> cl){
		for(Method method:cl.getDeclaredMethods()){
			UseCase useCase=method.getAnnotation(UseCase.class);
			if(useCase!=null){
				String str="id:{0},descrption:{1}";
				str=MessageFormat.format(str, useCase.id(),useCase.description());
				System.out.println(str);
			}
		}
	}

}
