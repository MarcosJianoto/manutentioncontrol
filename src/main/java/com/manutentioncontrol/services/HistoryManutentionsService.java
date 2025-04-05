package com.manutentioncontrol.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.manutentioncontrol.dto.HistoryManutentionsDTO;
import com.manutentioncontrol.entities.EquipmentEntity;
import com.manutentioncontrol.entities.HistoryManutentions;
import com.manutentioncontrol.entities.TypeManutention;
import com.manutentioncontrol.repositories.EquipmentRepository;
import com.manutentioncontrol.repositories.HistoryManutentionsRepository;

@Service
public class HistoryManutentionsService {

	private HistoryManutentionsRepository historyManutentionsRepository;
	private EquipmentRepository equipmentRepository;
	private EquipmentService equipmentService;

	public HistoryManutentionsService(HistoryManutentionsRepository historyManutentionsRepository,
			EquipmentRepository equipmentRepository, EquipmentService equipmentService) {
		this.historyManutentionsRepository = historyManutentionsRepository;
		this.equipmentRepository = equipmentRepository;
		this.equipmentService = equipmentService;
	}

	public HistoryManutentions historyFindById(Integer id) {

		return historyManutentionsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Histórico não encontrado"));

	}

	public EquipmentEntity equipmentFindById(Integer equipmentId) {

		return equipmentRepository.findById(equipmentId)
				.orElseThrow(() -> new IllegalArgumentException("Equipamento não encontrado"));

	}

	public void saveHistoryManutention(HistoryManutentionsDTO historyManutentionsDTO) {

		EquipmentEntity equipmentEntity = equipmentFindById(historyManutentionsDTO.getEquipment());
		TypeManutention typeManutention = TypeManutention.valueOf(historyManutentionsDTO.getTypeManutention());
		HistoryManutentions historyManutentions = new HistoryManutentions(equipmentEntity, LocalDate.now(),
				typeManutention);
		
		historyManutentionsRepository.save(historyManutentions);

		equipmentService.updateEquipmentFromHistory(equipmentEntity);

		equipmentRepository.save(equipmentEntity);

	}

	public HistoryManutentionsDTO getHistoryById(Integer id) {
		HistoryManutentions historyManutentions = historyFindById(id);
		EquipmentEntity equipmentEntity = equipmentFindById(historyManutentions.getEquipment().getId());

		return new HistoryManutentionsDTO(historyManutentions.getId(), equipmentEntity.getId(),
				historyManutentions.getDate().toString(), historyManutentions.getTypeManutention().toString());
	}

	public List<HistoryManutentionsDTO> getHistorys() {
		return historyManutentionsRepository.findAll().stream()
				.map(history -> new HistoryManutentionsDTO(history.getId(), history.getEquipment().getId(),
						history.getDate().toString(), history.getTypeManutention().toString()))
				.toList();
	}

	public void deleteHistoryManutention(Integer id) {
		historyFindById(id);
		historyManutentionsRepository.deleteById(id);

	}

}