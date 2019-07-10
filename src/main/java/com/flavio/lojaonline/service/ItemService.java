package com.flavio.lojaonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flavio.lojaonline.model.Item;
import com.flavio.lojaonline.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public Item salvar(Item item) {
		return this.itemRepository.save(item);
	}
}
