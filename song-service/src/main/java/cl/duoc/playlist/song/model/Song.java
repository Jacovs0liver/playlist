package cl.duoc.playlist.song.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "songs", uniqueConstraints = {
        @UniqueConstraint(name = "uk_songs_isrc", columnNames = "isrc")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Song
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private Integer duracion;

    @Column(nullable = false, unique = true)
    private String isrc;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private Long artistId;
}