package com.manutentioncontrol.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.manutentioncontrol.dto.EquipmentDTO;
import com.manutentioncontrol.entities.EquipmentEntity;
import com.manutentioncontrol.entities.EquipmentModelEntity;
import com.manutentioncontrol.entities.PriorityEquipment;
import com.manutentioncontrol.entities.StatusEquipment;
import com.manutentioncontrol.repositories.EquipmentModelRepository;
import com.manutentioncontrol.repositories.EquipmentRepository;

@Service
public class EquipmentService {

	private EquipmentRepository equipmentRepository;
	private EquipmentModelRepository equipmentModelRepository;

	public EquipmentService(EquipmentRepository equipmentRepository,
			EquipmentModelRepository equipmentModelRepository) {
		this.equipmentRepository = equipmentRepository;
		this.equipmentModelRepository = equipmentModelRepository;
	}

	public EquipmentModelEntity equipmentModelFindById(EquipmentDTO equipmentDTO) {
		return equipmentModelRepository.findById(equipmentDTO.getEquipmentModel())
				.orElseThrow(() -> new IllegalArgumentException("Equipment Model not found"));
	}

	public EquipmentEntity equipmentFindById(Integer id) {
		return equipmentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Equipment Model not found"));
	}

	public EquipmentEntity equipmentDTOtoEntity(EquipmentDTO equipmentDTO, EquipmentEntity existEntity) {

		EquipmentModelEntity equipmentModelEntity = equipmentModelFindById(equipmentDTO);

		EquipmentEntity equipmentEntity = (existEntity != null) ? existEntity : new EquipmentEntity();

		equipmentEntity.setEquipmentModel(equipmentModelEntity);
		equipmentEntity.setLocalization(equipmentDTO.getLocalization());
		equipmentEntity.setPriority(PriorityEquipment.valueOf(equipmentDTO.getPriority()));
		equipmentEntity.setStatus(StatusEquipment.valueOf(equipmentDTO.getStatus()));
		equipmentEntity.setNotificationDay(equipmentDTO.getNotificationDay());

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		if (equipmentDTO.getDateLastMaintenance() == null) {
			equipmentEntity.setDateLastMaintenance(LocalDate.now());
		} else {
			equipmentEntity
					.setDateLastMaintenance(LocalDate.parse(equipmentDTO.getDateLastMaintenance(), dateTimeFormatter));
		}

		try {
			equipmentEntity
					.setNextMaintenanceDate(LocalDate.parse(equipmentDTO.getNextMaintenanceDate(), dateTimeFormatter));

		} catch (Exception e) {
			new IllegalArgumentException("Data da próxima manutenção não pode ser nula");
			e.getMessage();
		}

		return equipmentEntity;

	}

	public void createEquipment(EquipmentDTO equipmentDTO) {
		EquipmentEntity equipmentEntity = equipmentDTOtoEntity(equipmentDTO, null);
		equipmentRepository.save(equipmentEntity);
	}

	public void updateEquipment(Integer id, EquipmentDTO equipmentDTO) {

		EquipmentEntity equipmentEntity = equipmentFindById(id);

		EquipmentEntity equipmentEntityToDTO = equipmentDTOtoEntity(equipmentDTO, equipmentEntity);

		equipmentRepository.save(equipmentEntityToDTO);
	}

}