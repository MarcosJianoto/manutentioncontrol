package com.manutentioncontrol.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class HistoryManutentionsDTO {

	private Integer id;

	@NotNull(message = "Equipamento não pode ser nulo")
	@NotBlank(message = "Equipamento não pode ficar em branco")
	private Integer equipment;

	private String date;

	private String typeManutention;

	public HistoryManutentionsDTO() {
		super();
	}

	public HistoryManutentionsDTO(Integer equipment, String date, String typeManutention) {
		super();
		this.equipment = equipment;
		this.date = date;
		this.typeManutention = typeManutention;
	}

	public HistoryManutentionsDTO(Integer id, Integer equipment, String date, String typeManutention) {
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

	public Integer getEquipment() {
		return equipment;
	}

	public void setEquipment(Integer equipment) {
		this.equipment = equipment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTypeManutention() {
		return typeManutention;
	}

	public void setTypeManutention(String typeManutention) {
		this.typeManutention = typeManutention;
	}

}
