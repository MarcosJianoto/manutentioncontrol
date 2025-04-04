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

import com.manutentioncontrol.dto.EquipmentDTO;
import com.manutentioncontrol.services.EquipmentService;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

	private EquipmentService equipmentService;

	public EquipmentController(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	};

	@PostMapping
	public ResponseEntity<Void> createEquipment(@RequestBody EquipmentDTO equipmentDTO) {
		equipmentService.createEquipment(equipmentDTO);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateEquipment(@PathVariable Integer id, @RequestBody EquipmentDTO equipmentDTO) {
		equipmentService.updateEquipment(id, equipmentDTO);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<EquipmentDTO> getEquipment(@PathVariable Integer id) {
		EquipmentDTO equipmentDTO = equipmentService.getEquipment(id);
		return ResponseEntity.ok().body(equipmentDTO);
	}

	@GetMapping
	public ResponseEntity<List<EquipmentDTO>> getAllEquipments() {
		List<EquipmentDTO> findAllEquipments = equipmentService.getEquipments();
		return ResponseEntity.ok().body(findAllEquipments);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEquipment(@PathVariable Integer id) {
		equipmentService.deleteEquipment(id);
		return ResponseEntity.noContent().build();
	}
}
