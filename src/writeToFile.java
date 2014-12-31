import java.util.*;
import java.io.*;

public class writeToFile {
	
	private Formatter cash;
	
	public void openFile(){
		try{
			cash = new Formatter("cash.txt");
		}catch(Exception e){
			System.out.println("Error");
		}
	}
	
	public void addRecords(){
		cash.format("%s%s","hi","lol");
	}
	
	public void closeFile(){
		cash.close();
	}
	
}
