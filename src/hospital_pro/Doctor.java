package hospital_pro;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Doctor extends Person implements Display{
	
	//Items
	private String Exp_doctor;
	private String department_doctor;
	private String[] Courses = new String[6]; // Numbs of Subject (Courses name);
	private int numsCourses;
	private int group;
	
	//Constructor
	Doctor() {this.id++;}
	
	//methods
	//setter experience doctor
	public void set_exp_doctor(String exp) {
		if(exp.equalsIgnoreCase("junior")|| exp.equalsIgnoreCase("senior") ||exp.equalsIgnoreCase("pro")|| exp.equalsIgnoreCase("expert")) {
			Exp_doctor = exp;	
		}
		else {
			System.out.println("Please Enter EXP [Junior,Senior,Pro,Expert]");
			set_exp_doctor(scan.next());
		}
	}
	public String get_exp_doctor() {
		return this.Exp_doctor;
	}
	//setter department
	public void set_dep_doctor(String dep) { // check Error
		if(dep.length() == 2) {//Using varius way to ignore case Characters
			if( (dep.equalsIgnoreCase("iS"))|| (Character.toLowerCase(dep.charAt(0)) == 'c' && Character.toLowerCase(dep.charAt(1)) == 's') || ( (dep.charAt(0) == 'm'||dep.charAt(0) == 'M') && (dep.charAt(1) == 'm'||dep.charAt(1) == 'M') )|| (Character.toUpperCase(dep.charAt(0)) == 'I' && Character.toUpperCase(dep.charAt(1)) == 'T')) 
					this.department_doctor = dep;
			else {
					System.out.println("Not Found This Department! [IT,IS,CS,MM]");
					set_dep_doctor(scan.next()); // Recursion
			}
		}
		else {
			System.out.println("The Department need To 2 Letters only!");
			set_dep_doctor(scan.next()); //Recursion
		}
	}
	public String get_dep_doctor() {
		return this.department_doctor;
	}
	//setter Group
	public void set_group(int n) {
		if(n>=1 && n<=10)
			this.group = n;
		else
			System.out.println("This group not found");
	}
	//=================>> Insert the Courses Name
	public void set_Courses(int n) {
		System.out.println("Please Enter Your Courses Name : ");
		for(int i =0 ; i<n; i++) {
			System.out.println("Course["+(i+1)+"]: ");
			Courses[i] = new String();
			Courses[i] = scan.next();
			/**
			 * => I could make List of Courses and The Doctor choose That's Good Idea too(enum) ^_^.
			 */
		}
	}
	public String get_Courses() {
		String resu = "[";
		for(int i = 0 ; i < numsCourses ; i++) {
			if(i == numsCourses - 1 )
				resu+= Courses[i];
			else
				resu+= Courses[i] + ", ";
		}
		return resu+"]";
	}
	// useful common methods
	//=================>> Display info each doctors
	@Override
	public String toString() {
		return "ID: "+this.id+"\t|first Name: "+this.get_first_name()+"\t|"
				+"Last Name: "+this.get_last_name()+"\t|Age: "+this.get_age()+"\t|Specialization: "+String.valueOf(this.department_doctor)+"\t|EXP: "+this.get_exp_doctor()+"\t|The Courses: "+this.get_Courses();
	}
	//=================>> Compare with the equal
	public void equals(Doctor e) {
		this.set_first_name(e.get_first_name());
		this.set_last_name(e.get_last_name());
		this.set_age(e.get_age());
		this.set_phone(e.get_phone());
		this.set_address(e.get_address());
		this.set_gender(e.get_gender());
		this.set_email(e.get_email());
		this.set_password(e.get_password());
	}//=================>> Search All operation using First Name
	static void searchFName(char name, Doctor[] emps) {
		for(int i =0; i < emps.length ; i++) {
			if(emps[i].get_first_name().charAt(0) == name)
				System.out.println("ID: "+emps[i].id+"\t|first Name: "+emps[i].get_first_name()+"\t|"
						+"Last Name: "+emps[i].get_last_name()+"\t|Specialization: "+emps[i].department_doctor);
		}
	}

	// End Useful common Function
	//Again
	//=================>> Execute operation using Query
	public void SetInfo_doc(int query, int maxSizeDoc, ArrayList<Doctor> docList) {
		if(query == 1) { // insert query
			setInfoDoc_qu1(maxSizeDoc,docList);
			out(this.id);
		}
		else if(query == 2) { //modify query
			setInfoDoc_qu2(docList);
			System.out.println("Do you want to see the modifactions for one of the Doctors?: (Only if you modify info for someone) [True, False] only");
			if(scan.nextBoolean()) {
				System.out.println("Enter ID: ");
				int id = scan.nextInt();
				docList.get(id-1).in(id);
				System.out.println("\t\t~~~ The Data Now ~~~");
			}
		}
		else if(query == 3) { // remove record
			setInfoDoc_qu3(docList);
			del(this.id);
		}
		else if(query == 4) { // record attendence
			System.out.println("The new feature have not implemented yet X( "); //setInfoStu_qu4
		}
		else {
			System.out.println("Please Enter Only from 1 to 4");	
			SetInfo_doc(scan.nextInt(), maxSizeDoc, docList);
		}
	}
	//=================>> Insert Record
	private void setInfoDoc_qu1(int maxSizeDoc, ArrayList<Doctor> docList) { // Insert
//		stus[maxSizeDoc-1] = new Student();
		docList.get(maxSizeDoc-1).id = maxSizeDoc;
		System.out.println("Please Enter Your First Name: ");
		docList.get(maxSizeDoc-1).set_first_name(scan.next());
		System.out.println("Please Enter Your Last Name: ");
		docList.get(maxSizeDoc-1).set_last_name(scan.next());
		System.out.println("Please Enter Your Age: ");
		docList.get(maxSizeDoc-1).set_age(scan.nextInt());
		System.out.println("Please Enter Your Gender: ");
		docList.get(maxSizeDoc-1).set_gender(scan.next());
		scan.nextLine();
		System.out.println("Please Enter Your address: ");
		docList.get(maxSizeDoc-1).set_address(scan.nextLine());
		System.out.println("Please Enter Your Phone: ");
		docList.get(maxSizeDoc-1).set_phone(scan.next());
		System.out.println("Please Enter Your Department: "); //need validate
		docList.get(maxSizeDoc-1).set_dep_doctor(scan.next());
		System.out.println("Please Enter nums of Courses you give: ");
		numsCourses = scan.nextInt();
		docList.get(maxSizeDoc-1).set_Courses(numsCourses);
		System.out.println("Enter Your EXP: [junior|Senior|Pro|Expert]");
		docList.get(maxSizeDoc-1).set_exp_doctor(scan.next());
			
		// Trash
		//System.out.println("If you need print all info for student["+maxSizeDoc+"] (true,false)");
		//if(scan.nextBoolean()) {
		//	System.out.println(docList[maxSizeDoc-1].toString());
		//}else {
		//	System.out.println("Well! The info Successfully Stored");
		//}
}
	// =================>> Modify Record
	private void setInfoDoc_qu2(ArrayList<Doctor> docList) { //Modify
		for(int i = 0 ; i<docList.size(); i++) {
			System.out.println(docList.get(i).toString());
		}
		set_check_ID_Search(docList); // Call function below
		
	}
	// =================>> Remove Record
	private void setInfoDoc_qu3(ArrayList<Doctor> docList) { // Remove Record
		System.out.println("Enter ID You want Delete: ");
		int id = scan.nextInt();
		if(id >= 1 && id <= docList.size()) {
			docList.remove(id-1);
		}else {
			System.out.println("Please Enter ID Available from 1 to "+docList.size());
			del_check_ID_Search(docList,scan.nextInt()); //Call function below
		}
		System.out.println("Has Removed!");
//		System.out.println(docList.toString());
	}
	// Delete Specify ID
	private void del_check_ID_Search(ArrayList<Doctor> docList, int ID) {
		if(ID >= 1 && ID <= docList.size()) {
			docList.remove(ID-1);
		}else {
			System.out.println("Please Enter ID Available from 1 to "+docList.size());
			del_check_ID_Search(docList,scan.nextInt()); //Recursion
		}
	}
	// Set info to Specify ID
	private void set_check_ID_Search(ArrayList<Doctor> docList) {
		System.out.println("Enter ID Doctor : ");
		int id = scan.nextInt();
		if(id >= 1 && id<=docList.size()) {
			docList.get(id-1).setInfoDoc_qu1(id, docList); // Call Function above (qu1)
			outEdit(id, docList);
		}
		else {
			System.out.println("Please Enter From 1 to "+docList.size());
			set_check_ID_Search(docList); //Recursion
		}
	}
	// Override Methods Here and there others like toString and Equal but above ^_^
	@Override
	public void display_all_details() {
		System.out.println(toString());
	}

	public void out(int i) { // print info in file
		try {
			FileWriter output = new FileWriter("reports/DoctorsReport/Doctor"+i);
			output.write(this.toString());
			System.out.println("Inserted Successfuly");
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("The Inserting Failed...");
		}
	}
	//@Override do no activite it
	public void outEdit(int i,ArrayList<Doctor> doc) { //print the modifications in the file
		try {
			FileWriter output = new FileWriter("reports/DoctorsReport/Doctor"+i, true);
			output.write("\n\t\t~~The last hisroty~~\n"+doc.get(i-1).toString());
			System.out.println("Inserted Successfuly");
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Failing happend while append");
		}
	}
	@Override
	public void del(int i) { //delete the file report
		File delFile = new File("reports/DoctorsReport/Doctor"+i);
		if(delFile.delete()) {
			System.out.println("The Record has removed");
		}else
			System.out.println("The delete of file has failed...");
	}
	@Override
	public void in(int i) { // Reading from File
		int ch;
		try { 
			FileReader input = new FileReader("reports/DoctorsReport/Doctor"+i);
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
