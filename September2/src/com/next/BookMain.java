package com.next;

import java.util.List;
import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("Enter the Choice 1 for Inserting Books");
			System.out.println("Enter the Choice 2 for Selecting Book");
			System.out.println("Enter the Choice 3 for Viewing List of Books");
			System.out.println("Enter the Choice 4 fro Deleting Books");
			System.out.println("Enter the Choice 5 for Updating Books");
			System.out.println("Enter the Choice 6 for Exit");
			System.out.println("Enter Your Choice:");
			choice=sc.nextInt();sc.nextLine();
			BookDAOImp1 bdao=new BookDAO();
			switch(choice) {
			case 1:
				System.out.println("Enter the Details:");
				Book b=new Book();
				b.setSerialNumber(sc.nextLong());sc.nextLine();
				b.setBookName(sc.nextLine());
				b.setBookAuthor(sc.nextLine());
				b.setBookCost(sc.nextDouble());sc.nextLine();
				bdao.insertBook(b);	
				System.out.println("Your Details Updated Sucessfully");
				break;
			case 2:
				System.out.println("Enter The Book Serial Number");
				long SerialNumber=sc.nextLong();
				Book b1=bdao.selectBook(SerialNumber);
				System.out.println(b1.getSerialNumber()+" | "+b1.getBookName()+" | "+b1.getBookAuthor()+" | "+b1.getBookCost());
				break;
			case 3:
				List<Book> book=bdao.selectAllBook();
				book.stream().forEach(System.out::println);
				break;
			case 4:
				System.out.println("Enter The Book Serial Number");
				long Serialnumber=sc.nextLong();
				if(bdao.deleteBook(Serialnumber)==true) {
					System.out.println("Deleted Sucessfully");
				}
				else {
					System.out.println("Book Serial Number Doesn't Exist");
				}
				break;
			case 5:
				System.out.println("Enter The BookName For Updating");
				String name=sc.nextLine();
				if(bdao.updateBook(name)==true) {
					System.out.println("Updates Sucessfully");
				}
				else {
					System.out.println("BookName Doesn't Exist");
				}
				break;
			case 6:
				System.out.println("Bye");
				break;	
			}
		}while(choice!=6);

	}

}
