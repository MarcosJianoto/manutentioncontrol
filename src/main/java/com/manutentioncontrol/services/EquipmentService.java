package com.manutentioncontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutentioncontrol.dto.EquipmentDTO;
import com.manutentioncontrol.entities.CategoryManutention;
import com.manutentioncontrol.entities.EquipmentEntity;
import com.manutentioncontrol.entities.PriorityEquipment;
import com.manutentioncontrol.entities.StatusEquipment;
import com.manutentioncontrol.repositories.CategoryManutentionRepository;
import com.manutentioncontrol.repositories.EquipmentRepository;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepository;
	private CategoryManutentionRepository categoryManutentionRepository;

	public EquipmentService(EquipmentRepository equipmentRepository,
			CategoryManutentionRepository categoryManutentionRepository) {
		this.equipmentRepository = equipmentRepository;
		this.categoryManutentionRepository = categoryManutentionRepository;
	}

	public void blankToNull(EquipmentDTO equipmentDTO) {
		if (equipmentDTO.getName() != null) {
			String nameEquipment = equipmentDTO.getName().trim();
			if (nameEquipment.isBlank() || nameEquipment.isEmpty()) {
				equipmentDTO.setName(null);
			}
		}
	}

	public void createEquipment(EquipmentDTO equipmentDTO) {

		/*
		 * CategoryManutention categoryManutention =
		 * categoryManutentionRepository.findById(equipmentDTO.getCategoryId())
		 * .orElseThrow(() -> new IllegalArgumentException("Category is not found!"));
		 * 
		 * EquipmentEntity equipmentEntity = new EquipmentEntity();
		 * equipmentEntity.setCategory(categoryManutention);
		 * 
		 * equipmentEntity.setName(equipmentDTO.getName());// não pode ser nulo, ja
		 * transformei em null.
		 * 
		 * equipmentEntity.setLifetime(equipmentDTO.getLifetime());// esse ainda ta
		 * incompleto, pois será inserido como // dias/mes/anos????
		 * 
		 * equipmentEntity.setLocalization(equipmentDTO.getLocalization());
		 * 
		 * equipmentEntity.setPriority(PriorityEquipment.valueOf(equipmentDTO.
		 * getPriority().toUpperCase()));
		 * equipmentEntity.setStatus(StatusEquipment.valueOf(equipmentDTO.getStatus().
		 * toUpperCase()));
		 * 
		 * equipmentEntity.setNotificationDay(equipmentDTO.getNotificationDay());
		 * 
		 * // as datas: getMaxTime e getDateLast
		 * equipmentEntity.setMaxTimeBetweenMaintenance(equipmentDTO.
		 * getMaxTimeBetweenMaintenance());
		 * equipmentEntity.setDateLastMaintenance(equipmentDTO.getDateLastMaintenance())
		 * ;
		 */
	}

}