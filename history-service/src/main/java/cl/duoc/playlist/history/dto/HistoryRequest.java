package cl.duoc.playlist.history.dto;

import lombok.Data;

@Data
public class HistoryRequest {

    private Long userId;
    private Long songId;
}