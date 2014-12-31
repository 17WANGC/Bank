import java.io.*;
import java.util.*;

public class bank {

	public static void main(String[] args) {	
		Scanner ui = new Scanner(System.in);
		System.out.println("1.Record Spending\n2.Check Balance");
		int choice = ui.nextInt();
		if(choice == 1){
			System.out.println("Enter Date");
			String date = ui.next();
			System.out.println("Note to Self: If money earned, enter as negative amount.");
			System.out.println("1.Cash\n2.Credit\n3.Student Bank");
			int choice1 = ui.nextInt();
			if(choice1 == 1){
				System.out.println("Amount:");
				int amount = ui.nextInt();
				System.out.println("Item:");
				String item = ui.next();
				Writer w;
				try{
					w = new BufferedWriter(new FileWriter("cashSpendings.txt",true));
					w.append("\n" + date + "     " + item + "     -" + amount);
					
						//read balance file
						Scanner x;
						int balance = 0;
						try{
							x = new Scanner(new File ("cashBalance.txt"));
							balance = x.nextInt();
						}catch(Exception e){
							System.out.println("Reader Error");
						}
						w.append("\tBalance:" + (balance-amount)); 
						w.close();
						
						//overwrite balance file
						Formatter y;
						try{
							y = new Formatter("cashBalance.txt");
							y.format("%s", balance-amount);
							y.close();
						}catch(Exception e){
							System.out.println("Overwrite Error" + "\n" + e);
						}
						
					}catch(Exception e){
						System.out.println("Writer Error");
					}
				}else if(choice1 == 2){
					System.out.println("Amount:");
					int amount = ui.nextInt();
					System.out.println("Item:");
					String item = ui.next();
					Writer w;
					try{
						w = new BufferedWriter(new FileWriter("creditSpendings.txt",true));
						w.append("\n" + date + "     " + item + "     -" + amount);
							
							//read balance file
							Scanner x;
							int balance = 0;
							try{
								x = new Scanner(new File ("creditBalance.txt"));
								balance = x.nextInt();
							}catch(Exception e){
								System.out.println("Reader Error");
							}
							w.append("\tBalance:" + (balance-amount)); 
							w.close();
							
							//overwrite balance file
							Formatter y;
							try{
								y = new Formatter("creditBalance.txt");
								y.format("%s", balance-amount);
								y.close();
							}catch(Exception e){
								System.out.println("Overwrite Error" + "\n" + e);
							}
							
						}catch(Exception e){
							System.out.println("Writer Error");
						}
				}else if(choice1 == 3){
					System.out.println("Amount:");
					int amount = ui.nextInt();
					Writer w, w1;
					try{
						w = new BufferedWriter(new FileWriter("studentBankRecords.txt",true));
						w1 = new BufferedWriter(new FileWriter("cashSpendings.txt",true));
						w.append("\n" + date + "\t-" + amount);
						w1.append("\n" + date + "\tSB Withdraw" + "\t+" + amount);
						
							//read balance file
							Scanner x, x1;
							int balance = 0, balance1 = 0;
							try{
								x = new Scanner(new File ("studentBankBalance.txt"));
								x1 = new Scanner(new File ("cashBalance.txt"));
								balance = x.nextInt();
								balance1 = x1.nextInt();
							}catch(Exception e){
								System.out.println("Reader Error");
							}
							w.append("\tBalance:" + (balance-amount)); 
							w.close();
							w1.append("\tBalance:" + (balance1+amount));
							w1.close();
							
							//overwrite balance file
							Formatter y, y1;
							try{
								y = new Formatter("studentBankBalance.txt");
								y1 = new Formatter("cashBalance.txt");
								y.format("%s", balance-amount);
								if(amount>0){
									y1.format("%s", balance1+amount);
								}
								y.close();
								y1.close();
							}catch(Exception e){
								System.out.println("Overwrite Error" + "\n" + e);
							}
							
						}catch(Exception e){
							System.out.println("Writer Error");
						}
				}
		}else if(choice == 2){
			System.out.println("1.Cash\n2.Credit\n3.Student Bank");
			int choice1 = ui.nextInt();
			if(choice1 == 1){
				Scanner x;
				int balance = 0;
				try{
					x = new Scanner(new File ("cashBalance.txt"));
					balance = x.nextInt();
					System.out.println(balance);
				}catch(Exception e){
					System.out.println("Reader Error");
				}
			}else if(choice1 == 2){
				Scanner x;
				int balance = 0;
				try{
					x = new Scanner(new File ("creditBalance.txt"));
					balance = x.nextInt();
					System.out.println(balance);
				}catch(Exception e){
					System.out.println("Reader Error");
				}
			}else if(choice1 == 3){
				Scanner x;
				int balance = 0;
				try{
					x = new Scanner(new File ("studentBankBalance.txt"));
					balance = x.nextInt();
					System.out.println(balance);
				}catch(Exception e){
					System.out.println("Reader Error");
				}
			}
		}
	}
	
}








