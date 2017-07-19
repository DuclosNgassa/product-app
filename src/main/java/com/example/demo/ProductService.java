package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ndanji-ngassa on 04.07.2017.
 */
@Component
public class ProductService {
    public List<String> getProducts(){
        return Arrays.asList("iPad", "iPod", "iPhone");
    }
}
