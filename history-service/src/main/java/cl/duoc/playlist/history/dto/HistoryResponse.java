package cl.duoc.playlist.history.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoryResponse {

    private Long id;
    private Long userId;
    private Long songId;
    private LocalDateTime fechaReproduccion;
}