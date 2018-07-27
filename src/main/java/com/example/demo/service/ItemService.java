package com.example.demo.service;

import com.example.demo.repository.ItemRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public JsonNode getItem(String query) throws IOException, URISyntaxException {
        return itemRepository.getItem(query);
    }
}