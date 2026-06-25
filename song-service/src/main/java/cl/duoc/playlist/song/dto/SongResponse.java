package cl.duoc.playlist.song.dto;

import lombok.Data;

@Data
public class SongResponse {

    private Long id;
    private String titulo;
    private Integer duracion;
    private String isrc;
    private String genero;
    private Long artistId;
}