package com.example.BookNCharacter.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.BookNCharacter.Entity.Character;
import com.example.BookNCharacter.Repository.CharacterRepository;

@Service
public class CharacterService {

	@Autowired
	public CharacterRepository characterRepository;
	
	public List<Character> getCharacters(String id) {
		System.out.println(id);
		List<Character> allChar=new ArrayList<>();
		characterRepository.findByBookId(id).forEach(allChar::add);
		System.out.println("Getting Records with Book id"+id+"  "+allChar);
				return allChar;
	}

	public Character getCharacterByCharacterName(String chName) {
				return characterRepository.findById(chName).orElse(null);
	}
	
	
	
	public void deleteCharacter(String charName) {
		// TODO Auto-generated method stub
	characterRepository.deleteById(charName);
		
	}

	public void addCharacter(Character character) {
		
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("added record....addCharacter called............");
				System.out.println(character);
				characterRepository.save(character);
		
	}

	public void updateCharacterByName(Character character) {
		// TODO Auto-generated method stub
		System.out.println("Updated record....updateCharacter called............");
		
		characterRepository.save(character);
	}

	
}
