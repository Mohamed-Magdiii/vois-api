package com.api.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.api.model.Inventory;
import com.api.api.services.InventoryService;

@RestController
@RequestMapping("/inventory")

public class InventoryController {

	@Autowired
	private InventoryService service;

	@PostMapping
	public Inventory createInventory(@RequestBody Inventory inventory) {
		Inventory result = service.saveInventory(inventory);
		return result;

	}

	@GetMapping

	public List<Inventory> getAllInventoryMeetsStandard() {
		List<Inventory> result = service.getAllInventoriesByTempAndStatus();
		return result;

	}

//	@GetMapping("/{id}")
//	public Inventory getInventoryById(@PathVariable String id) {
//		return service.getInventoryById(id);
//	}

	@DeleteMapping("/{id}")
	public String deleteInventoryById(@PathVariable String id) {

		return service.deleteInventoryById(id);

	}

	@PutMapping("/{id}")
	public Inventory DeviceConfiguration(@PathVariable("id") String id) {
		return service.updateInventory(id);

	}
}
