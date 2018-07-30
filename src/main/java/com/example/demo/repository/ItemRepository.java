package com.example.demo.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

    List<String> itemList = new ArrayList<String>();

    String baseUrl = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch";
    URL url;

    public List<String> getItem(String query) throws URISyntaxException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        String y = null;

        //APIを叩くURLを作成
        url = new URIBuilder(baseUrl)
                .setParameter("appid", "dj00aiZpPTBwNlVmQ1FnSFB4aCZzPWNvbnN1bWVyc2VjcmV0Jng9ZTY-")
                .setParameter("query", query)
                .build().toURL();

        JsonNode root = mapper.readTree(url);
        System.out.println(root);
        JsonNode result = root.get("ResultSet").get("0").get("Result");

        for (int i = 0;i<10;i++){
            itemList.add(result.get(String.valueOf(i)).get("Name").toString());

        }

        return itemList;
    }
}
