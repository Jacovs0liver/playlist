package cl.duoc.playlist.playlist.dto;

import lombok.Data;

@Data
public class PlaylistRequest {

    private String nombre;
    private String descripcion;
    private Long userId;
}