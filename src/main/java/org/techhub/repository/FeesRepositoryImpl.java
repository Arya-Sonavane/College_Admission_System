package org.techhub.repository;

import org.apache.log4j.Logger;

public class FeesRepositoryImpl extends DBSTATE implements FeesRepository{
	
	private static Logger logger=Logger.getLogger(FeesRepositoryImpl.class);

	@Override
	public boolean checkFeeStatus(String studentName) {
		
		
		try
		{
			    stmt = conn.prepareStatement("SELECT sid FROM student WHERE name = ?");
	            stmt.setString(1, studentName);
	            rs = stmt.executeQuery();
	            int remaning_fee=0;
	            while(rs.next())
	            {
	            	int sid=rs.getInt(1);
	            	stmt = conn.prepareStatement("SELECT aid FROM admission WHERE pid = ?");
		            stmt.setInt(1, sid);
		            rs=stmt.executeQuery();
		            while(rs.next())
		            {
		            	int aid=rs.getInt(1);
		            	stmt = conn.prepareStatement("SELECT remaining_fee FROM fees WHERE aid = ?");
		            	while(rs.next())
		            	{
		            		remaning_fee=rs.getInt(1);
		            	}
		            	
		            }
	            }
	           return remaning_fee>0?true:null;
	            
	            
		}catch(Exception e)
		{
			
			 logger.error("Error occurred while checking fee status for student: " + studentName, e);
			System.out.println("Error is"+e);
			return false;
		}
	}
 
}
