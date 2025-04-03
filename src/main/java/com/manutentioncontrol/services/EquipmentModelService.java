package com.manutentioncontrol.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutentioncontrol.dto.EquipmentModelDTO;
import com.manutentioncontrol.entities.CategoryManutention;
import com.manutentioncontrol.entities.EquipmentModelEntity;
import com.manutentioncontrol.entities.Unit;
import com.manutentioncontrol.repositories.CategoryManutentionRepository;
import com.manutentioncontrol.repositories.EquipmentModelRepository;

@Service
public class EquipmentModelService {

	private EquipmentModelRepository equipmentModelRepository;
	private CategoryManutentionRepository categoryManutentionRepository;

	public EquipmentModelService(EquipmentModelRepository equipmentModelRepository,
			CategoryManutentionRepository categoryManutentionRepository) {
		this.equipmentModelRepository = equipmentModelRepository;
		this.categoryManutentionRepository = categoryManutentionRepository;
	}

	public CategoryManutention categoryManutentionExists(EquipmentModelDTO equipmentModelDTO) {
		return categoryManutentionRepository.findById(equipmentModelDTO.getCategory().getId())
				.orElseThrow(() -> new IllegalArgumentException("Category is not found"));
	}

	public EquipmentModelEntity equipmentModelFindById(Integer id, EquipmentModelDTO equipmentModelDTO) {
		return equipmentModelRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Equipment Model not found"));

	}

	public void blankToNull(EquipmentModelDTO equipmentModel) {
		if (equipmentModel.getName() != null) {
			String nameEquipment = equipmentModel.getName().trim();

			if (nameEquipment.isBlank() || nameEquipment.isEmpty()) {
				equipmentModel.setName(null);
			}

		}

		if (equipmentModel.getLifetimeFixedDate() != null) {
			String lifeTimeFixedDate = equipmentModel.getLifetimeFixedDate().toString();
			lifeTimeFixedDate = lifeTimeFixedDate.trim();

			if (lifeTimeFixedDate.isBlank() || lifeTimeFixedDate.isEmpty()) {
				equipmentModel.setLifetimeFixedDate(null);
			}
		}
	}

	public EquipmentModelEntity equipmentEntitySet(EquipmentModelDTO equipmentModelDTO) {

		CategoryManutention categoryManutention = categoryManutentionExists(equipmentModelDTO);

		EquipmentModelEntity equipmentModelEntity = new EquipmentModelEntity();
		equipmentModelEntity.setCategory(categoryManutention);
		equipmentModelEntity.setName(equipmentModelDTO.getName());
		equipmentModelEntity.setMaxTimeBetweenMaintenance(equipmentModelDTO.getMaxTimeBetweenMaintenance());
		equipmentModelEntity.setMaxTimeBetweenMaintenanceUnit(
				Unit.valueOf(equipmentModelDTO.getMaxTimeBetweenMaintenanceUnit().toUpperCase()));
		equipmentModelEntity.setLifetimeValue(equipmentModelDTO.getLifetimeValue());
		equipmentModelEntity
				.setLifetimeUnit(Unit.valueOf(equipmentModelDTO.getMaxTimeBetweenMaintenanceUnit().toUpperCase()));

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = null;

		try {
			date = LocalDate.parse(equipmentModelDTO.getLifetimeFixedDate(), dateTimeFormatter);
		} catch (Exception e) {
			if (date == null) {
				date = LocalDate.parse("01/01/1970", dateTimeFormatter);
			}
			System.out.println(e.getMessage());
		}

		equipmentModelEntity.setLifetimeFixedDate(date);

		return equipmentModelEntity;
	}

	public void createEquipmentModel(EquipmentModelDTO equipmentModelDTO) {

		blankToNull(equipmentModelDTO);

		EquipmentModelEntity equipmentModelEntity = equipmentEntitySet(equipmentModelDTO);

		equipmentModelRepository.save(equipmentModelEntity);
	}

	public void updateEquipmentmodel(Integer id, EquipmentModelDTO equipmentModelDTO) {

		equipmentModelFindById(id, equipmentModelDTO);

		EquipmentModelEntity equipmentModelEntity = equipmentEntitySet(equipmentModelDTO);

		equipmentModelRepository.save(equipmentModelEntity);

	}
	
	
	

	public void deleteEquipmentModel(Integer id) {
		equipmentModelRepository.deleteById(id);
	}

}
