package com.manutentioncontrol.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.manutentioncontrol.dto.EquipmentModelDTO;
import com.manutentioncontrol.entities.CategoryManutention;
import com.manutentioncontrol.entities.EquipmentModelEntity;
import com.manutentioncontrol.entities.MaintenanceUnit;
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
		return categoryManutentionRepository.findById(equipmentModelDTO.getCategoryId())
				.orElseThrow(() -> new IllegalArgumentException("Category is not found"));
	}

	public EquipmentModelEntity equipmentModelFindById(Integer id) {
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

	public EquipmentModelEntity equipmentEntitySet(EquipmentModelDTO equipmentModelDTO,
			EquipmentModelEntity existsEquipment) {

		CategoryManutention categoryManutention = categoryManutentionExists(equipmentModelDTO);

		EquipmentModelEntity equipmentModelEntity = (existsEquipment != null ? existsEquipment
				: new EquipmentModelEntity());

		if (existsEquipment != null) {
			equipmentModelEntity.setId(existsEquipment.getId());
		}

		equipmentModelEntity.setCategory(categoryManutention);
		equipmentModelEntity.setName(equipmentModelDTO.getName());
		equipmentModelEntity.setMaxTimeBetweenMaintenance(equipmentModelDTO.getMaxTimeBetweenMaintenance());
		equipmentModelEntity.setMaxTimeBetweenMaintenanceUnit(
				MaintenanceUnit.valueOf(equipmentModelDTO.getMaxTimeBetweenMaintenanceUnit().toUpperCase()));
		equipmentModelEntity.setLifetimeValue(equipmentModelDTO.getLifetimeValue());
		equipmentModelEntity
				.setLifetimeUnit(MaintenanceUnit.valueOf(equipmentModelDTO.getLifetimeUnit().toUpperCase()));

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = null;

		try {
			date = LocalDate.parse(equipmentModelDTO.getLifetimeFixedDate(), dateTimeFormatter);
			equipmentModelEntity.setLifetimeFixedDate(date);

		} catch (Exception e) {
			if (date == null) {
				equipmentModelEntity.setLifetimeFixedDate(date);
			}else {
				throw new IllegalArgumentException("Data inválida, use o formato dd/MM/yyyy");
			}
		}

		return equipmentModelEntity;
	}

	public void createEquipmentModel(EquipmentModelDTO equipmentModelDTO) {

		blankToNull(equipmentModelDTO);

		EquipmentModelEntity equipmentModelEntity = equipmentEntitySet(equipmentModelDTO, null);

		equipmentModelRepository.save(equipmentModelEntity);
	}

	public void updateEquipmentmodel(Integer id, EquipmentModelDTO equipmentModelDTO) {

		EquipmentModelEntity equipmentModelEntity = equipmentModelFindById(id);
		EquipmentModelEntity equipmentUpdate = equipmentEntitySet(equipmentModelDTO, equipmentModelEntity);

		equipmentModelRepository.save(equipmentUpdate);

	}

	public EquipmentModelDTO getEquipmentModel(Integer id) {

		EquipmentModelEntity equipmentModelEntity = equipmentModelRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Equipment Model not found"));

		EquipmentModelDTO equipmentModelDTO = new EquipmentModelDTO();
		equipmentModelDTO.setId(id);
		equipmentModelDTO.setCategoryId(equipmentModelEntity.getCategory().getId());
		equipmentModelDTO.setName(equipmentModelEntity.getName());
		equipmentModelDTO.setMaxTimeBetweenMaintenance(equipmentModelEntity.getMaxTimeBetweenMaintenance());
		equipmentModelDTO
				.setMaxTimeBetweenMaintenanceUnit(equipmentModelEntity.getMaxTimeBetweenMaintenanceUnit().toString());
		equipmentModelDTO.setLifetimeValue(equipmentModelEntity.getLifetimeValue());
		equipmentModelDTO.setLifetimeUnit(equipmentModelEntity.getLifetimeUnit().toString());
		equipmentModelDTO.setLifetimeFixedDate(equipmentModelEntity.getLifetimeFixedDate().toString());

		return equipmentModelDTO;
	}

	public List<EquipmentModelDTO> getAllEquipmentsModels() {
		return equipmentModelRepository.findAll().stream().filter(
				(eModel) -> eModel.getLifetimeFixedDate() != null && eModel.getMaxTimeBetweenMaintenanceUnit() != null)
				.map((eModel) -> new EquipmentModelDTO(eModel.getId(), eModel.getCategory().getId(), eModel.getName(),
						eModel.getMaxTimeBetweenMaintenance(), eModel.getMaxTimeBetweenMaintenanceUnit().toString(),
						eModel.getLifetimeValue(), eModel.getLifetimeUnit().toString(),
						eModel.getLifetimeFixedDate().toString()))
				.toList();
	}

	public void deleteEquipmentModel(Integer id) {
		equipmentModelFindById(id);
		equipmentModelRepository.deleteById(id);
	}

}
