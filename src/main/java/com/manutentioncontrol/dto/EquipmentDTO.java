package com.manutentioncontrol.dto;

import java.time.LocalDateTime;

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

	private String dateHourInstalation;

	@NotNull(message = "Tempo maximo entre manutenções não pode ser nulo")
	@NotBlank(message = "Tempo maximo entre manutenções não pode ficar em branco")
	private Integer maxTimeBetweenMaintenance;

	@NotNull(message = "Tempo de vida não pode ser nulo")
	@NotBlank(message = "Tempo de vida não pode ficar em branco")
	private Integer lifetime;

	private String localization;

	private String priority;

	@NotNull(message = "Status não pode ser nulo")
	@NotBlank(message = "Status não pode ficar em branco")
	private String status;

	private Integer notificationDay;

	@NotNull(message = "Data da ultima manutenção não pode ser nulo")
	@NotBlank(message = "Data da ultima manutenção não pode ficar em branco")
	private String dateLastMaintenance;

	public EquipmentDTO() {
		super();
	}

	public EquipmentDTO(Integer id, Integer categoryId, String name, String dateHourInstalation,
			Integer maxTimeBetweenMaintenance, Integer lifetime, String localization, String priority,
			String status, Integer notificationDay, String dateLastMaintenance) {
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

	public String getDateHourInstalation() {
		return dateHourInstalation;
	}

	public void setDateHourInstalation(String dateHourInstalation) {
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

	public String getDateLastMaintenance() {
		return dateLastMaintenance;
	}

	public void setDateLastMaintenance(String dateLastMaintenance) {
		this.dateLastMaintenance = dateLastMaintenance;
	}

}
