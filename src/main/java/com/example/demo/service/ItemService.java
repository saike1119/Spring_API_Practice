package com.example.demo.service;

import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<String> getItem(String query) throws IOException, URISyntaxException {
        return itemRepository.getItem(query);
    }
}