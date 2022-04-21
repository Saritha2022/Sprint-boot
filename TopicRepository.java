package com.example.demo.Repository;
import javax.management.loading.ClassLoaderRepository;

import org.springframework.data.repository.CrudRepository;


public interface TopicRepository extends CrudRepository<Topic, String>{

}