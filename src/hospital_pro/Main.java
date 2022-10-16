/*
 * 
 * 
 * 
 * 
 * 
 * 
 * I made mistake in the Name of File  so I apologize (instead hospital ==> faculty) , thanks
 * */
package hospital_pro;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

class Query {
	static Scanner scan = new Scanner(System.in);
	static long quer;
	Query(long n){
		isquery(n);
	}
	Query(String n){
		System.out.println("Please enter Integer only from 1 to 5");
		isquery(scan.nextInt());
	}
	static void isquery(long n) {
		if(n>=1 && n<=5) {
			quer = n;
		}
		else {
			System.out.println("Please Enter Number from 1 to 5");
			isquery(scan.nextInt());
		}
	}
	public long get_query() {
		return quer;
	}
	public void set_query(long n) {
		if(n>=1 && n<=5) {
			quer = n;
		}
		else {
			System.out.println("Please Enter Number from 1 to 5");
			isquery(scan.nextInt());
		}
	}
}
public class Main {

	public static void main(String[] args) {
		
		// Reading from File (basic) try
		char[] c = new char[600];
		try {
			FileReader file = new FileReader("read1.txt");
			file.read(c);
			System.out.println(c);
		} catch (IOException e1) {
			System.out.println("Error in creation of File...");
		}
		long querL = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("1)For Student info\n2)For Doctors info\n3)For AssistantTeaching info\n4)For Technicians info\n5)Officers(Locked)");
		while(querL == 0) {
			try{
				Query query = new Query(scan.nextLong());
				querL = query.get_query();
				if(query.get_query() == 1) { //Student
					int maxSizeStu = 0;
					Student[] stus = new Student[maxSizeStu+30]; //nums of Students
					ArrayList<Student> stuList =new ArrayList<Student>();
					do {// Which Query you want (Operations)
						System.out.println("1)Add new Student\n2)Edit info Student\n3)Delete Student\n4)Record Marks(not yet)"); //Questions for Students
						query.set_query(scan.nextLong());
						if(query.get_query() == 1) {
							++maxSizeStu;
							//++maxSizeStu;
							stus[maxSizeStu-1] = new Student();
							stuList.add(stus[maxSizeStu-1]);
						}
						if(maxSizeStu < 1) { //if didn't login before
							System.out.println("Please You have to Login one time at least");
						}else {
							stus[maxSizeStu-1].SetInfo_stu((int)query.get_query(), maxSizeStu, stuList);
						}
						//for just style 
						for(int i = 0 ; i < stuList.size() ; i++) {
							System.out.println(stuList.get(i));
						}
						System.out.println("\n\t\t ``Do you want to do operation to Student? [True,False] ``\n\n");
					}while(scan.nextBoolean());
					}
				//
				else if(querL == 2) { //Doctor
					int maxSizeDoc = 0;
					Doctor docs[] = new Doctor[maxSizeDoc+30]; // Determine numbs of Doctors
					ArrayList<Doctor> docList = new ArrayList<Doctor>();
					do{
						System.out.println("1)Login(add) new Doctor\n2)Edit info Doctor\n3)Delete Doctor\n4)Record Attendence(not yet)"); // Question for Doctor
						query.set_query(scan.nextLong());
						if( query.get_query() == 1) {
							maxSizeDoc++;
							docs[maxSizeDoc-1] = new Doctor();
							docList.add(docs[maxSizeDoc-1]);
//							docs[maxSizeDoc-1].id = maxSizeDoc;
						}
						if(maxSizeDoc < 1) {
							System.out.println("Please You have to Login one time at least");
						}else {
							docs[maxSizeDoc-1].SetInfo_doc((int)query.get_query(), maxSizeDoc, docList);
						}
						for(int i = 0 ; i < docList.size() ; i++) {
							System.out.println(docList.get(i));
						}
						System.out.println("\n\t\t ``Do you want to do operation to Doctor? [True,False] ``\n\n");	
					}while(scan.nextBoolean());
				}
				else if(querL == 3) {	//AssistantTeaching
					int maxSizeAss = 0;
					AssistantTeaching ass[] = new AssistantTeaching[maxSizeAss+30]; // Determine numbs of Doctors
					ArrayList<AssistantTeaching> assList = new ArrayList<AssistantTeaching>();
					do{
						System.out.println("1)add new AssistantTeaching\n2)Edit info AssistantTeaching\n3)Delete AssistantTeaching\n4)Record Attendence(not yet)"); // Question for Doctor
						query.set_query(scan.nextLong());
						if( query.get_query() == 1) {
							maxSizeAss++;
							ass[maxSizeAss-1] = new AssistantTeaching();
							assList.add(ass[maxSizeAss-1]);
						}
						if(maxSizeAss < 1) {
							System.out.println("Please You have to Login one time at least");
						}else {
							ass[maxSizeAss-1].SetInfo_ass((int)query.get_query(), maxSizeAss, assList);
						}
						for(int i = 0 ; i < assList.size() ; i++) {
							System.out.println(assList.get(i));
						}
						System.out.println("\n\t\t ``Do you want to do operation to AssistantTeaching? [True,False] ``\n\n");	
					}while(scan.nextBoolean());
				}
				else if(querL == 4) {	//Technician
					int maxSizeTech = 0;
					Technician techs[] = new Technician[maxSizeTech+30]; // For ID
					ArrayList<Technician> techList = new ArrayList<Technician>();
					//===================================================
					do{
						System.out.println("1)add new Technician\n2)Edit info Techinician\n3)Delete Techinician\n4)Record Attendence(not Yet)");
						query.set_query(scan.nextLong());
						if( query.get_query() == 1) {
							maxSizeTech++;
							techs[maxSizeTech-1] = new Technician();
							techList.add(techs[maxSizeTech-1]);
						}
						if(maxSizeTech < 1) {
							System.out.println("Please You have to Login one time at least");
						}else {
							techs[maxSizeTech-1].SetInfo_tech((int)query.get_query(), maxSizeTech, techList);
						}
						for(int i = 0 ; i < techList.size() ; i++) {
							System.out.println(techList.get(i));
						}
						System.out.println("\n\t\t ``Do you want to do operation to Technicians? [True,False] ``\n\n");	
				}while(scan.nextBoolean());
				}else if(query.get_query() == 5) {
					System.out.println("ÈÞÇ ãÊßÓÝäíÔ XD ");
					System.out.println("El Juza da m3mlto4 LdeQ El Waqt (Final), bs Teqdr Tegrb ElBaqy, Thanks For appreciate");
					System.out.println("To activite this feature, you have to price one million Dollar\nPrice:  ");
					float price = scan.nextFloat();
					if(price >= 1000000) {
						System.out.println("You're Joking Right? XD");
					}else
						System.out.println("Soon 8) ");
					System.out.println("Actually This will be like others no big different so if you want try the program\nchoose from 1 to 4, sir\nThanks For Appreciate that ^_^");
				}
				}catch(InputMismatchException e)
				{
					System.out.println("WARNING! Please Enter integer only!");
//					quer = 0;
				}
		}
}
}




// I would Like Validate the attributes correctly but i found many blacks and few time really