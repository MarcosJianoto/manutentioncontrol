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
@Table(name = "history_manutentions")
public class HistoryManutentions {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_manutentions_sequence")
	@SequenceGenerator(name = "history_manutentions_sequence", sequenceName = "history_manutentions_sequence", allocationSize = 1)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private EquipmentEntity equipment;

	@Column(name = "date")
	private LocalDate date;

	@Enumerated(EnumType.STRING)
	@Column(name = "type_manutention")
	private TypeManutention typeManutention;

	public HistoryManutentions() {
		super();
	}

	public HistoryManutentions(EquipmentEntity equipment, LocalDate date, TypeManutention typeManutention) {
		super();
		this.equipment = equipment;
		this.date = date;
		this.typeManutention = typeManutention;
	}

	public HistoryManutentions(Integer id, EquipmentEntity equipment, LocalDate date, TypeManutention typeManutention) {
		super();
		this.id = id;
		this.equipment = equipment;
		this.date = date;
		this.typeManutention = typeManutention;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EquipmentEntity getEquipment() {
		return equipment;
	}

	public void setEquipment(EquipmentEntity equipment) {
		this.equipment = equipment;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public TypeManutention getTypeManutention() {
		return typeManutention;
	}

	public void setTypeManutention(TypeManutention typeManutention) {
		this.typeManutention = typeManutention;
	}

}
