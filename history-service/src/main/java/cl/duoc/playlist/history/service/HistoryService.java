package cl.duoc.playlist.history.service;

import cl.duoc.playlist.history.dto.HistoryRequest;
import cl.duoc.playlist.history.dto.HistoryResponse;
import cl.duoc.playlist.history.mapper.HistoryMapper;
import cl.duoc.playlist.history.model.History;
import cl.duoc.playlist.history.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepository historyRepository;
    private final HistoryMapper historyMapper;

    public List<HistoryResponse> findAll() {
        return historyMapper.toResponseList(historyRepository.findAll());
    }

    public HistoryResponse findById(Long id) {
        History history = historyRepository.findById(id).orElseThrow();
        return historyMapper.toResponse(history);
    }

    public HistoryResponse create(HistoryRequest request) {
        History history = historyMapper.toEntity(request);
        history.setFechaReproduccion(LocalDateTime.now());
        return historyMapper.toResponse(historyRepository.save(history));
    }

    public void delete(Long id) {
        historyRepository.deleteById(id);
    }
}