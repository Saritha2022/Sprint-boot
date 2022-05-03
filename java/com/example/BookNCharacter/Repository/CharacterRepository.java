package com.example.BookNCharacter.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.BookNCharacter.Entity.Character;


public interface CharacterRepository extends CrudRepository<Character,String> {
		public List<Character> findByBookId(String id);
}
