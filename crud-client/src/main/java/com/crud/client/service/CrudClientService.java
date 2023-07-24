package com.crud.client.service;


import com.crud.client.entity.EntityClient;

import java.util.List;


public interface CrudClientService  {

    public List<EntityClient> findAll();
    public EntityClient findById(Long id);
    public EntityClient create(EntityClient entityClient);
    public EntityClient updateClient(EntityClient entityClient);
    public void deleteClient(Long id);
}
