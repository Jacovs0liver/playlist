package cl.duoc.playlist.history.controller;

import cl.duoc.playlist.history.dto.HistoryRequest;
import cl.duoc.playlist.history.dto.HistoryResponse;
import cl.duoc.playlist.history.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService historyService;

    @GetMapping
    public ResponseEntity<List<HistoryResponse>> findAll() {
        return ResponseEntity.ok(historyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoryResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(historyService.findById(id));
    }

    @PostMapping
    public ResponseEntity<HistoryResponse> create(@RequestBody HistoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(historyService.create(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        historyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}