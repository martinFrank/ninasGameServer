package com.github.martinfrank.ninasgame.server.item.service;

import com.github.martinfrank.ninasgame.server.item.entity.Item;
import com.github.martinfrank.ninasgame.server.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {


    @Autowired
    private final ItemRepository itemRepository;


    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @Override
    public Item create(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item update(Item item) {
        Optional<Item> mapCandidate = itemRepository.findById(item.getId());

        if (mapCandidate.isPresent()) {
            Item itemToUpdate = mapCandidate.get();
            itemToUpdate.setId(item.getId());
            itemToUpdate.setName(item.getName());
            itemToUpdate.setWeight(item.getWeight());
            return itemToUpdate;
        } else {
            throw new ResourceNotFoundException("Person Record not found with id : " + item.getId());
        }
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item getById(long id) {
        Optional<Item> candidate = this.itemRepository.findById(id);
        if (candidate.isPresent()) {
            return candidate.get();
        } else {
            throw new ResourceNotFoundException("Person Record not found with id : " + id);
        }
    }

    @Override
    public void delete(long id) {
        Optional<Item> candidate = this.itemRepository.findById(id);
        if (candidate.isPresent()) {
            this.itemRepository.delete(candidate.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }
}
