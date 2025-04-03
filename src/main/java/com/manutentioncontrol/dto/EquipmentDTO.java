package com.manutentioncontrol.dto;

import java.time.LocalDateTime;

import com.manutentioncontrol.entities.EquipmentModelEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EquipmentDTO {

	private Integer id;

	@NotNull(message = "EquipmentModel não pode ser nulo")
	@NotBlank(message = "EquipmentModel não pode ficar em branco")
	private EquipmentModelEntity equipmentModel;

	private String localization;

	private String priority;

	@NotNull(message = "Status não pode ser nulo")
	@NotBlank(message = "Status não pode ficar em branco")
	private String status;

	@NotNull(message = "NotificationDay não pode ser nulo")
	@NotBlank(message = "NotificationDay não pode ficar em branco")
	private Integer notificationDay;

	@NotNull(message = "Data ultima manutenção não pode ser nulo")
	@NotBlank(message = "Data ultima manutenção não pode ficar em branco")
	private LocalDateTime dateLastMaintenance;

	@NotNull(message = "Data próxima manutenção não pode ser nulo")
	@NotBlank(message = "Data próxima manutenção não pode ficar em branco")
	private LocalDateTime nextMaintenanceDate;

	public EquipmentDTO() {
	}

	public EquipmentDTO(
			@NotNull(message = "EquipmentModel não pode ser nulo") @NotBlank(message = "EquipmentModel não pode ficar em branco") EquipmentModelEntity equipmentModel,
			String localization, String priority,
			@NotNull(message = "Status não pode ser nulo") @NotBlank(message = "Status não pode ficar em branco") String status,
			@NotNull(message = "NotificationDay não pode ser nulo") @NotBlank(message = "NotificationDay não pode ficar em branco") Integer notificationDay,
			@NotNull(message = "Data ultima manutenção não pode ser nulo") @NotBlank(message = "Data ultima manutenção não pode ficar em branco") LocalDateTime dateLastMaintenance,
			@NotNull(message = "Data próxima manutenção não pode ser nulo") @NotBlank(message = "Data próxima manutenção não pode ficar em branco") LocalDateTime nextMaintenanceDate) {
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

	public void setEquipmentModel(EquipmentModelEntity equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public String getLocalization() {
		return localization;
	}

	public void setLocalization(String localization) {
		this.localization = localization;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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
