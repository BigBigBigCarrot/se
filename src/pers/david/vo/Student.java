package pers.david.vo;

public class Student implements Cloneable
{
	public String id;
	public  Student(String id)
	{
		this.id=id;
	}
	
	public boolean equals(Object obj)
	{
		Student stu=(Student)obj;
		if(id.equals(stu.id)==true)
		{
			return true;
		}
		return false;
	}
	public Object clone()
	{
		Object object;
		object=null;
		try
		{
			object=super.clone();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
		return object;
	}
}
