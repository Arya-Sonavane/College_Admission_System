package org.techhub.clgapp;
import org.techhub.service.*;
import org.techhub.model.*;
import org.techhub.repository.StudentRepositoryImpl;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import org.techhub.model.*;

public class CollegeAdmissionSystem {  //main class

	public static void main(String[] args) {
		
	StudentService stud=new StudentServiceImpl();
	userService suser=new userServiceImpl();
	CourseService courseService = new CourseServiceImpl();
	AdmissionService admissionservice = new AdmissionServiceImpl();
	feesService fservice=new fessServiceImpl();
	
	boolean b;
	
	System.out.println("Welcome to College Admission System Application!");
	Scanner sobj=new Scanner(System.in);
	do
	{
       System.out.println("1.Register User");
       System.out.println("2:User Login");
       System.out.println("3:Student Login");
       System.out.println("4:Exit");
       System.out.println("Select Appropriate Choice");
      
       int choice=sobj.nextInt();
       switch(choice)
       {
       case 1:
    	    
    	    System.out.println("Enter username");
    	    sobj.nextLine();
    	    String uname=sobj.nextLine();
    	    System.out.println("Enter password");
    	    String password=sobj.nextLine();
    	    UserModel model= new UserModel(0, uname, password);
    	    b =suser.addUser(model);
    	    if(b)
    	    {
    	    	System.out.println("User added");
    	    }
    	    else
    	    {
    	    	System.out.println("User not added!");
    	    }
    	    
    	    break;
      
       case 2:
    	    System.out.println("User Login");
    	    System.out.println("Enter username");
    	    sobj.nextLine();
    	    String username=sobj.nextLine();
    	    System.out.println("Enter password");
    	    String password1=sobj.nextLine();
    	    String Userrole=suser.role(username);
    	    b=suser.login(username, password1);
    	    if(b)
    	    {
    	    	System.out.println("Login Done!"+" "+Userrole);
    	    	if(Userrole.equalsIgnoreCase("admin"))
    	    	{
    	    		System.out.println("Admin panel!");//admin panel
    	    		//add staff
    	    		//update staff
    	    		//delete staff
    	    		//update student
    	    		//delete student
    	    		//delete course
    	    		//delete admission
    	    		
    	    		do {
    	    		
    	    			System.out.println("1.Add Staff");
    	    			System.out.println("2.Update Staff");
    	    			System.out.println("3.Delete Staff");
    	    			System.out.println("4.Update Student");
    	    			System.out.println("5.Delete  Student");
    	    			System.out.println("6.Add Course");
    	    			System.out.println("7.update Course");
    	    			System.out.println("8.delete Course");
    	    			System.out.println("9.delete admission");
    	    			
    	    			
    	    			System.out.println("Select appropriate option");
    	    			int choice1=sobj.nextInt();
    	    			
    	    			
    	    			switch(choice1)
    	    			{
    	    			case 1:
    	    				System.out.println("Enter username");
    	    	    	    sobj.nextLine();
    	    	    	    String uname1=sobj.nextLine();
    	    	    	    System.out.println("Enter password");
    	    	    	    String password11=sobj.nextLine();
    	    	    	    UserModel model1= new UserModel(0, uname1, password11);
    	    	    	    b =suser.addUser(model1);
    	    	    	    if(b)
    	    	    	    {
    	    	    	    	System.out.println("User added");
    	    	    	    }
    	    	    	    else
    	    	    	    {
    	    	    	    	System.out.println("User not added!");
    	    	    	    }
    	    	    	    
    	    	    	    break;
    	    	    	    
    	    			case 2:
    	    				System.out.println("Enter old staff name");
    	    				sobj.nextLine();
    	    				String oldstaffname=sobj.nextLine();
    	    				System.out.println("Enter new staff name");
    	    				String newstaffname=sobj.nextLine();
    	    				b=suser.isUpdateStaff(oldstaffname,newstaffname);
    	    				if(b)
    	    				{
    	    					System.out.println("Staff updated!");
    	    				}
    	    				else
    	    				{
    	    				  System.out.println("There is some problem");
    	    				}
    	    				break;
    	    				
    	    			case 3:
    	    				System.out.println("Enter old staff name");
    	    				sobj.nextLine();
    	    				String oldstaff=sobj.nextLine();
    	    				b=suser.isDeleteStaff(oldstaff);
    	    				if(b) 
    	    				{
    	    					System.out.println("Staff Delete!");
    	    				}
    	    				else
    	    				{
    	    				  System.out.println("There is some problem");
    	    				}
    	    				break;
    	    				
    	    			case 4:
    	    				System.out.println("Enter Student Current Name");
    	    				sobj.nextLine();
    	    				String currName = sobj.nextLine();
    	    				System.out.println("Enter Student New Name");
    	    				String newName = sobj.nextLine();
    	    				
    	    				b=stud.updateStudent(currName, newName);
    	    				if(b)
    	    				{
    	    					System.out.println("Updated");
    	    				}
    	    				else
    	    				{
    	    					System.out.println("Not Updated");
    	    				}
    	    			
    	    		      break;
    	    		      
    	    			case 5:
    	    		         System.out.println("Enter student name");
    	    		         sobj.nextLine();
    	    		         String studname=sobj.nextLine();
    	    		         b=stud.deleteStudent(studname);
    	    		         if(b)
    	    		         {
    	    		        	 System.out.println("Student delete");
    	    		         }
    	    		         else
    	    		         {
    	    		        	 System.out.println("Student not delete");
    	    		         }
    	    		         break;
    	    			case 6:
    	    				System.out.println("Enter Course Name");
    	    		        sobj.nextLine();
    	    		        String courseName = sobj.nextLine();
    	    		        System.out.println("Enter Course Fees");
    	    		        int fees = sobj.nextInt();  
    	    		        CourseModel course = new CourseModel(0, courseName, fees);
    	    		        b= courseService.addCourse(course);
    	    		        if(b)
    	    		        {
    	    		        	System.out.println("Course Added!");
    	    		        }
    	    		        else
    	    		        {
    	    		        	System.out.println("Course not Added!");
    	    		        }
    	    		        break;
    	    			case 7:
    	    				System.out.println("Enter current course name");
    	    				sobj.nextLine();
    	    				String currentName=sobj.nextLine();
    	    				System.out.println("Enter new course name");
    	    		        String newCourseName = sobj.nextLine();
    	    		        System.out.println("Enter new course fees");
    	    		        int newFee = sobj.nextInt();
    	    		        
    	    		        b= courseService.updateCourse(currentName, newCourseName, newFee);
    	    		        if(b)
    	    		        {
    	    		        	System.out.println("course updated successfully");
    	    		        }
    	    		        else
    	    		        {
    	    		        	System.out.println("course not updated");
    	    		        }
    	    		         break;
    	    		         
    	    			case 8:
    	    				System.out.println("Enter Course name");
    	    				sobj.nextLine();
    	    				String coursename=sobj.nextLine();
    	    				b=courseService.deleteCourse(coursename);
    	    				if(b)
    	    				{
    	    					 System.out.println("course delete");
    	    				}
    	    				else
    	    				{
    	    					 System.out.println("course not delete");
    	    				}
    	    				
    	    			case 9:
    	    				System.out.println("Enter name of student which admission do you want to delete");
    	    				sobj.nextLine();
    	    				String studname1=sobj.nextLine();
    	    				b=admissionservice.isdeleteAdmission(studname1);
    	    				if(b)
    	    				{
    	    					System.out.println("Admission delete!");
    	    				}
    	    				else
    	    				{
    	    					System.out.println("There is some problem!");
    	    				}
    	    				
    	    				
    	    		   }
    	    		}while(true);
    	    	}
    	    	    else
    	    	    {
    	    		System.out.println("Staff panel"); 
    	    		
    	    		//add student
    	    		//view student
    	    		//view course
    	    		//add admission
    	    		
    	    		
    	    		
    	    		System.out.println("Student management");
    	    		do
    	    		{
    	    			System.out.println("1:Add student ");
    	    			System.out.println("2.View All students"); 			
    	    			System.out.println("3.view Course");
    	    			System.out.println("4.Add Admission");
    	    			System.out.println("Enter correct choice");
    	    			int choice1=sobj.nextInt();
    	    			switch(choice1)
    	    			{
    	    			case 1:
    	    				  System.out.println("Enter name of Student");
    	    				  sobj.nextLine();
    	    				  String sname=sobj.nextLine();
    	    				  System.out.println("Enter email of Student");
    	    				  String email=sobj.nextLine();
    	    				  System.out.println("Enter Contact of Student");
    	    				  int contact=sobj.nextInt();
    	    				  System.out.println("Enter address of Student");
    	    				  sobj.nextLine();
    	    				  String address=sobj.nextLine();
    	    				  System.out.println("Enter password of student");
    	    				  String password11=sobj.nextLine();
    	    				  System.out.println("Enter the course name");
    	    				  String course_name=sobj.nextLine();
    	    				  System.out.println("Enter amount_paid"); 
    	    				  int amount_paid=sobj.nextInt();
    	    				  StudentModel model1=new StudentModel('0',sname,email,contact,address,password11);
    	    				  
    	    				  boolean b2=stud.addStudent(model1,amount_paid,course_name);
    	    				  if(b2)
    	    				  {
    	    					  System.out.println("Student Added!");
    	    				  }
    	    				  else
    	    				  {
    	    					  System.out.println("Not added!");
    	    				  }
    	    				  
    	    				break;
    	    			case 2:
    	    				System.out.println("All Students");
    	    				List<StudentModel> ViewAllStudents=stud.viewAllStudents();
    	    			    if(ViewAllStudents!=null)
    	    			    {
    	    			    	for(StudentModel s:ViewAllStudents)
    	    			    	{
    	    			    		System.out.println(s.getSid()+" "+s.getSname()+" "+s.getEmail()+" "+s.getContact()+" "+s.getAddress());
    	    			    	}
    	    			    }
    	    			    break;
    	    			
    	    			
    	    			case 3:
    	    				System.out.println("All Courses");
    	    				List<CourseModel> courses= courseService.viewAllCourses();
    	    				if(courses!=null)
    	    				{
    	    					for (CourseModel c : courses) {
    	                            System.out.println(c.getCid() + " " + c.getCname() + " " + c.getFees());
    	    				}
    	    			}		
    	    			break;	
    	    			case 4:
    	    				System.out.println("Enter student name");
    	    				sobj.nextLine();
    	    				String studename=sobj.nextLine();
    	    				System.out.println("Enter course name");
    	    				String cname=sobj.nextLine();
    	    				System.out.println("Enter student admission date");
    	    				String date=sobj.next();
							b=admissionservice.addAdmission(studename,cname,date);
    	    				if(b)
    	    				{
    	    					System.out.println("Admission addedd successfully....");
    	    				}
    	    				else
    	    				{
    	    					System.out.println("Admission not addedd successfully....");
    	    				}
    	    				break;
    	    				
    	    			case 6:
    	    				System.exit(0);
    	    			default:
    	    				System.out.println("Choose correct choice!");
    	    			}
    	    		}while(true);
    	    	}
    	    }
    	    else
    	    {
    	    	System.out.println("Login Fail!");
    	    }
    	    
            break;
       case 3:
       System.out.println("Student Login");
       System.out.println("Enter student name");
       sobj.nextLine();
       username = sobj.nextLine();
       System.out.println("Enter student password");
       password1 = sobj.nextLine();
       b = stud.login(username, password1);
       if(b)
       {
    	   System.out.println("Student Login");
    	   do
    	   {
    		   System.out.println("1:View Course");
    		   System.out.println("2:Check Admission status");
    		   System.out.println("3:Check Fee payment status");
    		   
    		   System.out.println("Select choice");
    		   choice=sobj.nextInt();
    		   switch(choice)
    		   {
    		   case 1:
    			   System.out.println("All Courses");
   				List<CourseModel> courses= courseService.viewAllCourses();
   				if(courses!=null)
   				{
   					for (CourseModel c : courses) {
                           System.out.println(c.getCid() + " " + c.getCname() + " " + c.getFees());
   				     }
   				}
    			   break;
    		   case 2:
    			   System.out.println("Enter your name:");
    			   sobj.nextLine();
                   String studentName = sobj.nextLine();
                   String admission_status=admissionservice.checkAdmissionStatus(studentName);
                   if (b) {
                       System.out.println("Admission Status: "+admission_status);
                   } else {
                       System.out.println("No admission record found.");
                   }
    			   
    			   break;
    			   
    		   case 3:
    			   System.out.println("Enter your name:");
    			    sobj.nextLine();
    			    String studentNameForFee = sobj.nextLine();
    			     b = fservice.checkFeeStatus(studentNameForFee);

    			    if (b) {
    			        System.out.println("Fee Status for " +"pending");
    			    } else {
    			        System.out.println("Fees paid");
    			    }
    			   
    			   break;
    			default:
    				System.out.println("Correct choice!");
    		   }
    		   
    	   }while(true);
       }
       else
       {
    	   System.out.println("there is some problem");
       }
    	
    	break;   
       case 4:
    	    System.exit(0);
    	   
       default:
    	   System.out.println("Select approprite choice!");
       }
	}
	while(true);

}
}

