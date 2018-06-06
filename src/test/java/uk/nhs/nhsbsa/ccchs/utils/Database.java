package uk.nhs.nhsbsa.ccchs.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Database {
	
//  static java.sql.Connection ppcConn;
//  static java.sql.Connection prcConn;

	public static void deletePayment(java.sql.Connection ppcConn, String certNumber, Double payAmount) throws Exception {
	   
      final java.sql.PreparedStatement pstmt = ppcConn.prepareStatement("delete from s_payment where cert_number = ? and payment_amount = ?");
      
      try {
      	pstmt.setString(1, certNumber);
      	pstmt.setString(2, payAmount.toString());
      	
      	final java.sql.ResultSet rs = pstmt.executeQuery();
      	try { rs.close(); } catch (Throwable ignore) {}
      	} finally {
      		try { pstmt.close(); } catch (Throwable ignore) {}
       }
	
		}
	
  public static int getPaymentCount(java.sql.Connection ppcConn,String certNumber, Double payAmount) throws Exception {
	   
	  int paymentCount = 0;
	  
	  	final java.sql.PreparedStatement pstmt = ppcConn.prepareStatement("SELECT count(*) FROM s_payment WHERE CERT_NUMBER=? and payment_amount = ?");
       
       try {
    	   pstmt.setString(1, certNumber);
    	   pstmt.setString(2, payAmount.toString());
       	   final java.sql.ResultSet rs = pstmt.executeQuery();
       	   if (rs.next()) {
       		   paymentCount = rs.getInt(1);
       	   }
       	   try { rs.close(); } catch (Throwable ignore) {}
           } finally {
        	   try { pstmt.close(); } catch (Throwable ignore) {}
           }

			return paymentCount;

		}
  
  public static String getEmail(java.sql.Connection ppcConn, String certNumber, String email) throws Exception {
	   
      String expectedEmail = null;
      
      final java.sql.PreparedStatement pstmt = ppcConn.prepareStatement("SELECT EMAIL FROM S_CERTIFICATE_HOLDER WHERE CERT_NUMBER=? AND EMAIL = ?");
      
      try {
      	pstmt.setString(1, certNumber);
      	pstmt.setString(2, email);
      	final java.sql.ResultSet rs = pstmt.executeQuery();
      	try {
      		if (!rs.next()) throw new RuntimeException("Email not found in DataBase");
      		expectedEmail = rs.getString("EMAIL");           		

          } finally {
          	try { rs.close(); } catch (Throwable ignore) {}
          }
      } finally {
      	try { pstmt.close(); } catch (Throwable ignore) {}
      }
      
			return expectedEmail;
			
		}
  
  public static int getEmailCount(java.sql.Connection ppcConn,String certNumber, String email) throws Exception {
	   
  	  int emailCount = 0;
  	  
  	  	final java.sql.PreparedStatement pstmt = ppcConn.prepareStatement("SELECT count(*) FROM s_certificate_holder WHERE CERT_NUMBER=? and email = ?");
         
         try {
      	   pstmt.setString(1, certNumber);
      	   pstmt.setString(2, email);
         	   final java.sql.ResultSet rs = pstmt.executeQuery();
         	   if (rs.next()) {
         		   emailCount = rs.getInt(1);
         	   }
         	   try { rs.close(); } catch (Throwable ignore) {}
             } finally {
          	   try { pstmt.close(); } catch (Throwable ignore) {}
             }

			return emailCount;

		}
	public static void deleteEmail(java.sql.Connection ppcConn, String certNumber, String email) throws Exception {
	 	   
      final java.sql.PreparedStatement pstmt = ppcConn.prepareStatement("update s_certificate_holder set email = null where cert_number = ? and email = ?");
      
      try {
      	pstmt.setString(1, certNumber);
      	pstmt.setString(2, email);
      	
      	final java.sql.ResultSet rs = pstmt.executeQuery();
      	try { rs.close(); } catch (Throwable ignore) {}
      	} finally {
      		try { pstmt.close(); } catch (Throwable ignore) {}
       }
	
		}
	
  public static String getSurname(java.sql.Connection ppcConn, String certNumber) throws Exception {
	   
      String expectedSurname = null;
      
      final java.sql.PreparedStatement pstmt = ppcConn.prepareStatement("SELECT SURNAME FROM S_CERTIFICATE_HOLDER WHERE CERT_NUMBER=?");
      
      try {
      	pstmt.setString(1, certNumber);
      	final java.sql.ResultSet rs = pstmt.executeQuery();
      	try {
      		if (!rs.next()) throw new RuntimeException("Certificate not found in DataBase");
      		expectedSurname = rs.getString("SURNAME");           		

          } finally {
          	try { rs.close(); } catch (Throwable ignore) {}
          }
      } finally {
      	try { pstmt.close(); } catch (Throwable ignore) {}
      }
      
			return expectedSurname;
			
		}
  
  public void DatabaseConnection(java.sql.Connection ppcConn) throws Exception {
      
      //todo add assert to check
        
      TestLogger.Info("DatabaseConnection");
      
      final String certificateNumber = "10000000723";
      final java.math.BigDecimal expectedCertCost = null;
      
      final java.sql.PreparedStatement pstmt = ppcConn.prepareStatement("SELECT * FROM S_CERTIFICATE WHERE CERT_NUMBER=?");
      
      try {
      	pstmt.setString(1, certificateNumber);
      	final java.sql.ResultSet rs = pstmt.executeQuery();
      	try {
      		if (!rs.next()) throw new RuntimeException("Certificate not found in DataBase");
      		final String certCode = rs.getString("CERT_CODE");
      		final String statusCode = rs.getString("STATUS_CODE");
      		final String paymentBalance = rs.getString("PAYMENT_BALANCE");
      		final java.math.BigDecimal certCost = rs.getBigDecimal("CERT_COST");
      		final String duration = rs.getString("DURATION");

      		System.out.println("certCode:"+certCode);
      		System.out.println("statusCode:"+statusCode);
      		System.out.println("paymentBalance:"+paymentBalance);
      		System.out.println("certCost:"+certCost);
      		System.out.println("duration:"+duration);

      		assertEquals(certCode,"3");
      		assertEquals(statusCode,"1");
      		assertEquals(paymentBalance,"0");
      		assertTrue(certCost.compareTo(expectedCertCost)==0); // BigDecimal.equals() is false for the same number but different precision
      		assertEquals(duration,"12");
          } finally {
          	try { rs.close(); } catch (Throwable ignore) {}
          }
      } finally {
      	try { pstmt.close(); } catch (Throwable ignore) {}
      }
 }    

}
