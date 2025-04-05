package com.manutentioncontrol.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manutentioncontrol.dto.HistoryManutentionsDTO;
import com.manutentioncontrol.services.HistoryManutentionsService;

@RestController
@RequestMapping("/history")
public class HistoryManutentionsController {
	private final HistoryManutentionsService historyManutentionsService;

	public HistoryManutentionsController(HistoryManutentionsService historyManutentionsService) {
		this.historyManutentionsService = historyManutentionsService;
	}

	@PostMapping
	public ResponseEntity<Void> createHistory(@RequestBody HistoryManutentionsDTO historyDTO) {
		historyManutentionsService.saveHistoryManutention(historyDTO);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateHistory(@PathVariable Integer id,
			@RequestBody HistoryManutentionsDTO historyDTO) {
		return ResponseEntity.status(501).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<HistoryManutentionsDTO> getHistory(@PathVariable Integer id) {
		HistoryManutentionsDTO dto = historyManutentionsService.getHistoryById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping
	public ResponseEntity<List<HistoryManutentionsDTO>> getAllHistories() {
		List<HistoryManutentionsDTO> list = historyManutentionsService.getHistorys();
		return ResponseEntity.ok(list);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteHistory(@PathVariable Integer id) {
		historyManutentionsService.deleteHistoryManutention(id);
		return ResponseEntity.noContent().build();
	}
}
