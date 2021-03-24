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


@RestController
public class RestControllers {
    @Autowired
    QueryService service;

    @PostMapping("/search")
    public ResponseEntity<Query> getUserById(@RequestBody Query query) throws IOException {
        String mess = service.parsing(query.getQuery());
        Query query1 = new Query();
        query1.setQuery(mess);
        return new ResponseEntity<Query>(query1, HttpStatus.OK);
    }
}
