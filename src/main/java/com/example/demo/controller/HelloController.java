package com.example.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

@RestController
@RequestMapping(path = "/api")
public class HelloController {

    String baseUrl = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch";
    URL url;

    @RequestMapping(method = RequestMethod.GET)
    public JsonNode getCustomer(@RequestParam("name") String name) throws IOException, URISyntaxException {

        ObjectMapper mapper = new ObjectMapper();

        url = new URIBuilder(baseUrl)
                .setParameter("appid", "dj00aiZpPTBwNlVmQ1FnSFB4aCZzPWNvbnN1bWVyc2VjcmV0Jng9ZTY-")
                .setParameter("query", "%E8%AE%83%E5%B2%90%E3%81%86%E3%81%A9%E3%82%93")
                .build().toURL();

        JsonNode root = mapper.readTree(url);

        return root;
    }
}
