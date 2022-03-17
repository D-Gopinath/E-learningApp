package com.elearning.courseData;

public class CourseData {
	
	public String cName;      //Course Name
	public String cTutor;     //Course Tutor
	public String cDuration;  //Course Duration
	public String cURL;       //Course URL
	
	public CourseData(String cName, String cTutor, String cDuration, String cURL) {
		this.cName = cName;
		this.cTutor = cTutor;
		this.cDuration = cDuration;
		this.cURL = cURL;
		
		System.out.println("CourseName"+cName +"Tutor"+cTutor+"Duration"+cDuration+"URL"+cURL);
	}
}
