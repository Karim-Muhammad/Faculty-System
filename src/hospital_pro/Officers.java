package hospital_pro;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Officers extends Person {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	//Override Methods Here
@Override
	public void out(int i) { // print info in file
		try {
			FileWriter output = new FileWriter("reports/OfficersReport/Officer"+i);
			output.write(this.toString());
			System.out.println("Inserted Successfuly");
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void outEdit(int i, ArrayList<Officers> offi) { //print the modifications in the file
		try {
			FileWriter output = new FileWriter("reports/OfficersReport/Officer"+i, true);
			output.write("\n\t\t~~The past hisroty~~\n"+offi.get(i-1).toString());
			System.out.println("Inserted Successfuly");
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void del(int i) { //delete the file report
		File delFile = new File("reports/OfficersReport/Officer"+i);
		if(delFile.delete()) {
			System.out.println("The Record has removed");
		}else
			System.out.println("The delete of file has failed...");
	}
	@Override
	public void in(int i) { // Reading from File
		char[] chars = new char[200];
		try {
			try (FileReader input = new FileReader("reports/OfficersReport/Officer"+i)) {
				input.read(chars);
			}
			System.out.println(chars);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("The Reading from file failed");
		}
	}
}

