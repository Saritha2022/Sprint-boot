package com.example.demo.Course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.Topic;


@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping("/topic/{id}/course1")
	public String getWelcome() {
		return "Hello Good Morning";
	}
		@RequestMapping("/topic/{id}/course/welcome1")
	public String getWelcome(@PathVariable String id) {
		return "Welcome to course"+id;
	}
	
	@RequestMapping("/topic/{id}/course")
	public  List<Course>  getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
		
	
	@RequestMapping("/topic/{topicId}/course/{id}")
	public  Course getCourseById(@PathVariable String id) {
		return courseService.getCourseById(id);
	}
	@RequestMapping(method = RequestMethod.POST , value ="/topic/{topicId}/course")
	public void createCourse( @RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.createCourse(course);
	}
	@RequestMapping(method = RequestMethod.PUT,value ="/topic/{topicId}/course/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String topicId,@PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		 courseService.updateCourse(course);
	}
	@RequestMapping(method = RequestMethod.DELETE,value = "topic/{topicId}/course/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
