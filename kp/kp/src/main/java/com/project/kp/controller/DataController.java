package com.project.kp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.kp.dto.MyDataDto;
import com.project.kp.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @Autowired
    private DataService dataService;
    @PostMapping("/sendData")
    public ResponseEntity<String> getData(@RequestBody MyDataDto myDatadto) throws JsonProcessingException {
        dataService.sendData(myDatadto);
        return new ResponseEntity<>("Update sent successfully", HttpStatus.OK);
    }
}
