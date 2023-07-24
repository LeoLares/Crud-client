package com.crud.client.service;

import com.crud.client.entity.EntityClient;
import com.crud.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CrudClientImpl implements CrudClientService{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<EntityClient> findAll() {
        return (List<EntityClient>) clientRepository.findAll();
    }

    @Override
    public EntityClient findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public EntityClient create(EntityClient entityClient) {
        entityClient.setCreateAt(new Date());
        entityClient.setLastupdate(new Date());
        return clientRepository.save(entityClient);
    }

    @Override
    public EntityClient updateClient(EntityClient entityClient) {

        entityClient.setLastupdate(new Date());
        return clientRepository.save(entityClient);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
