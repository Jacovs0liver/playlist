package cl.duoc.playlist.playlist.dto;

import lombok.Data;

@Data
public class PlaylistResponse {

    private Long id;
    private String nombre;
    private String descripcion;
    private Long userId;
}