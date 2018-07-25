package com.example.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/api")
public class HelloController {

    String appid = "dj00aiZpPTBwNlVmQ1FnSFB4aCZzPWNvbnN1bWVyc2VjcmV0Jng9ZTY-";
    String apiSample = "http://shopping.yahooapis.jp/ShoppingWebService/V1/itemSearch?appid=dj00aiZpPTBwNlVmQ1FnSFB4aCZzPWNvbnN1bWVyc2VjcmV0Jng9ZTY-&query=%E8%AE%83%E5%B2%90%E3%81%86%E3%81%A9%E3%82%93";
    String api = "";
    String query = "%E8%AE%83%E5%B2%90%E3%81%86%E3%81%A9%E3%82%93";
    String callback = "json";


    @RequestMapping(method = RequestMethod.GET)
    public JsonNode getCustomer(@RequestParam("name") String name) throws IOException {
        JsonNode root = null;
        try {
            api += "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?";
            api += "appid=" + appid;
            api += "&query=" + query;
            api += "&callback=" + callback;

            System.out.println(api);
            System.out.println(name);

            ObjectMapper mapper = new ObjectMapper();
            root = mapper.readTree(api);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return root;
    }
}
