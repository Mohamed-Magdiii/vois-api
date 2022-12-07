package com.api.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.api.model.Inventory;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {
	@Query("{$or : [ {status:'ACTIVE'} , {temperature : {gte : 0, lte:10} }] }")
	List<Inventory> findDevicesMeetsUk();
}
