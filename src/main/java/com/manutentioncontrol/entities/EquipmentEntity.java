package com.manutentioncontrol.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	private PriorityEquipment priority;

	@Column(name = "status")
	private StatusEquipment status;

	@Column(name = "notification_days")
	private Integer notificationDay;

	@Column(name = "last_maintenance_date")
	private LocalDateTime dateLastMaintenance;

	@Column(name = "next_maintenance_date")
	private LocalDateTime nextMaintenanceDate;

	public EquipmentEntity() {
	}

	public EquipmentEntity(EquipmentModelEntity equipmentModel, String localization, PriorityEquipment priority,
			StatusEquipment status, Integer notificationDay, LocalDateTime dateLastMaintenance,
			LocalDateTime nextMaintenanceDate) {
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

	public LocalDateTime getDateLastMaintenance() {
		return dateLastMaintenance;
	}

	public void setDateLastMaintenance(LocalDateTime dateLastMaintenance) {
		this.dateLastMaintenance = dateLastMaintenance;
	}

	public LocalDateTime getNextMaintenanceDate() {
		return nextMaintenanceDate;
	}

	public void setNextMaintenanceDate(LocalDateTime nextMaintenanceDate) {
		this.nextMaintenanceDate = nextMaintenanceDate;
	}

}
