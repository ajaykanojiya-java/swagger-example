package com.ajayonjava.swaggerexample.controller;

import com.ajayonjava.swaggerexample.models.Contact;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class AddressController {

    ConcurrentHashMap<String,Contact> contacts = new ConcurrentHashMap<>();

    @GetMapping("/{id}")
    @ApiOperation(value ="Find contact by Id",
                  notes = "Provide an Id to lookup specific contact from the Address Book",
                  response = Contact.class)
    public Contact getContact(@ApiParam(value="Id for which contact needs to retrived", required=true)
            @PathVariable String id){
        return contacts.get(id);
    }

    @GetMapping("/")
    public List<Contact> getAllContact(){
        return new ArrayList<>(contacts.values());
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact){
        contacts.put(contact.getId(),contact);
        return contact;
    }
}
