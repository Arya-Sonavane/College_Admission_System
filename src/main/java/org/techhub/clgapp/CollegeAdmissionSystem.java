package org.techhub.clgapp;
import org.techhub.service.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.techhub.model.*;
import org.techhub.repository.StudentRepositoryImpl;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import org.techhub.model.*;

public class CollegeAdmissionSystem {  //main class

	private static Logger logger=Logger.getLogger(CollegeAdmissionSystem.class);
	static
	{
		try
		{
			PropertyConfigurator.configure("src/main/resources/log4j.properties");
			logger.info("CollegeAdmissionSystem:Log4j setUp ready");
		}catch(Exception e)
		{
			e.printStackTrace();
			logger.info("CollegeAdmissionSystem:Log4j problem setUp ready");
		}
	}
	public static void main(String[] args) {



		StudentService stud=new StudentServiceImpl();
		userService suser=new userServiceImpl();
		CourseService courseService = new CourseServiceImpl();
		AdmissionService admissionservice = new AdmissionServiceImpl();
		feesService fservice=new fessServiceImpl();

		boolean b;

		logger.info("Application started");
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
			logger.info("User selected choice: " + choice);
			switch(choice)
			{
			case 1:

				logger.info("Register User process started");

				// Get username
				System.out.println("Enter username");
				sobj.nextLine(); // Clear the buffer
				String uname = sobj.nextLine().trim();

				// Username validation
				if (uname.isEmpty() || !uname.matches("^[a-zA-Z0-9]+$")) { // Allow alphanumeric usernames
					logger.warn("Invalid username format: " + uname);
					System.out.println("Invalid username! Only alphanumeric characters are allowed.");
					break;
				}

				// Get password
				System.out.println("Enter password");
				String password = sobj.nextLine().trim();

				// Password validation
				if (password.length() < 6 || !password.matches(".*[!@#$%^&*].*")) {
					logger.warn("Invalid password format for username: " + uname);
					System.out.println("Invalid password! Password must be at least 6 characters long and include at least one special symbol (!@#$%^&*).");
					break;
				}
				UserModel model= new UserModel(0, uname, password);//user model class object
				b =suser.addUser(model);
				if(b)
				{
					logger.info("User successfully added: " + uname);
					System.out.println("User added");
				}
				else
				{
					logger.warn("Failed to add user: " + uname);
					System.out.println("User not added!");
				}

				break;

			case 2:

				logger.info("User Login process started");
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
					logger.info("User logged in successfully: " + username + " Role: " + Userrole);
					System.out.println("Login Done!"+" "+Userrole);
					if(Userrole.equalsIgnoreCase("admin"))
					{
						logger.info("Admin panel accessed by: " + username);
						System.out.println("Admin panel!");
						//add staff
						//update staff
						//delete staff
						//update student
						//delete student
						//delete course
						//delete admission

						boolean exitadmin=false;
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
							System.out.println("10.exit");


							System.out.println("Select appropriate option");
							int choice1=sobj.nextInt();
							logger.info("Admin selected choice: " + choice1);

							switch(choice1)
							{
							case 1:

								logger.info("Admin adding staff");
								System.out.println("Enter username");
								sobj.nextLine();
								String uname1=sobj.nextLine();
								System.out.println("Enter password");
								String password11=sobj.nextLine();
								UserModel model1= new UserModel(0, uname1, password11);
								b =suser.addUser(model1);
								if(b)
								{
									logger.info("Staff added successfully: " + uname1);
									System.out.println("User added");
								}
								else
								{
									logger.warn("Failed to add staff: " + uname1);
									System.out.println("User not added!");
								}

								break;

							case 2:

								logger.info("Admin updating staff");
								System.out.println("Enter old staff name");
								sobj.nextLine();
								String oldstaffname=sobj.nextLine();
								System.out.println("Enter new staff name");
								String newstaffname=sobj.nextLine();
								b=suser.isUpdateStaff(oldstaffname,newstaffname);
								if(b)
								{
									logger.info("Staff updated successfully: " + oldstaffname + " to " + newstaffname);
									System.out.println("Staff updated!");
								}
								else
								{
									logger.warn("Failed to update staff: " + oldstaffname);	
									System.out.println("There is some problem");
								}
								break;

							case 3:
								logger.info("Admin deleting staff");
								System.out.println("Enter old staff name");
								sobj.nextLine();
								String oldstaff=sobj.nextLine();
								b=suser.isDeleteStaff(oldstaff);
								if(b) 
								{
									logger.info("Staff deleted successfully: " + oldstaff);
									System.out.println("Staff Delete!");
								}
								else
								{
									logger.warn("Failed to delete staff: " + oldstaff);
									System.out.println("There is some problem");
								}
								break;

							case 4:
								logger.info("Admin updating staff");
								System.out.println("Enter Student Current Name");
								sobj.nextLine();
								String currName = sobj.nextLine();
								System.out.println("Enter Student New Name");
								String newName = sobj.nextLine();

								b=stud.updateStudent(currName, newName);
								if(b)
								{
									logger.info("Staff updated successfully: " + currName + " to " +newName);
									System.out.println("Updated");
								}
								else
								{
									logger.info("failed to Staff upadted staff: " + currName + " to " +newName);
									System.out.println("Not Updated");
								}

								break;

							case 5:

								logger.info("Admin deleting student");
								System.out.println("Enter student name");
								sobj.nextLine();
								String studname=sobj.nextLine();
								b=stud.deleteStudent(studname);
								if(b)
								{
									logger.info("Student deleted successfully: " + studname);
									System.out.println("Student delete");
								}
								else
								{
									logger.info("Student not deleted successfully: " + studname);
									System.out.println("Student not delete");
								}
								break;
							case 6:

								logger.info("Admin adding the course ");
								System.out.println("Enter Course Name");
								sobj.nextLine();
								String courseName = sobj.nextLine();
								System.out.println("Enter Course Fees");
								int fees = sobj.nextInt();  
								CourseModel course = new CourseModel(0, courseName, fees);
								b= courseService.addCourse(course);
								if(b)
								{
									logger.info("Student addedd successfully: " + 0 + courseName + fees );
									System.out.println("Course Added!");
								}
								else
								{
									logger.info("Student not addedd successfully: " + 0 + courseName + fees );
									System.out.println("Course not Added!");
								}
								break;
							case 7:

								logger.info("Admin updating the course ");
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
									logger.info("course updated successfully: " + currentName +  newCourseName +newFee);
									System.out.println("course updated successfully");
								}
								else
								{
									logger.info("course  not updated successfully: " + currentName +  newCourseName +newFee);
									System.out.println("course not updated");
								}
								break;

							case 8:

								logger.info("Admin delete the course ");
								System.out.println("Enter Course name");
								sobj.nextLine();
								String coursename=sobj.nextLine();
								b=courseService.deleteCourse(coursename);
								if(b)
								{
									logger.info("course delete successfully: " + coursename);
									System.out.println("course delete");
								}
								else
								{
									logger.info("course not delete successfully: " + coursename);
									System.out.println("course not delete");
								}

							case 9:

								logger.info("Admin delete the admission");
								System.out.println("Enter name of student which admission do you want to delete");
								sobj.nextLine();
								String studname1=sobj.nextLine();
								b=admissionservice.isdeleteAdmission(studname1);
								if(b)
								{
									logger.info("admission delete successfully: " + studname1);
									System.out.println("Admission delete!");
								}
								else
								{
									logger.info("admission not delete successfully: " + studname1);
									System.out.println("There is some problem!");
								}

							case 10:
								exitadmin=true;

							default:
								System.out.println("Select Correct Opetion!");

							}
						}while(!exitadmin);
					}
					else
					{
						logger.info("Staff panel accessed by: " + username);
						System.out.println("Staff panel"); 


						System.out.println("Student management");
						boolean studManagement=false;
						do
						{
							System.out.println("1:Add student ");
							System.out.println("2.View All students"); 			
							System.out.println("3.view Course");
							System.out.println("4.exit");
							System.out.println("Enter correct choice");
							int choice1=sobj.nextInt();
							switch(choice1)
							{
							case 1:

								logger.info("staff adding the student ");
								System.out.println("Enter name of Student");
								sobj.nextLine();
								String sname=sobj.nextLine();
								System.out.println("Enter email of Student");
								String email=sobj.nextLine();
								System.out.println("Enter Contact of Student");
								long contact=sobj.nextLong();
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
									logger.info("student add successfully: " +model1 + amount_paid +course_name);
									System.out.println("Student Added!");
								}
								else
								{
									logger.info("student not add successfully: " +model1 + amount_paid +course_name);
									System.out.println("Not added!");
								}

								break;
							case 2:

								logger.info("staff view all the students ");
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

								logger.info("staff view all the courses ");
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
								studManagement=true;
							default:
								System.out.println("Choose correct choice!");
							}
						}while(!studManagement);
					}
				}
				else
				{
					logger.warn("Login failed for user: " + username);
					System.out.println("Login Fail!");
				}

				break;
			case 3:

				logger.info("Student Login process started");
				System.out.println("Student Login");
				System.out.println("Enter student name");
				sobj.nextLine();
				username = sobj.nextLine();
				System.out.println("Enter student password");
				password1 = sobj.nextLine();
				b = stud.login(username, password1);
				if(b)
				{
					logger.info("Student logged in successfully: " + username);
					System.out.println("Student Login");
					boolean studestatus=false;
					do
					{
						System.out.println("1:View Course");
						System.out.println("2:Check Admission status");
						System.out.println("3:Check Fee payment status");

						System.out.println("Select choice");
						choice=sobj.nextInt();
						logger.info("Student selected choice: " + choice);
						switch(choice)
						{
						case 1:
							logger.info("Student viewing courses");
							System.out.println("All Courses");
							List<CourseModel> courses= courseService.viewAllCourses();
							if(courses!=null)
							{
								for (CourseModel c : courses) {
									System.out.println(c.getCid() + " " + c.getCname() + " " + c.getFees());
								}
							}
							else
							{
								logger.warn("No courses available");
							}
							break;
						case 2:
							logger.info("Student checking admission status");
							System.out.println("Enter your name:");
							sobj.nextLine();
							String studentName = sobj.nextLine();
							String admission_status=admissionservice.checkAdmissionStatus(studentName);
							if (b) {
								logger.info("Admission status for " + studentName + ": " + admission_status);
								System.out.println("Admission Status: "+admission_status);
							} else {
								logger.warn("No admission record found for: " + studentName);
								System.out.println("No admission record found.");
							}

							break;

						case 3:

							logger.info("Student checking fee status");
							System.out.println("Enter your name:");
							sobj.nextLine();
							String studentNameForFee = sobj.nextLine();
							b = fservice.checkFeeStatus(studentNameForFee);

							if (b) {
								logger.info("Pending fee status for student: " + studentNameForFee);
								System.out.println("Fee Status for " +"pending");
							} else {
								logger.info("Fee paid status for student: " + studentNameForFee);
								System.out.println("Fees paid");
							}

							break;
						
						case 4:
							studestatus=true;
						default:

							logger.warn("Student selected an invalid choice: " + choice);
							System.out.println("Correct choice!");
						}

					}while(!studestatus);
				}
				else
				{
					logger.warn("Student login failed for: " + username);
					System.out.println("there is some problem");
				}

				break;   
			case 4:
				logger.info("Application exited by user");
				System.exit(0);

			default:

				logger.warn("User selected an invalid choice: " + choice);
				System.out.println("Select approprite choice!");
			}
		}
		while(true);

	}
}

