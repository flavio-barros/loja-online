package com.flavio.lojaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flavio.lojaonline.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
