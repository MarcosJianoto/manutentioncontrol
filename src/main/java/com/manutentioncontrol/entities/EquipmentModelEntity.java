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
@Table(name = "equipment_model")
public class EquipmentModelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipment_model_sequence")
	@SequenceGenerator(name = "equipment_model_sequence", sequenceName = "equipment_model_sequence", allocationSize = 1)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryManutention category;

	@Column(name = "name")
	private String name;

	@Column(name = "max_time_between_maintenance")
	private Integer maxTimeBetweenMaintenance;

	@Column(name = "lifetime_value")
	private Integer lifetimeValue;

	@Column(name = "lifetime_unit")
	private LifeTimeUnit lifetimeUnit;

	@Column(name = "lifetime_fixed_date")
	private LocalDateTime lifetimeFixedDate;

	public EquipmentModelEntity() {
		super();
	}

	public EquipmentModelEntity(CategoryManutention category, String name, Integer maxTimeBetweenMaintenance,
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
