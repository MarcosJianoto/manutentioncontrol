package com.manutentioncontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manutentioncontrol.entities.EquipmentModelEntity;

@Repository
public interface EquipmentModelRepository extends JpaRepository<EquipmentModelEntity, Integer> {

}
