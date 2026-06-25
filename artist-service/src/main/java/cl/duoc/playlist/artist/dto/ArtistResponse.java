package cl.duoc.playlist.artist.dto;

import lombok.Data;

@Data
public class ArtistResponse {

    private Long id;
    private String nombre;
    private String genero;
    private String biografia;
}