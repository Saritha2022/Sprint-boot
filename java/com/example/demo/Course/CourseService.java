package com.example.demo.Course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class CourseService {
	@Autowired
	public CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId);
		 		 return courses;
	}
	public Course getCourseById(String id) {

	return 	courseRepository.findById(id).orElse(null);
	}
	public void createCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepository.save(course);
	}
public void updateCourse(Course course)
{
	courseRepository.save(course);
}
public void deleteCourse(String id ) {
	courseRepository.deleteById(id);
}
}

