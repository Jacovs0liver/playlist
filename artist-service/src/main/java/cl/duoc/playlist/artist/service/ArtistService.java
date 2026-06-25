package cl.duoc.playlist.artist.service;

import cl.duoc.playlist.artist.dto.ArtistRequest;
import cl.duoc.playlist.artist.dto.ArtistResponse;
import cl.duoc.playlist.artist.mapper.ArtistMapper;
import cl.duoc.playlist.artist.model.Artist;
import cl.duoc.playlist.artist.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final ArtistMapper artistMapper;

    public List<ArtistResponse> findAll() {
        return artistMapper.toResponseList(artistRepository.findAll());
    }

    public ArtistResponse findById(Long id) {

        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Artista no encontrado"));

        return artistMapper.toResponse(artist);
    }

    public ArtistResponse create(ArtistRequest request) {
        Artist artist = artistMapper.toEntity(request);
        return artistMapper.toResponse(artistRepository.save(artist));
    }

    public ArtistResponse update(Long id, ArtistRequest request) {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Artista no encontrado"));

        artistMapper.updateEntity(request, artist);
        return artistMapper.toResponse(artistRepository.save(artist));
    }

    public void delete(Long id) {

        if (!artistRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Artista no encontrado");
        }

        artistRepository.deleteById(id);
    }
}