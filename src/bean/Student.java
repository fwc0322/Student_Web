package bean;

public class Student {
	private String name;
	private String sex;
	private String specialty;
	private String grade;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//¹¹Ôìº¯Êý
	public Student(String name, String sex, String specialty, String grade, int id) {
		super();
		this.name = name;
		this.sex = sex;
		this.specialty = specialty;
		this.grade = grade;
		this.id = id;
	}
	public Student(String name, String sex, String specialty, String grade) {
		super();
		this.name = name;
		this.sex = sex;
		this.specialty = specialty;
		this.grade = grade;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	


}
	