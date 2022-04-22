package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.Topic;
import com.example.demo.TopicService.TopicService;



@RestController
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
	@RequestMapping("/hello")
	public String getHello() {
		return "Hello Good Morning";
	}
	@RequestMapping("/hi")
	public String getHi() {
		return "Hi Good morning ,Good Afternoon,Good Day";
	}
	
	@RequestMapping("/topic")
	public  List<Topic>  getTopic() {
		return topicService.getTopic();
		
	}
	@RequestMapping("/topic/{id}")
	public  Topic getTopicById(@PathVariable String id) {
		return topicService.getTopicById(id);
	}
	@RequestMapping(method = RequestMethod.PUT,value = "/topic/{id}")
	public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
		 topicService.updateTopicById(id,topic);
	}
	@RequestMapping(method = RequestMethod.DELETE,value = "/topic/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	@RequestMapping(method = RequestMethod.POST , value = "/topic")
	public void createTopic( @RequestBody Topic topic) {
		topicService.createTopic(topic);
	}
}
