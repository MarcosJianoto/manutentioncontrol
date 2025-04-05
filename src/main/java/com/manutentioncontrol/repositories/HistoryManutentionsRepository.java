package com.manutentioncontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manutentioncontrol.entities.HistoryManutentions;

@Repository
public interface HistoryManutentionsRepository extends JpaRepository<HistoryManutentions, Integer> {

}
