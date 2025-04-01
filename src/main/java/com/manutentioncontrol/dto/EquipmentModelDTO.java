package com.manutentioncontrol.dto;

import java.time.LocalDateTime;

import com.manutentioncontrol.entities.CategoryManutention;
import com.manutentioncontrol.entities.LifeTimeUnit;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EquipmentModelDTO {

	private Integer id;

	@NotNull(message = "Category não pode ser nulo")
	@NotBlank(message = "Category não pode ficar em branco")
	private CategoryManutention category;

	@NotNull(message = "Name não pode ser nulo")
	@NotBlank(message = "Name não pode ficar em branco")
	private String name;

	@NotNull(message = "Tempo maximo entre manutenções não pode ser nulo")
	@NotBlank(message = "Tempo maximo entre manutenções não pode ficar em branco")
	private Integer maxTimeBetweenMaintenance;

	@NotNull(message = "Tempo de vida não pode ser nulo")
	@NotBlank(message = "Tempo de vida não pode ficar em branco")
	private Integer lifetimeValue;

	@NotNull(message = "Unidade do tempo de vida não pode ser nulo")
	@NotBlank(message = "Unidade do tempo de vid não pode ficar em branco")
	private LifeTimeUnit lifetimeUnit;

	private LocalDateTime lifetimeFixedDate;

	public EquipmentModelDTO() {
		super();
	}

	public EquipmentModelDTO(CategoryManutention category, String name, Integer maxTimeBetweenMaintenance,
			Integer lifetimeValue, LifeTimeUnit lifetimeUnit, LocalDateTime lifetimeFixedDate) {
		super();
		this.category = category;
		this.name = name;
		this.maxTimeBetweenMaintenance = maxTimeBetweenMaintenance;
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

	public CategoryManutention getCategory() {
		return category;
	}

	public void setCategory(CategoryManutention category) {
		this.category = category;
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

	public Integer getLifetimeValue() {
		return lifetimeValue;
	}

	public void setLifetimeValue(Integer lifetimeValue) {
		this.lifetimeValue = lifetimeValue;
	}

	public LifeTimeUnit getLifetimeUnit() {
		return lifetimeUnit;
	}

	public void setLifetimeUnit(LifeTimeUnit lifetimeUnit) {
		this.lifetimeUnit = lifetimeUnit;
	}

	public LocalDateTime getLifetimeFixedDate() {
		return lifetimeFixedDate;
	}

	public void setLifetimeFixedDate(LocalDateTime lifetimeFixedDate) {
		this.lifetimeFixedDate = lifetimeFixedDate;
	}

}
