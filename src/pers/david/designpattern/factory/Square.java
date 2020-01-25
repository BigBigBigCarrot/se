package pers.david.designpattern.factory;

public class Square implements Shape {

	public Square() {
	}

	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");		
	}

}
