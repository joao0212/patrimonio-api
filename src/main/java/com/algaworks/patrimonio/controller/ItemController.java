package com.algaworks.patrimonio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.patrimonio.model.Item;
import com.algaworks.patrimonio.repository.ItemRepository;

@RestController
@RequestMapping(path = "/itens")
@CrossOrigin("${origem-permitida}")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<Item> listar() {
		return itemRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Item adicionar(@Valid @RequestBody Item item) {
		return itemRepository.save(item);
	}

}
