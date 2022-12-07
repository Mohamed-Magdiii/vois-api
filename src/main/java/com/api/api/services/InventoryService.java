package com.api.api.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.model.Inventory;
import com.api.api.repository.InventoryRepository;
import com.api.api.utils.General;

@Service
public class InventoryService {
	@Autowired
	private InventoryRepository repository;

	@Autowired
	private General gneral;

	public Inventory saveInventory(Inventory inventory) {
		inventory.setPinCode(gneral.generateRandomPinCode());
		inventory.setCreatedAt(new Date(System.currentTimeMillis()));
		inventory.setUpdatedAt(new Date(System.currentTimeMillis()));
		return repository.save(inventory);
	}

	public List<Inventory> getAllInventoriesByTempAndStatus() {
		return repository.findDevicesMeetsUk();
	}

	public Inventory getInventoryById(String deviceId) {
		Inventory result = repository.findById(deviceId).get();
		return result;
	}

	public Inventory updateInventory(String id) {
		Inventory rec = repository.findById(id).get();
		if (rec.getStatus().equals("ACTIVE")) {
			return rec;
		} else {
			rec.setStatus("ACTIVE");
			rec.setTemprature(gneral.generateRandomTemp(0, 10));
			return repository.save(rec);
		}
	}

	public String deleteInventoryById(String deviceId) {
		repository.deleteById(deviceId);
		return "Device is deleted succesfull";
	}
}
