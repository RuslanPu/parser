package parser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import parser.model.Query;
import parser.service.QueryService;

import java.io.IOException;
import java.util.ArrayList;


@RestController
public class RestControllers {
    @Autowired
    QueryService service;

    @PostMapping("/search")
    public ResponseEntity<ArrayList<String>> getUserById(@RequestBody Query query) throws IOException {
        ArrayList<String> arr = new ArrayList<>();

        arr = service.parsingList(query.getQuery());

        return new ResponseEntity<ArrayList<String>>(arr, HttpStatus.OK);
    }
}
