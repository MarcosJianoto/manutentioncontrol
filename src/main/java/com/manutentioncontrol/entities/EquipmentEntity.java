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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
	@SequenceGenerator(name = "users_sequence", sequenceName = "users_sequence", allocationSize = 1)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryManutention category;

	@Column(name = "name")
	private String name;

	@Column(name = "date_hour_instalation")
	private LocalDateTime dateHourInstalation;

	@Column(name = "max_time_between_maintenance")
	private Integer maxTimeBetweenMaintenance;

	@Column(name = "lifetime")
	private Integer lifetime;

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

	public EquipmentEntity() {
		super();
	}

	public EquipmentEntity(Integer id, CategoryManutention category, String name, LocalDateTime dateHourInstalation,
			Integer maxTimeBetweenMaintenance, Integer lifetime, String localization, PriorityEquipment priority,
			StatusEquipment status, Integer notificationDay, LocalDateTime dateLastMaintenance) {
		super();
		this.id = id;
		this.category = category;
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
