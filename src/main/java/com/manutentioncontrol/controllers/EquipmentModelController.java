package com.manutentioncontrol.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manutentioncontrol.dto.EquipmentModelDTO;
import com.manutentioncontrol.services.EquipmentModelService;

@RestController
@RequestMapping("/equipmentmodels")
public class EquipmentModelController {

	private EquipmentModelService equipmentModelService;

	public EquipmentModelController(EquipmentModelService equipmentModelService) {
		this.equipmentModelService = equipmentModelService;
	}

	@PostMapping
	public ResponseEntity<Void> createEquipmentModel(@RequestBody EquipmentModelDTO equipmentModelDTO) {
		equipmentModelService.createEquipmentModel(equipmentModelDTO);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateEquipmentModel(@PathVariable Integer id,
			@RequestBody EquipmentModelDTO equipmentModelDTO) {
		equipmentModelService.updateEquipmentmodel(id, equipmentModelDTO);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<EquipmentModelDTO> getEquipmentModel(@PathVariable Integer id) {
		EquipmentModelDTO equipmentModelDTO = equipmentModelService.getEquipmentModel(id);
		return ResponseEntity.ok().body(equipmentModelDTO);
	}

	@GetMapping
	public ResponseEntity<List<EquipmentModelDTO>> getAllEquipments() {
		List<EquipmentModelDTO> findAllEquipments = equipmentModelService.getAllEquipmentsModels();
		return ResponseEntity.ok().body(findAllEquipments);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEquipmentModel(@PathVariable Integer id) {
		equipmentModelService.deleteEquipmentModel(id);
		return ResponseEntity.noContent().build();
	}
}
