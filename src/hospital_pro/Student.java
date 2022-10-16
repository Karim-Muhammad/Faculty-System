package hospital_pro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Student extends Person implements Display{
	//properties
	private int level;
	private int group;
	private int section;
	private double GPA;
	private String department_stu;
	//private String[] subjects = new String[8]; // not now
	//private int[] marksSubj = new int[8];	// not now
	
	//methods
	//setter level
	public void set_level(int lvl) {
		if(lvl == 1 || lvl == 2  || lvl == 3 || lvl == 4 ) //|| lvl == "one" || lvl == "two"  || lvl == "Three" || lvl =="Four" || lvl == "first" || lvl == "second"  || lvl == "Third" || lvl =="Fourth"  
			this.level = lvl;
		else {
			System.out.println("The level [1:4]");
			set_level(scan.nextInt());
		}
	}
	//getter level
	public int get_level() {
		return this.level;
	}
	//setter group
	public void set_group_stu(int g) {
		if(g>=1 && g<=10)
			this.group = g;
		else {
			System.out.println("The Groups from 1 to 10");
			set_group_stu(scan.nextInt());
		}
	}
	//getter group
	public int get_group() {
		return this.group;
	}
	//setter section
	public void set_section_stu(int s) {
		if(s>=1 && s<=10)
			this.section = s;
		else {
			System.out.println("The sections from 1 to 10");
			set_section_stu(scan.nextInt());
		}
	}
	//getter section
	public int get_section() {
		return this.section;
	}
	//setter department
	public void set_dep_stu(String dep) {
		if(dep.equalsIgnoreCase("general")) {
			this.department_stu = dep;
		}
		else if(dep.length() == 2) {//Using varius way to ignore case Characters
			if( (dep.equalsIgnoreCase("iS"))|| (Character.toLowerCase(dep.charAt(0)) == 'c' && Character.toLowerCase(dep.charAt(1)) == 's') || ( (dep.charAt(0) == 'm'||dep.charAt(0) == 'M') && (dep.charAt(1) == 'm'||dep.charAt(1) == 'M') )|| (Character.toUpperCase(dep.charAt(0)) == 'I' && Character.toUpperCase(dep.charAt(1)) == 'T')) 
					this.department_stu = dep;
			else {
					System.out.println("Not Found This Department! [IT,IS,CS,MM]");
					set_dep_stu(scan.next());
			}
		}
		else {
			System.out.println("The Department need To 2 Letters only!");
			set_dep_stu(scan.next());
		}
	}
	// GPA
	public void set_GPA(double gpa) {
		if(gpa >= 1.0 && gpa <= 5.0) {
			this.GPA = gpa;
		}else {
			System.out.println("The Range of Gpa [1,5]");
			set_GPA(scan.nextDouble());
		}
	}
	public double get_GPA() {
		return this.GPA;
	}
	
	
	
	
	
	//useful common methods
	public String toString() {
		if(this.get_gender().equalsIgnoreCase("male") || this.get_gender().equalsIgnoreCase("m") ) {
			return "ID: "+this.id+"\t|first Name: "+this.get_first_name()+"\t|"
					+"Last Name: "+this.get_last_name()+"\t|Specialization: "+String.valueOf(this.department_stu)+"\t|GPA: "+String.valueOf(this.GPA)+"\t|The Sections he is in: "+this.section+"\t|The group is which he in: "+this.group;	
		}else if(this.get_gender().equalsIgnoreCase("female") || this.get_gender().equalsIgnoreCase("f")) {
			return  "ID: "+this.id+"\t|first Name: "+this.get_first_name()+"\t|"
					+"Last Name: "+this.get_last_name()+"\t|Specialization: "+String.valueOf(this.department_stu)+"\t|GPA: "+String.valueOf(this.GPA)+"\t|The Sections she is in: "+this.section+"\t|The group is which she in: "+this.group;
		}else
			return "Notice this student unknown its gender\n"+"ID: "+this.id+"\t|first Name: "+this.get_first_name()+"\t|"
			+"Last Name: "+this.get_last_name()+"\t|Specialization: "+String.valueOf(this.department_stu)+"\t|The Sections he is in: "+this.section+"\t|The group is which he in: "+this.group;
	}

	public void SetInfo_stu(int query, int maxSizeStu,ArrayList<Student> stus) {
		if(query == 1) {
			setInfoStu_qu1(maxSizeStu,stus); // Insert
			out(this.id); // store the info in the file
		}
		else if(query == 2) {
			setInfoStu_qu2(stus); // Modify
			System.out.println("Do you want to see the modifactions for one of the studens?: (Only if you modify info for someone) [True, False] only");
			if(scan.nextBoolean()) {
				System.out.println("Enter ID: ");
				int id = scan.nextInt();
				stus.get(id-1).in(id);
				System.out.println("\t\t~~~ The Data Now ~~~");
			}
			//outEdit(this.id);
		}
		else if(query == 3) {
			setInfoStu_qu3(stus); // Remove
			del(this.id); // remove the file
		}
		else if(query == 4) { // Record marks
			System.out.println("The new feature have not implemented yet X( "); //setInfoStu_qu4
		}
		else {
			System.out.println("Please Enter Only from 1 to 4");
			SetInfo_stu(scan.nextInt(), maxSizeStu, stus);
		}
	}
	// login info
	public void setInfoStu_qu1(int maxSizeStu, ArrayList<Student> stus) {
//		stus[maxSizeStu-1] = new Student();
		stus.get(maxSizeStu-1).id = maxSizeStu;
		System.out.println("Please Enter Your First Name: ");
		stus.get(maxSizeStu-1).set_first_name(scan.next());
		System.out.println("Please Enter Your Last Name: ");
		stus.get(maxSizeStu-1).set_last_name(scan.next());
		System.out.println("Please Enter Your Age: ");
		stus.get(maxSizeStu-1).set_age(scan.nextInt()); 
		System.out.println("Please Enter Your Gender: ");
		stus.get(maxSizeStu-1).set_gender(scan.next());
		scan.nextLine();
		System.out.println("Please Enter Your address: ");
		stus.get(maxSizeStu-1).set_address(scan.nextLine());
		System.out.println("Please Enter Your Phone: ");
		stus.get(maxSizeStu-1).set_phone(scan.next());
		System.out.println("Please Enter Your Level: [1:4]");
		stus.get(maxSizeStu-1).set_level(scan.nextInt());
		if(stus.get(maxSizeStu-1).get_level() == 1 || stus.get(maxSizeStu-1).get_level() == 2 ) {
			stus.get(maxSizeStu-1).set_dep_stu("General");
		}else {
			System.out.println("Please Enter Your Department: "); //need validate
			stus.get(maxSizeStu-1).set_dep_stu(scan.next());
		}
		System.out.println("Please Enter Your Group: ");
		stus.get(maxSizeStu-1).set_group_stu(scan.nextInt());
		System.out.println("Please Enter Your Section: ");
		stus.get(maxSizeStu-1).set_section_stu(scan.nextInt());
		System.out.println("Enter Your GPA: (The Double Value not work in my program)");
		double n = scan.nextDouble();
		stus.get(maxSizeStu-1).set_GPA(n);
		//System.out.println("If you need print all info for student["+maxSizeStu+"] (true,false)");
		//if(scan.nextBoolean()) {
		//	System.out.println(stus[maxSizeStu-1].toString());
		//}else {
		//	System.out.println("Well! The info Succeccfuly Stored");
		//}
}
	//Modify Info
	public void setInfoStu_qu2(ArrayList<Student> stus) {
		for(int i = 0 ; i<stus.size(); i++) {
			System.out.println(stus.get(i).toString());
		}
		set_check_ID_Search(stus); // Call Function below
	}
	//delete info student
	public void setInfoStu_qu3(ArrayList<Student> stus) {
		System.out.println("Enter ID You want Delete: ");
		int id = scan.nextInt();
		if(id >= 1 && id <= stus.size()) {
			stus.remove(id-1);
		}else {
			System.out.println("Please Enter ID Available from 1 to "+stus.size());
			del_check_ID_Search(stus,scan.nextInt()); // Call Function below
		}
		System.out.println("Has Removed!");
//		System.out.println(stus.toString());
	}
	void set_check_ID_Search(ArrayList<Student> stus) {
		System.out.println("Enter ID Student : ");
		int id = scan.nextInt();
		if(id >= 1 && id<=stus.size()) {
			stus.get(id-1).setInfoStu_qu1(id, stus); // Call function above
			outEdit(id, stus);
		}
		else {
			System.out.println("Please Enter From 1 to "+stus.size());
			set_check_ID_Search(stus); // Recursion
		}
	}
	void del_check_ID_Search(ArrayList<Student> stus, int ID) {
		if(ID >= 1 && ID <= stus.size()) {
			stus.remove(ID-1);
		}else {
			System.out.println("Please Enter ID Available from 1 to "+stus.size());
			del_check_ID_Search(stus,scan.nextInt()); // Recursion
		}
	}
	@Override
	public void display_all_details() {
//		System.out.println(super.toString());
        System.out.println(toString());
	}
	//Override Methods Here
	@Override
	public void out(int i) { // print info in file
		try {
			FileWriter output = new FileWriter("reports/StudentsReport/student"+i);
			output.write(this.toString());
			System.out.println("Inserted Successfuly");
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void outEdit(int i, ArrayList<Student> stu) { //print the modifications in the file
		try {
			FileWriter output = new FileWriter("reports/StudentsReport/student"+i, true);
			output.write("\n\t\t~~The past hisroty~~\n"+stu.get(i-1).toString());
			System.out.println("Inserted Successfuly");
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void del(int i) { //delete the file report
		File delFile = new File("reports/StudentsReport/student"+i);
		if(delFile.delete()) {
			System.out.println("The Record has removed");
		}else
			System.out.println("The delete of file has failed...");
	}
	public void in(int i) { // Reading from File
		int ch;
		try { 
			FileReader input = new FileReader("reports/StudentsReport/student"+i);
			while( (ch = input.read()) != -1) {
				System.out.print((char)ch);
			}
			System.out.println();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("The Reading from file failed");
		}
	}
}




// I can store my Quesitons inside array too