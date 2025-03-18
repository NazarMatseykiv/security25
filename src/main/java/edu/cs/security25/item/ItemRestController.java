package edu.cs.security25.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemRestController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems() { return itemService.getAllItems(); }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable String id) { return itemService.getItemById(id); }

    @PostMapping
    public Item createItem(@RequestBody Item item) { return itemService.saveItem(item); }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) { itemService.deleteItem(id); }
}
