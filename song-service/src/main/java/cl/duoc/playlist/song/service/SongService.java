package cl.duoc.playlist.song.service;

import cl.duoc.playlist.song.dto.SongRequest;
import cl.duoc.playlist.song.dto.SongResponse;
import cl.duoc.playlist.song.mapper.SongMapper;
import cl.duoc.playlist.song.model.Song;
import cl.duoc.playlist.song.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import cl.duoc.playlist.song.client.ArtistClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;
    private final ArtistClient artistClient;

    public List<SongResponse> findAll() {
        return songMapper.toResponseList(songRepository.findAll());
    }

    public SongResponse findById(Long id) {
        Song song = songRepository.findById(id).orElseThrow();
        return songMapper.toResponse(song);
    }

    public SongResponse create(SongRequest request) {

        artistClient.findById(request.getArtistId());

        Song song = songMapper.toEntity(request);

        return songMapper.toResponse(songRepository.save(song));
    }

    public SongResponse update(Long id, SongRequest request) {
        Song song = songRepository.findById(id).orElseThrow();
        songMapper.updateEntity(request, song);
        return songMapper.toResponse(songRepository.save(song));
    }

    public void delete(Long id) {
        songRepository.deleteById(id);
    }
}