package com.example.demo.TopicService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.Topic;
import com.example.demo.Repository.TopicRepository;


@Service
public class TopicService {
	
	
	@Autowired
	public TopicRepository topicRepository;
//
//	 List<Topic>topicList=Arrays.asList(new Topic("5", "adventure", "all about exploring aliens")
//			,new Topic("7", "magic", "all about exploring magical world")
//			);
	
	public List<Topic> getTopic(){
//		return topicList;
		List<Topic> topicList = new ArrayList<>();
		 topicRepository.findAll().forEach(topicList::add);
		 return topicList;
	}
	
	public Topic getTopicById(String id) {
//		return topicList.stream().filter(i -> i.getId().equals(id)).findFirst().get();
	return 	topicRepository.findById(id).orElse(null);
	}

	public void updateTopicById(String id,Topic topic) {
		// TODO Auto-generated method stub
//		System.out.println("**************");
//		for(int i = 0;i <topicList.size()-1;i++) {
//			if(topicList.get(i).getId().equals(id)) {
//				topicList.set(i, topic);
//				System.out.println("******inside update****");
//			}
//		}
		
//		return 
		topicRepository.save(topic);
	}

	public void deleteTopic(String topicId) {
//		topicList.removeIf(i->i.getId().equals(topicId));
		topicRepository.deleteById(topicId);
	}

	public void createTopic(Topic topic) {
		// TODO Auto-generated method stub
		topicRepository.save(topic);
	}
}