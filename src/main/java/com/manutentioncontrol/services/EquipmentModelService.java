package com.manutentioncontrol.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutentioncontrol.dto.EquipmentDTO;
import com.manutentioncontrol.dto.EquipmentModelDTO;
import com.manutentioncontrol.entities.CategoryManutention;
import com.manutentioncontrol.entities.EquipmentModelEntity;
import com.manutentioncontrol.entities.Unit;
import com.manutentioncontrol.repositories.CategoryManutentionRepository;
import com.manutentioncontrol.repositories.EquipmentModelRepository;

@Service
public class EquipmentModelService {

	@Autowired
	private EquipmentModelRepository equipmentModelRepository;
	private CategoryManutentionRepository categoryManutentionRepository;

	public EquipmentModelService(EquipmentModelRepository equipmentModelRepository,
			CategoryManutentionRepository categoryManutentionRepository) {
		this.equipmentModelRepository = equipmentModelRepository;
		this.categoryManutentionRepository = categoryManutentionRepository;
	}

	public void blankToNull(EquipmentModelDTO equipmentModel) {
		if (equipmentModel.getName() != null || equipmentModel.getLifetimeFixedDate() != null) {
			String nameEquipment = equipmentModel.getName().trim();
			String lifeTimeFixedDate = equipmentModel.getLifetimeFixedDate().toString();
			if (nameEquipment.isBlank() || nameEquipment.isEmpty()) {
				equipmentModel.setName(null);
			}
			if (lifeTimeFixedDate.isBlank() || lifeTimeFixedDate.isEmpty()) {
				equipmentModel.setLifetimeFixedDate(null);
			}
		}
	}

	public void createEquipmentModel(EquipmentModelDTO equipmentModelDTO) {

		blankToNull(equipmentModelDTO);

		CategoryManutention categoryManutention = categoryManutentionRepository
				.findById(equipmentModelDTO.getCategory().getId())
				.orElseThrow(() -> new IllegalArgumentException("Category is not found"));

		EquipmentModelEntity equipmentModelEntity = new EquipmentModelEntity();
		equipmentModelEntity.setCategory(categoryManutention);
		equipmentModelEntity.setName(equipmentModelDTO.getName());
		equipmentModelEntity.setMaxTimeBetweenMaintenance(equipmentModelDTO.getMaxTimeBetweenMaintenance());
		equipmentModelEntity.setMaxTimeBetweenMaintenanceUnit(
				Unit.valueOf(equipmentModelDTO.getMaxTimeBetweenMaintenanceUnit().toUpperCase()));
		equipmentModelEntity.setLifetimeValue(equipmentModelDTO.getLifetimeValue());
		equipmentModelEntity
				.setLifetimeUnit(Unit.valueOf(equipmentModelDTO.getMaxTimeBetweenMaintenanceUnit().toUpperCase()));
		
		//abaixo é uma data, vai dar trabalho pra colocar...
		equipmentModelEntity.setLifetimeFixedDate();

	}

}
