package com.example.BookNCharacter.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookNCharacter.Entity.Book;
import com.example.BookNCharacter.Entity.Character;
import com.example.BookNCharacter.Service.CharacterService;

@RestController
public class CharacterController {
	@Autowired
	CharacterService characterService;
	
	@GetMapping("/book/{id}/hello")
	public String getCHello() {
		return " Character=== Control==testing";
}
	@GetMapping("/book/{id}/character")
	public  List<Character>  getCharacters(@PathVariable String id) {
		System.out.println("get character......");
		return characterService.getCharacters(id);
		
	}
	@GetMapping("/book/{id}/character/{chName}")
	public  Character getCharacterByCharacterName(@PathVariable String chName) {
		return characterService.getCharacterByCharacterName(chName);
	}
		@PostMapping("/book/{id}/character")
		public void addCharacter( @RequestBody Character character,@PathVariable String id) {
			System.out.println("Post....Mapping..."+id);
			character.setBook(new Book(id,"","","",""));
			System.out.println(new Book(id,"","","",""));
			characterService.addCharacter(character);
		}

	@PutMapping("/book/{id}/character/{chName}")
	public void updatCharacterByName(@PathVariable String chName,@PathVariable String id, @RequestBody Character character) {
		character.setBook(new Book(id,"","","",""));
	characterService.updateCharacterByName(character);
	}
	@DeleteMapping("/book/{id}/character/{chName}")
	public void deleteCharacter(@PathVariable String chName) {
		characterService.deleteCharacter(chName);
	}
	

}
