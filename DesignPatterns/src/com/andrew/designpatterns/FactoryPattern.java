package com.andrew.designpatterns;

public class FactoryPattern 
{
	public static void main(String[] args)
	{
		Shape myShape = ShapeFactory.getShape("Circle");
		Shape myShape1 = ShapeFactory.getShape("Triangle");
		myShape.draw();
		myShape1.draw();
	}
}

class ShapeFactory
{
	public static Shape getShape(String type)
	{
		if(type.equalsIgnoreCase("CIRCLE"))
		{
			return new Circle();
		}
		else if(type.equalsIgnoreCase("RECTANGLE"))
		{
			return new Rectangle();
		}
		else if(type.equalsIgnoreCase("TRIANGLE"))
		{
			return new Triangle();
		}
		
		else return null;
	}
}

interface Shape
{
	void draw();
}

class Rectangle implements Shape
{
	@Override
	public void draw() {
		System.out.println("Drawing RECTANGLE");
	}
}

class Circle implements Shape
{
	@Override
	public void draw() {
		System.out.println("Drawing CIRCLE");
	}	
}

class Triangle implements Shape
{
	@Override
	public void draw()
	{
		System.out.println("Drawing TRIANGLE");
	}
}