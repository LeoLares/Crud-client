package com.crud.client.controller;


import com.crud.client.entity.EntityClient;
import com.crud.client.service.CrudClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    CrudClientService crudClientService;

    @GetMapping("/findAllClient")
    public List<EntityClient> findAllClient(){
        return crudClientService.findAll();
    }

    @GetMapping("/findClientId/{id}")
    public EntityClient findById(@PathVariable Long id){
        return crudClientService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createClient")
    public EntityClient createClient(@RequestBody  EntityClient entityClient){
        return crudClientService.create(entityClient);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/updateClient/{id}")
    public ResponseEntity<EntityClient> updateClient(@RequestBody EntityClient entityClient, @PathVariable Long id){
        EntityClient entityClientDB = crudClientService.findById(id);
        if (entityClientDB == null){
            return ResponseEntity.notFound().build();
        }
        entityClientDB.setUsername(entityClient.getUsername());
        crudClientService.create(entityClient);
        return ResponseEntity.ok(entityClientDB);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable Long id){
        crudClientService.deleteClient(id);
    }
}
