package hospital_pro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public abstract class Person {
	
	private String fName,lName;
	private String address;
	private String gender;
	private String phone;
	private String email;
	private String password;
	private int age;
	protected int id;
	Scanner scan = new Scanner(System.in);
	// Begin Setters Name
	public void set_first_name(String fName) {
		if(fName.length()>=3 && fName.length()<=12) {
			for(int i = 0; i<fName.length(); i++)
			{
				if( (fName.charAt(i) >= 'a' && fName.charAt(i) <= 'z') || (fName.charAt(i) >= 'A' && fName.charAt(i) <= 'Z') )
					this.fName = fName;
				else {
					System.out.println("Your first Name should be Only Letters!");
					set_first_name(scan.next());
				}
			}
		}else {
			System.out.println("Sorry! The first Name should be at least 3 Letters or more");
			set_first_name(scan.next());
		}
	}
	public void set_last_name(String lName) {
		if(lName.length()>=3 && lName.length()<= 15) {
			for(int i = 0; i<lName.length(); i++)
			{
				if( (lName.charAt(i) >= 'a' && lName.charAt(i) <= 'z') || (lName.charAt(i) >= 'A' && lName.charAt(i) <= 'Z') )
					this.lName = lName;
				else {
					System.out.println("Your first Name should be Only Letters!");
					set_last_name(scan.next());
				}
			}
		}else {
			System.out.println("Sorry! The Last Name should be at least 3 Letters or more");
			set_last_name(scan.next());
		}
	}
	// End Setters Name
	////////////////////////////////////////
	// Begin Getters Name
	public String get_first_name() {
		return this.fName;
	}
	public String get_last_name() {
		return this.lName;
	}
	// End Getters Name
	/////////////////////////////////////////
	// Begin Setters Age
	public void set_age(int age) {
		this.age = age;
		try { // NoneSense
			if(age < 0) {
				System.out.println("SO.. Please Enter Correct Age.");
				this.set_age(scan.nextInt()); //Recursion
			}else {
				while(this.age == 0) {
				boolean yep;
				System.out.println("Does He / SHE has just been borned now? [true,false]");
				yep = scan.nextBoolean();
				if(yep)
					break;
				else {
					System.out.println("SO.. Please Enter Correct Age.");
					this.set_age(scan.nextInt()); //Recursion
				}
			}
		}
		}catch(Exception e) {
			System.out.println("Please Enter Integer only");
			set_age(scan.nextInt());
		}
	}
	// End Setters Age
	///////////////////////////////////////////
	// Begin Getters Age
	public int get_age() {
		return this.age;
	}
	// End Getters Age
	/////////////////////////////////////////////
	// Begin Setters Phone
	public void set_phone(String phone) {
		if(phone.length() == 11) {
			this.phone = phone;
			System.out.println("\t***Your number is validate, Saved!***");
		}else {
			System.out.println("The Phone Number has to include 11 numbers!");
			this.set_phone(scan.next());
		}
		this.phone = phone;
	}
	// End Setters Phone
	//////////////////////////////////////////////
	// Begin Getters Phone
	public String get_phone() {
		return this.phone;
	}
	// End Getters Phone
	////////////////////////////////////////////////
	// Begin Setters Address
	public void set_address(String Adrss) {
		this.address = Adrss;
	}
	// End Setters Address
	////////////////////////////////////////////////
	// Begin Getters Address
	public String get_address() {
		return this.address;
	}
	// End Getters Address
	////////////////////////////////////////////////
	// Begin Setetrs Gender
	public void set_gender(String gender) {
		if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("m") ) {
			this.gender = "male";
		}else if(gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("f") ) {
			this.gender = "female";
		}else
			System.out.println("please Enter [Male(m) OR Female(f)]");
	}
	// End Setters Gender
	// Begin Getters Gender
	public String get_gender() {
		return this.gender;
	}
	// End Getters Gender
	/////////////////////////////////////////////////
	// Begin Setters email
	public void set_email(String email) {
		this.email = email;
	}
	// End setters email
	// Begin getters email
	public String get_email() {
		return this.email;
	}
	// End getters email
	/////////////////////////////////////////////////
	// Begin Setters password
	public void set_password(String password) {
	this.password = password;
	}
	// End setters password
	// Begin getters password
	public String get_password() {
	return this.password;
	}
	// End getters password
	
	//Useful Methods
	// Search using name
	/*
	 * void searchFName(char name,AssistantTeaching[] emps); void searchFName(char
	 * name, Doctor[] emps); void searchFName(char name, Student[] emps); void
	 * searchFName(char name, Techinician[] emps);
	 */
	abstract public String toString();
	
	// Methods for File handeling 
	abstract public void out(int i);//print in file
		
	//public void outEdit(int i, ArrayList<Student> stu); //print the modifications in the file
	
	abstract public void del(int i); // delete the report file
	
	abstract public void in(int i);
}

