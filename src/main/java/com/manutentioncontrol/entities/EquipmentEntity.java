package com.manutentioncontrol.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipment")
public class EquipmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipment_sequence")
	@SequenceGenerator(name = "equipment_sequence", sequenceName = "equipment_sequence", allocationSize = 1)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "equipment_model_id")
	private EquipmentModelEntity equipmentModel;

	@Column(name = "localization")
	private String localization;

	@Column(name = "priority")
	@Enumerated(EnumType.STRING)
	private PriorityEquipment priority;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private StatusEquipment status;

	@Column(name = "notification_days")
	private Integer notificationDay;

	@Column(name = "last_maintenance_date")
	private LocalDate dateLastMaintenance;

	@Column(name = "next_maintenance_date")
	private LocalDate nextMaintenanceDate;

	public EquipmentEntity() {
	}

	public EquipmentEntity(EquipmentModelEntity equipmentModel, String localization, PriorityEquipment priority,
			StatusEquipment status, Integer notificationDay, LocalDate dateLastMaintenance,
			LocalDate nextMaintenanceDate) {
		this.equipmentModel = equipmentModel;
		this.localization = localization;
		this.priority = priority;
		this.status = status;
		this.notificationDay = notificationDay;
		this.dateLastMaintenance = dateLastMaintenance;
		this.nextMaintenanceDate = nextMaintenanceDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EquipmentModelEntity getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(EquipmentModelEntity equipmentModelId) {
		this.equipmentModel = equipmentModelId;
	}

	public String getLocalization() {
		return localization;
	}

	public void setLocalization(String localization) {
		this.localization = localization;
	}

	public PriorityEquipment getPriority() {
		return priority;
	}

	public void setPriority(PriorityEquipment priority) {
		this.priority = priority;
	}

	public StatusEquipment getStatus() {
		return status;
	}

	public void setStatus(StatusEquipment status) {
		this.status = status;
	}

	public Integer getNotificationDay() {
		return notificationDay;
	}

	public void setNotificationDay(Integer notificationDay) {
		this.notificationDay = notificationDay;
	}

	public LocalDate getDateLastMaintenance() {
		return dateLastMaintenance;
	}

	public void setDateLastMaintenance(LocalDate dateLastMaintenance) {
		this.dateLastMaintenance = dateLastMaintenance;
	}

	public LocalDate getNextMaintenanceDate() {
		return nextMaintenanceDate;
	}

	public void setNextMaintenanceDate(LocalDate nextMaintenanceDate) {
		this.nextMaintenanceDate = nextMaintenanceDate;
	}

}
