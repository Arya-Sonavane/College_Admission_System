package org.techhub.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdmissionModel {
	
	
	     int aid;
	     int sid;
	     int cid;
	     Date admission_date;
	     String status;

//	    public int getAid()
//	    {
//	    	return aid;
//	    } 
//	    public void setAid(int aid)
//	    {
//	    	this.aid=aid;
//	    }
//	    public int getSid()
//	    {
//	    	return sid;
//	    }
//	    public void setSid(int sid)
//	    {
//	    	this.sid=sid;
//	    }
//	    public int getCid()
//	    {
//	    	return cid;
//	    }
//	    public void setCid(int cid)
//	    {
//	    	this.cid=cid;
//	    }
//	    public Date getAdmission_date()
//	    {
//	    	return admission_date;
//	    }
//	    public void setAdmission_date(Date admission_date)
//	    {
//	    	this.admission_date=admission_date;
//	    }
//	    public String getStatus()
//	    {
//	    	return status;
//	    }
//	    public void setStatus(String status)
//	    {
//	    	this.status=status;
//	    }
//	    
//	    public AdmissionModel()
//	    {
//	    	
//	    }
//	    public AdmissionModel(int aid, int sid, int cid, Date admission_date, String status)
//	    {
//	    	this.aid=aid;
//	    	this.cid=sid;
//	    	this.cid=cid;
//	    	this.admission_date=admission_date;
//	    	this.status=status;
//	    }
//	    
}
