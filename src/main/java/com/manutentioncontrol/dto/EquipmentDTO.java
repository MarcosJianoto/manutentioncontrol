package com.manutentioncontrol.dto;

import java.time.LocalDateTime;

import com.manutentioncontrol.entities.PriorityEquipment;
import com.manutentioncontrol.entities.StatusEquipment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EquipmentDTO {

	private Integer id;

	@NotNull(message = "Category não pode ser nulo")
	@NotBlank(message = "Category não pode ficar em branco")
	private Integer categoryId;

	@NotNull(message = "Nome não pode ser nulo")
	@NotBlank(message = "Nome não pode ficar em branco")
	private String name;

	private LocalDateTime dateHourInstalation;

	@NotNull(message = "Tempo maximo entre manutenções não pode ser nulo")
	@NotBlank(message = "Tempo maximo entre manutenções não pode ficar em branco")
	private Integer maxTimeBetweenMaintenance;

	@NotNull(message = "Tempo de vida não pode ser nulo")
	@NotBlank(message = "Tempo de vida não pode ficar em branco")
	private Integer lifetime;

	private String localization;

	private PriorityEquipment priority;

	@NotNull(message = "Status não pode ser nulo")
	@NotBlank(message = "Status não pode ficar em branco")
	private StatusEquipment status;

	private Integer notificationDay;

	@NotNull(message = "Data da ultima manutenção não pode ser nulo")
	@NotBlank(message = "Data da ultima manutenção não pode ficar em branco")
	private LocalDateTime dateLastMaintenance;

	public EquipmentDTO() {
		super();
	}

	public EquipmentDTO(Integer id, Integer categoryId, String name, LocalDateTime dateHourInstalation,
			Integer maxTimeBetweenMaintenance, Integer lifetime, String localization, PriorityEquipment priority,
			StatusEquipment status, Integer notificationDay, LocalDateTime dateLastMaintenance) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.dateHourInstalation = dateHourInstalation;
		this.maxTimeBetweenMaintenance = maxTimeBetweenMaintenance;
		this.lifetime = lifetime;
		this.localization = localization;
		this.priority = priority;
		this.status = status;
		this.notificationDay = notificationDay;
		this.dateLastMaintenance = dateLastMaintenance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDateHourInstalation() {
		return dateHourInstalation;
	}

	public void setDateHourInstalation(LocalDateTime dateHourInstalation) {
		this.dateHourInstalation = dateHourInstalation;
	}

	public Integer getMaxTimeBetweenMaintenance() {
		return maxTimeBetweenMaintenance;
	}

	public void setMaxTimeBetweenMaintenance(Integer maxTimeBetweenMaintenance) {
		this.maxTimeBetweenMaintenance = maxTimeBetweenMaintenance;
	}

	public Integer getLifetime() {
		return lifetime;
	}

	public void setLifetime(Integer lifetime) {
		this.lifetime = lifetime;
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

}
