package uk.nhs.nhsbsa.ccchs.helpers;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class PostgreSQLExample {

	public void CheckConnection() {
		
		try
		{
			PostgreSQLExample postgreSQLExample = new PostgreSQLExample();
			
			Connection conn = postgreSQLExample.getPostgreSQLConnection();
			
			/* You can use the connection object to do any insert, delete, query or update action to the mysql server.*/
			/* Do not forget to close the database connection after use, this can release the database connection.*/
		
			
			String complaintNotesMin= null;
			String complaintNotesMax = null;
			String complaintDetailsMin= null;
			String complaintDetailsMax = null;
			String complaintFieldHistoryMin= null;
			String complaintFieldHistoryMax = null;
			

			
			String query_complaintNotesMin = "select note_id from public.complaint_notes where note_id = (select Min(note_id) from public.complaint_notes)";
			String query_complaintNotesMax = "select note_id from public.complaint_notes where note_id = (select Max(note_id) from public.complaint_notes)";

			String query_complaintDetailsMin = "select complaint_id from public.complaint_details where complaint_id = (select Min(complaint_id) from public.complaint_details)";
			String query_complaintDetailsMax =	"select complaint_id from public.complaint_details where complaint_id = (select Max(complaint_id) from public.complaint_details)";
				
			String query_complaintFieldHistoryMin = "select change_id from public.complaint_field_history where change_id = (select Min(change_id) from public.complaint_field_history)";
			String query_complaintFieldHistoryMax =	"select change_id from public.complaint_field_history where change_id = (select Max(change_id) from public.complaint_field_history)";

					
			// Statement Object to send queries
			Statement stmt_complaintNotesMin = conn.createStatement();
			Statement stmt_complaintNotesMax = conn.createStatement();
			Statement stmt_complaintDetailsMin = conn.createStatement();
			Statement stmt_complaintDetailsMax = conn.createStatement();
			Statement stmt_complaintFieldHistoryMin = conn.createStatement();
			Statement stmt_complaintFieldHistoryMax = conn.createStatement();

			
			// statement object is created use the executeQuery method to execute the SQL queries
			stmt_complaintNotesMin.executeQuery(query_complaintNotesMin);
			stmt_complaintNotesMax.executeQuery(query_complaintNotesMax);
			stmt_complaintDetailsMin.executeQuery(query_complaintDetailsMin);
			stmt_complaintDetailsMax.executeQuery(query_complaintDetailsMax);
			stmt_complaintFieldHistoryMin.executeQuery(query_complaintFieldHistoryMin);
			stmt_complaintFieldHistoryMax.executeQuery(query_complaintFieldHistoryMax);
			
			// Execute the SQL Query. Store results in ResultSet		
     		ResultSet rs_complaintNotesMin = stmt_complaintNotesMin.executeQuery(query_complaintNotesMin);	
     		ResultSet rs_complaintNotesMax = stmt_complaintNotesMax.executeQuery(query_complaintNotesMax);
     		ResultSet rs_complaintDetailsMin = stmt_complaintDetailsMin.executeQuery(query_complaintDetailsMin);	
     		ResultSet rs_complaintDetailsMax = stmt_complaintDetailsMax.executeQuery(query_complaintDetailsMax);
     		ResultSet rs_complaintFieldHistoryMin = stmt_complaintFieldHistoryMin.executeQuery(query_complaintFieldHistoryMin);	
     		ResultSet rs_complaintFieldHistoryMax = stmt_complaintFieldHistoryMax.executeQuery(query_complaintFieldHistoryMax);
     		
     		System. out.println("rs_complaintDetailsMin : " + rs_complaintDetailsMin.toString());
     		System. out.println("rs_complaintDetailsMax : " + rs_complaintDetailsMax.toString());
     		
     		System. out.println("rs_complaintFieldHistoryMin : " + rs_complaintFieldHistoryMin.toString());
     		System. out.println("rs_complaintFieldHistoryMax : " + rs_complaintFieldHistoryMax.toString());
     		 
     		
     		 
     		while (rs_complaintNotesMin.next()){
     			complaintNotesMin = rs_complaintNotesMin.getString(1);								        
                				                               
             System. out.println(""	+ " complaintNotesMin: " + complaintNotesMin);
             
     		}
     		
     		while (rs_complaintNotesMax.next()){
     			complaintNotesMax = rs_complaintNotesMax.getString(1);								        
                				                               
             System. out.println(""	+ " complaintNotesMax: " + complaintNotesMax);
             
     		}
     		 
     		while (rs_complaintDetailsMin.next()){
     			complaintDetailsMin = rs_complaintDetailsMin.getString(1);								        
                				                               
             System. out.println(""	+ " complaintDetailsMin: " + complaintDetailsMin);
             
     		}
     		
     		while (rs_complaintDetailsMax.next()){
     			complaintDetailsMax = rs_complaintDetailsMax.getString(1);								        
                				                               
             System. out.println(""	+ " complaintDetailsMax: " + complaintDetailsMax);
             
     		}
     		
     		/* complaint_field_history table min and max by change_id */
     		while (rs_complaintFieldHistoryMin.next()){
     			complaintFieldHistoryMin = rs_complaintFieldHistoryMin.getString(1);								        
                				                               
             System. out.println(""	+ " complaintFieldHistoryMin: " + complaintFieldHistoryMin);
             
     		}
     		
     		while (rs_complaintFieldHistoryMax.next()){
     			complaintFieldHistoryMax = rs_complaintFieldHistoryMax.getString(1);								        
                				                               
             System. out.println(""	+ " complaintFieldHistoryMax: " + complaintFieldHistoryMax);
             
     		}
     		
     		
  
     		/* Delete Complaint Field History */ 
     		String query_deleteComplaintFieldHistory = "DELETE FROM public.complaint_field_history WHERE change_id between " +  complaintFieldHistoryMin  + " and "  + complaintFieldHistoryMax;
     		
     		
     		Statement stmt_deleteComplaintFieldHistory = conn.createStatement();
			
			// statement object is created use the executeQuery method to execute the SQL queries
     		stmt_deleteComplaintFieldHistory.executeUpdate(query_deleteComplaintFieldHistory);
     		
     		
     		/* Delete Complaints */ 
     		String query_deleteComplaintDetails = "DELETE FROM public.complaint_details WHERE complaint_id between " +  complaintDetailsMin  + " and "  + complaintDetailsMax;
     		
     		Statement stmt_deleteComplaintDetails = conn.createStatement();
			
			// statement object is created use the executeQuery method to execute the SQL queries
     		stmt_deleteComplaintDetails.executeUpdate(query_deleteComplaintDetails);
     		
     		
     		/* Delete Notes */ 
     		String query_deleteNotes = "DELETE FROM public.complaint_notes WHERE note_id between " +  complaintNotesMin  + " and "  + complaintNotesMax;
     				
     		Statement stmt_deleteComplaintNotes = conn.createStatement();
			
			// statement object is created use the executeQuery method to execute the SQL queries
     		stmt_deleteComplaintNotes.executeUpdate(query_deleteNotes);
     		

			
//     		if (rs != null)
//          {
//              rs.close();
//          }
			
			
			
			conn.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	
	/* This method return java.sql.Connection object. */
	public Connection getPostgreSQLConnection()
	{
		/* Declare and initialize a sql Connection variable. */
		Connection ret = null;
		
/*
  
 	LOCAL:-
  		String mysqlConnUrl = "jdbc:postgresql://localhost:5432/postgress";
  		String mysqlUserName = "postgres";
		String mysqlPassword = "postgres";
		
		
		
	HERUKO:-
		cemsman
		Host:                      ec2-54-228-235-185.eu-west-1.compute.amazonaws.com
		Port:                      5432
		Maintenance DB:            d4jvd09prn2ouh
		Username:                  vllfrldeeiiizl
		Password:                  f64c8c88c1f033cb213ee27609cd04cfd73e34d4f25ee447d1a3e6cb727f678d
		
		String mysqlConnUrl = "jdbc:postgresql://ec2-54-228-235-185.eu-west-1.compute.amazonaws.com:5432/d4jvd09prn2ouh?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
			
		
		
	DOCKER image:-
		spring.datasource.username=runner
		spring.datasource.password=
		spring.datasource.url=jdbc:postgresql://postgres:5432/nice_marmot
		
*/
		
		
		try
		{
		
			/* Register jdbc driver class. */
			Class.forName("org.postgresql.Driver");
			
			/* Create connection url. */
			String mysqlConnUrl = "jdbc:postgresql://ec2-54-228-235-185.eu-west-1.compute.amazonaws.com:5432/d4jvd09prn2ouh?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
			
			/* user name. */
			String mysqlUserName = "vllfrldeeiiizl";
			
			/* password. */
			String mysqlPassword = "f64c8c88c1f033cb213ee27609cd04cfd73e34d4f25ee447d1a3e6cb727f678d";
			
			/* Get the Connection object. */
			ret = DriverManager.getConnection(mysqlConnUrl, mysqlUserName , mysqlPassword);
			
			/* Get related meta data for this mysql server to verify db connect successfully.. */
			DatabaseMetaData dbmd = ret.getMetaData();
			
			String dbName = dbmd.getDatabaseProductName();
			String dbVersion = dbmd.getDatabaseProductVersion();
			String dbUrl = dbmd.getURL();
			String userName = dbmd.getUserName();
			String driverName = dbmd.getDriverName();
			
			System.out.println("Database Name is " + dbName);			
			System.out.println("Database Version is " + dbVersion);	
			System.out.println("Database Connection Url is " + dbUrl);
			System.out.println("Database User Name is " + userName);
			System.out.println("Database Driver Name is " + driverName);
			
						
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		
		return ret;
		
	}

}