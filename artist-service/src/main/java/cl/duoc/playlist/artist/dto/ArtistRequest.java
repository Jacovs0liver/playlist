package cl.duoc.playlist.artist.dto;

import lombok.Data;

@Data
public class ArtistRequest {

    private String nombre;
    private String genero;
    private String biografia;
}