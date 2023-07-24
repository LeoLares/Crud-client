package com.crud.client.repository;

import com.crud.client.entity.EntityClient;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<EntityClient,Long> {
}
