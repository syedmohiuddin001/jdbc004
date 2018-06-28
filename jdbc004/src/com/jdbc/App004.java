package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
	
public class App004 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		Scanner scanner = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "syed");
			st = con.createStatement();
			
			scanner = new Scanner(System.in);
			System.out.print("Bonus Amount :");
			int bonus_Amt = scanner.nextInt();
			System.out.print("Salary Range :");
			float sal_Range = scanner.nextFloat();
			int rowCount = st.executeUpdate("update emp set esal = esal + "+bonus_Amt+" where esal < "+sal_Range);
			System.out.println("No of Records Updated :"+rowCount);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				scanner.close();
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
}