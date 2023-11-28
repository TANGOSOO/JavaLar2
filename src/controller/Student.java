package controller;

public class Student {

	private String name;
	private int registration;
	
	public Student(String name, int registration) {
		this.name=name;
		this.registration=registration;
	}

	public String getName() {
		return name;
	}

	public int getRegistration() {
		return registration;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRegistration(int registration) {
		this.registration = registration;
	}
	
    public boolean equals(Object Object) {
    	Student student=(Student) Object;
    	if(this.name.equals(student.getName()) && this.registration==student.getRegistration()) { 
    		return true; 
        }else {
        	return false; 
    	}
    } 
}
