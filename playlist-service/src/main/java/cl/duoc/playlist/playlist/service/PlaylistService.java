package cl.duoc.playlist.playlist.service;

import cl.duoc.playlist.playlist.dto.PlaylistRequest;
import cl.duoc.playlist.playlist.dto.PlaylistResponse;
import cl.duoc.playlist.playlist.mapper.PlaylistMapper;
import cl.duoc.playlist.playlist.model.Playlist;
import cl.duoc.playlist.playlist.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final PlaylistMapper playlistMapper;

    public List<PlaylistResponse> findAll() {
        return playlistMapper.toResponseList(playlistRepository.findAll());
    }

    public PlaylistResponse findById(Long id) {
        Playlist playlist = playlistRepository.findById(id).orElseThrow();
        return playlistMapper.toResponse(playlist);
    }

    public PlaylistResponse create(PlaylistRequest request) {
        Playlist playlist = playlistMapper.toEntity(request);
        return playlistMapper.toResponse(playlistRepository.save(playlist));
    }

    public PlaylistResponse update(Long id, PlaylistRequest request) {
        Playlist playlist = playlistRepository.findById(id).orElseThrow();

        playlistMapper.updateEntity(request, playlist);

        return playlistMapper.toResponse(playlistRepository.save(playlist));
    }

    public void delete(Long id) {
        playlistRepository.deleteById(id);
    }
}