package edu.cs.security25.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    private List<Item> items = new ArrayList<>();
    @Autowired
    private ItemRepository repository;

    public List<Item> getAllItems() { return itemRepository.findAll(); }
    public Optional<Item> getItemById(String id) { return itemRepository.findById(id); }
    public Item saveItem(Item item) { return itemRepository.save(item); }
    public void deleteItem(String id) { itemRepository.deleteById(id); }
    @PostConstruct
    void init() {
        items.add(new Item("1", 12));
        items.add(new Item("2", 13));
        items.add(new Item("3", 14));
        repository.saveAll(items);
    }

    public List<Item> getAll() {
        return repository.findAll();
    }


    public Item getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Item create(Item item) {
        return repository.save(item);
    }

    public Item update(Item item) {
        return repository.save(item);
    }
}