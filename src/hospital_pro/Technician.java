package hospital_pro;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Technician extends Person implements Display{
	private double salary;
	private String Exp_techi;
	
	public void set_salary(double salary) {
		this.salary = salary;
	}
	public double get_salary() {
		return this.salary;
	}
	public void set_exp_techi(String exp) {
		if(exp.equalsIgnoreCase("junior")|| exp.equalsIgnoreCase("senior") ||exp.equalsIgnoreCase("pro")|| exp.equalsIgnoreCase("expert")) {
			Exp_techi = exp;	
		}
		else {
			System.out.println("Please Enter EXP [Junior,Senior,Pro,Expert]");
			set_exp_techi(scan.next());
		}
	}
	public String get_exp_techi() {
		return this.Exp_techi;
	}
	@Override
	public String toString() {
		return "ID: "+this.id+"\t|first Name: "+this.get_first_name()+"\t|"
				+"Last Name: "+this.get_last_name()+"\t|Age: "+this.get_age()+"\t|EXP: "+this.get_exp_techi()+"\t|Salary: "+this.salary;
	}

	@Override
	public void display_all_details() {
		System.out.println(toString());
	}

	public void SetInfo_tech(int query, int maxSizeTech, ArrayList<Technician> techList) {
		if(query == 1) {
			setInfoStu_qu1(maxSizeTech,techList); // Insert
			out(this.id);
		}
		else if(query == 2) {
			setInfoStu_qu2(techList); // Modify
			System.out.println("Do you want to see the modifactions for one of the Technicians?: (Only if you modify info for someone), [True, False] only");
			if(scan.nextBoolean()) {
				System.out.println("Enter ID which you changed: ");
				int id = scan.nextInt();
				techList.get(id-1).in(id);
				System.out.println("\t\t~~~ The Data Now ~~~");
			}
		}
		else if(query == 3) {
			setInfoStu_qu3(techList); // Remove
			del(this.id);
		}
		else if(query == 4) { // Record marks
			System.out.println("The new feature have not implemented yet X( "); //setInfoStu_qu4
		}
		else {
			System.out.println("Please Enter Only from 1 to 4");
			SetInfo_tech(scan.nextInt(), maxSizeTech, techList);
		}
	}

	private void setInfoStu_qu1(int maxSizeTech, ArrayList<Technician> techList) {
//		stus[maxSizeStu-1] = new Student();
		techList.get(maxSizeTech-1).id = maxSizeTech;
		System.out.println("Please Enter Your First Name: ");
		techList.get(maxSizeTech-1).set_first_name(scan.next());
		System.out.println("Please Enter Your Last Name: ");
		techList.get(maxSizeTech-1).set_last_name(scan.next());
		System.out.println("Please Enter Your Age: ");
		techList.get(maxSizeTech-1).set_age(scan.nextInt()); 
		System.out.println("Please Enter Your Gender: ");
		techList.get(maxSizeTech-1).set_gender(scan.next());
		scan.nextLine();
		System.out.println("Please Enter Your address: ");
		techList.get(maxSizeTech-1).set_address(scan.nextLine());
		System.out.println("Please Enter Your Phone: ");
		techList.get(maxSizeTech-1).set_phone(scan.next());
		System.out.println("Enter The Salary: ");
		techList.get(maxSizeTech-1).set_salary(scan.nextDouble());
		System.out.println("What is your exp in your Field: (Junior|Senior|Pro|Expert)");
		techList.get(maxSizeTech-1).set_exp_techi(scan.next());
	}

	private void setInfoStu_qu2(ArrayList<Technician> techList) {
		for(int i = 0 ; i<techList.size(); i++) {
			System.out.println(techList.get(i).toString());
		}
		set_check_ID_Search(techList); // Call function below
	}

	private void set_check_ID_Search(ArrayList<Technician> techList) {
		System.out.println("Enter ID Technician : ");
		int id = scan.nextInt();
		if(id >= 1 && id<=techList.size()) {
			techList.get(id-1).setInfoStu_qu1(id, techList); // Call Function above (qu1)
			outEdit(id, techList);
		}
		else {
			System.out.println("Please Enter From 1 to "+techList.size());
			set_check_ID_Search(techList); //Recursion
		}
	}
	private void setInfoStu_qu3(ArrayList<Technician> techList) {
		System.out.println("Enter ID You want Delete: ");
		int id = scan.nextInt();
		if(id >= 1 && id <= techList.size()) {
			techList.remove(id-1);
		}else {
			System.out.println("Please Enter ID Available from 1 to "+techList.size());
			del_check_ID_Search(techList,scan.nextInt()); //Call function below
		}
		System.out.println("Has Removed!");
		System.out.println(techList.toString());
	}
	private void del_check_ID_Search(ArrayList<Technician> techList, int ID) {
		if(ID >= 1 && ID <= techList.size()) {
			techList.remove(ID-1);
		}else {
			System.out.println("Please Enter ID Available from 1 to "+techList.size());
			del_check_ID_Search(techList,scan.nextInt()); //Recursion
		}
		
	}
	public void out(int i) { // print info in file
		try {
			FileWriter output = new FileWriter("reports/TechnicianReport/Technician"+i);
			output.write(this.toString());
			System.out.println("Inserted Successfuly");
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//@Override
	public void outEdit(int i, ArrayList<Technician> tech) { //print the modifications in the file
		try {
			FileWriter output = new FileWriter("reports/TechnicianReport/Technician"+i, true);
			output.write("\n\t\t~~The last hisroty~~\n"+tech.get(i-1).toString());
			System.out.println("Inserted Successfuly");
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void del(int i) { //delete the file report
		File delFile = new File("reports/TechnicianReport/Technician"+i);
		if(delFile.delete()) {
			System.out.println("The Record has removed");
		}else
			System.out.println("The delete of file has failed...");
	}
	@Override
	public void in(int i) { // Reading from File
		int ch;
		try { 
			FileReader input = new FileReader("reports/TechnicianReport/Technician"+i);
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
