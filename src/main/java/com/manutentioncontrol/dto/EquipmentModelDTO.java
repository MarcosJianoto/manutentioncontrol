package com.manutentioncontrol.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EquipmentModelDTO {

	private Integer id;

	@NotNull(message = "Category não pode ser nulo")
	@NotBlank(message = "Category não pode ficar em branco")
	private Integer categoryId;

	@NotNull(message = "Name não pode ser nulo")
	@NotBlank(message = "Name não pode ficar em branco")
	private String name;

	@NotNull(message = "Tempo maximo entre manutenções não pode ser nulo")
	@NotBlank(message = "Tempo maximo entre manutenções não pode ficar em branco")
	private Integer maxTimeBetweenMaintenance;

	@NotNull(message = "Unidade do tempo maximo entre manutenções não pode ser nulo")
	@NotBlank(message = "Unidade do tempo maximo entre manutenções não pode ficar em branco")
	private String maxTimeBetweenMaintenanceUnit;

	@NotNull(message = "Tempo de vida não pode ser nulo")
	@NotBlank(message = "Tempo de vida não pode ficar em branco")
	private Integer lifetimeValue;

	@NotNull(message = "Unidade do tempo de vida não pode ser nulo")
	@NotBlank(message = "Unidade do tempo de vid não pode ficar em branco")
	private String lifetimeUnit;

	private String lifetimeFixedDate;

	public EquipmentModelDTO() {
		super();
	}

	public EquipmentModelDTO(Integer id, Integer categoryId, String name, Integer maxTimeBetweenMaintenance,
			Integer lifetimeValue, String lifetimeUnit, String lifetimeFixedDate) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.maxTimeBetweenMaintenance = maxTimeBetweenMaintenance;
		this.lifetimeValue = lifetimeValue;
		this.lifetimeUnit = lifetimeUnit;
		this.lifetimeFixedDate = lifetimeFixedDate;
	}

	public EquipmentModelDTO(Integer categoryId, String name, Integer maxTimeBetweenMaintenance,
			String maxTimeBetweenMaintenanceUnit, Integer lifetimeValue, String lifetimeUnit,
			String lifetimeFixedDate) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.maxTimeBetweenMaintenance = maxTimeBetweenMaintenance;
		this.maxTimeBetweenMaintenanceUnit = maxTimeBetweenMaintenanceUnit;
		this.lifetimeValue = lifetimeValue;
		this.lifetimeUnit = lifetimeUnit;
		this.lifetimeFixedDate = lifetimeFixedDate;
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

	public Integer getMaxTimeBetweenMaintenance() {
		return maxTimeBetweenMaintenance;
	}

	public void setMaxTimeBetweenMaintenance(Integer maxTimeBetweenMaintenance) {
		this.maxTimeBetweenMaintenance = maxTimeBetweenMaintenance;
	}

	public String getMaxTimeBetweenMaintenanceUnit() {
		return maxTimeBetweenMaintenanceUnit;
	}

	public void setMaxTimeBetweenMaintenanceUnit(String maxTimeBetweenMaintenanceUnit) {
		this.maxTimeBetweenMaintenanceUnit = maxTimeBetweenMaintenanceUnit;
	}

	public Integer getLifetimeValue() {
		return lifetimeValue;
	}

	public void setLifetimeValue(Integer lifetimeValue) {
		this.lifetimeValue = lifetimeValue;
	}

	public String getLifetimeUnit() {
		return lifetimeUnit;
	}

	public void setLifetimeUnit(String string) {
		this.lifetimeUnit = string;
	}

	public String getLifetimeFixedDate() {
		return lifetimeFixedDate;
	}

	public void setLifetimeFixedDate(String lifetimeFixedDate) {
		this.lifetimeFixedDate = lifetimeFixedDate;
	}

}
