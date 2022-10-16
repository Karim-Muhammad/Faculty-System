package hospital_pro;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AssistantTeaching extends Person implements Display{

	private String specialization;
	private int section;
	private int numsSections;
	private String Exp_ass;
	
	//constructors
		AssistantTeaching() {
			super.id++;
		}
		AssistantTeaching(String fname) {
			super.id++;
			super.set_first_name(fname);
		}
		AssistantTeaching(String fname, String lname) {
			super.id++;
			super.set_first_name(fname);
			super.set_last_name(lname);
		}
	// setter && Getters Specialization
	public void set_specialization(String dep) {
		if(dep.length() == 2) {
			if( (dep.equalsIgnoreCase("iS"))|| (Character.toLowerCase(dep.charAt(0)) == 'c' && Character.toLowerCase(dep.charAt(1)) == 's') || ( (dep.charAt(0) == 'm'||dep.charAt(0) == 'M') && (dep.charAt(1) == 'm'||dep.charAt(1) == 'M') )|| (Character.toUpperCase(dep.charAt(0)) == 'I' && Character.toUpperCase(dep.charAt(1)) == 'T')) 
					this.specialization = dep;
			else
				System.out.println("Not Found This Department!");
		}
		else {
				System.out.println("The Department need To 2 Letters only![IT,IS,CS,MM]");
				set_specialization(scan.next());
		}
	}
	public String get_specialization() {
		return this.specialization;
	}
	//setter section
	public void set_section(int s) {
		if(s>=1 && s<=10)
			this.section = s;
		else {
			System.out.println("This Section not found [1:10]");
			set_section(scan.nextInt());
		}
	}
	//getter section
	public int get_section() {
		return this.section;
	}

	//experience setter method
	public void set_exp_ass(String exp) {
		if(exp.equalsIgnoreCase("junior")|| exp.equalsIgnoreCase("senior") ||exp.equalsIgnoreCase("pro")|| exp.equalsIgnoreCase("expert"))
			this.Exp_ass = exp;
		else {
			System.out.println("Please Enter EXP [Junior,Senior,Pro,Expert]");
			set_exp_ass(scan.next());
		}
	}

	//experience getter method
	public String get_exp_ass() {
		return this.Exp_ass;
	}
	//useful common methods
	@Override
	public String toString() {
		if(this.get_gender().equalsIgnoreCase("male") || this.get_gender().equalsIgnoreCase("m") ) {
			return "ID: "+this.id+"\t|first Name: "+this.get_first_name()+"\t|"
					+"Last Name: "+this.get_last_name()+"\t|Specialization: "+String.valueOf(this.specialization)+"\t|EXP: "+this.Exp_ass+"\t|The Sections he manage: "+this.get_section();
		}else if(this.get_gender().equalsIgnoreCase("female") || this.get_gender().equalsIgnoreCase("f")) {
			return "ID: "+this.id+"\t|first Name: "+this.get_first_name()+"\t|"
					+"Last Name: "+this.get_last_name()+"\t|Specialization: "+String.valueOf(this.specialization)+"\t|EXP: "+this.Exp_ass+"\t|The Sections she manage: "+this.get_section();
		}
		else
			return "Notice The gender is Unknown\t" +"ID: "+this.id+"\t|first Name: "+this.get_first_name()+"\t|"
			+"Last Name: "+this.get_last_name()+"\t|Specialization: "+String.valueOf(this.specialization)+"\t|The Sections he manage: "+this.get_section();
	}
	public void equals(AssistantTeaching e) {
		this.set_first_name(e.get_first_name());
		this.set_last_name(e.get_last_name());
		this.set_age(e.get_age());
		this.set_phone(e.get_phone());
		this.set_address(e.get_address());
		this.set_gender(e.get_gender());
		this.set_email(e.get_email());
		this.set_password(e.get_password());
	}
	static void searchFName(char name,AssistantTeaching[] emps) {
		for(int i =0; i < emps.length ; i++) {
			if(emps[i].get_first_name().charAt(0) == name)
				System.out.println("ID: "+emps[i].id+"\t|first Name: "+emps[i].get_first_name()+"\t|"
						+"Last Name: "+emps[i].get_last_name()+"\t|Specialization: "+String.valueOf(emps[i].specialization));
		}
	}
	
	public void SetInfo_ass(int query, int maxSizeDoc, ArrayList<AssistantTeaching> assList) {
		if(query == 1) { // insert query
			setInfoStu_qu1(maxSizeDoc,assList);
			out(this.id);
		}
		else if(query == 2) { //modify query
			setInfoStu_qu2(assList);
			System.out.println("Do you want to see the modifactions for one of the AssistantTeaching?: (Only if you modify info for someone) [True, False] only");
			if(scan.nextBoolean()) {
				System.out.println("Enter ID: ");
				int id = scan.nextInt();
				assList.get(id-1).in(id);
				System.out.println("\t\t~~~ The Data Now ~~~");
			}
		}
		else if(query == 3) // remove record
			setInfoStu_qu3(assList);
		else if(query == 4) { // mark attendence
			System.out.println("The new feature have not implemented yet X( "); //setInfoStu_qu4
		}
		else {
			System.out.println("Please Enter Only from 1 to 4");	
			SetInfo_ass(scan.nextInt(), maxSizeDoc, assList);
		}
	}
	private void setInfoStu_qu1(int maxSizeAss, ArrayList<AssistantTeaching> assList) {
//		stus[maxSizeDoc-1] = new Student();
		assList.get(maxSizeAss-1).id = maxSizeAss;
		System.out.println("Please Enter Your First Name: ");
		assList.get(maxSizeAss-1).set_first_name(scan.next());
		System.out.println("Please Enter Your Last Name: ");
		assList.get(maxSizeAss-1).set_last_name(scan.next());
		System.out.println("Please Enter Your Age: ");
		assList.get(maxSizeAss-1).set_age(scan.nextInt());
		System.out.println("Please Enter Your Gender: ");
		assList.get(maxSizeAss-1).set_gender(scan.next());
		scan.nextLine();
		System.out.println("Please Enter Your address: ");
		assList.get(maxSizeAss-1).set_address(scan.nextLine());
		System.out.println("Please Enter Your Phone: ");
		assList.get(maxSizeAss-1).set_phone(scan.next());
		System.out.println("Please Enter Your Department: "); //need validate
		assList.get(maxSizeAss-1).set_specialization(scan.next());
		System.out.println("Please Enter Your Section: "); //maybe the section is much than
		assList.get(maxSizeAss-1).set_section(scan.nextInt()); // number of section
		System.out.println("Please Enter Your EXP: [Junior|Senior|Pro|Expert]");
		assList.get(maxSizeAss-1).set_exp_ass(scan.next());
	}
	private void setInfoStu_qu2(ArrayList<AssistantTeaching> assList) {
		for(int i = 0 ; i<assList.size(); i++) {
			System.out.println(assList.get(i).toString());
		}
		set_check_ID_Search(assList); // Call function below
	}
	private void setInfoStu_qu3(ArrayList<AssistantTeaching> assList) {
		System.out.println("Enter ID You want Delete: ");
		int id = scan.nextInt();
		if(id >= 1 && id <= assList.size()) {
			assList.remove(id-1);
		}else {
			System.out.println("Please Enter ID Available from 1 to "+assList.size());
			del_check_ID_Search(assList,scan.nextInt()); //Call function below
		}
		System.out.println("Has Removed!");
		System.out.println(assList.toString());
		
	}
	private void del_check_ID_Search(ArrayList<AssistantTeaching> assList, int ID) {
		if(ID >= 1 && ID <= assList.size()) {
			assList.remove(ID-1);
		}else {
			System.out.println("Please Enter ID Available from 1 to "+assList.size());
			del_check_ID_Search(assList,scan.nextInt()); //Recursion
		}
		
	}
	private void set_check_ID_Search(ArrayList<AssistantTeaching> assList) {
		System.out.println("Enter ID Assistant : ");
		int id = scan.nextInt();
		if(id >= 1 && id<=assList.size()) {
			assList.get(id-1).setInfoStu_qu1(id, assList); // Call Function above (qu1)
			outEdit(id, assList);
		}
		else {
			System.out.println("Please Enter From 1 to "+assList.size());
			set_check_ID_Search(assList); //Recursion
		}
		
	}
	//Override Methods Here
	@Override
	public void display_all_details() {
		System.out.println(this.toString());	
	}
	@Override
	public void out(int i) { // print info in file
		try {
			FileWriter output = new FileWriter("reports/AssistantTeachingReports/AssistantTeaching"+i);
			output.write(this.toString());
			System.out.println("Inserted Successfuly");
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//@Override
	public void outEdit(int i, ArrayList<AssistantTeaching> ass) { //print the modifications in the file
		try {
			FileWriter output = new FileWriter("reports/AssistantTeachingReports/AssistantTeaching"+i, true);
			output.write("\n\t\t~~The past hisroty~~\n"+ass.get(i-1).toString());
			System.out.println("Inserted Successfuly");
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void del(int i) { //delete the file report
		File delFile = new File("reports/AssistantTeachingReports/AssistantTeaching"+i);
		if(delFile.delete()) {
			System.out.println("The Record has removed");
		}else
			System.out.println("The delete of file has failed...");
	}
	@Override
	public void in(int i) { // Reading from File
		int ch;
		try { 
			FileReader input = new FileReader("reports/AssistantTeachingReports/AssistantTeaching"+i);
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
