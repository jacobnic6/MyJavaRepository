package model;

import java.time.LocalTime;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 7, 2023  
*/
public class Course {
	String courseIdentifier;
	String courseName;
	LocalTime startTime;
	LocalTime endTime;
	Instructor teacher;
	Classroom location;
	
	public Course() {}
	
	
	
	
	
	
	public Course(String courseIdentifier, String courseName, LocalTime startTime, LocalTime endTime,
			Instructor teacher, Classroom location) {
		super();
		setCourseIdentifier(courseIdentifier);
		setCourseName(courseName);
		setStartTime(startTime);
		setEndTime(endTime);
		setTeacher(teacher);
		setLocation(location);
	}






	public String getCourseIdentifier() {
		return courseIdentifier;
	}
	public void setCourseIdentifier(String courseIdentifier) {
		this.courseIdentifier = courseIdentifier;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public Instructor getTeacher() {
		return teacher;
	}
	public void setTeacher(Instructor teacher) {
		this.teacher = teacher;
	}
	public Classroom getLocation() {
		return location;
	}
	public void setLocation(Classroom location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Course [courseIdentifier=" + courseIdentifier + ", courseName=" + courseName + ", startTime="
				+ startTime + ", endTime=" + endTime + ", teacher=" + teacher + ", location=" + location + "]";
	}
	
	
}
