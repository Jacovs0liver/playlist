package cl.duoc.playlist.playlist.controller;

import cl.duoc.playlist.playlist.dto.PlaylistRequest;
import cl.duoc.playlist.playlist.dto.PlaylistResponse;
import cl.duoc.playlist.playlist.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

    @GetMapping
    public ResponseEntity<List<PlaylistResponse>> findAll() {
        return ResponseEntity.ok(playlistService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(playlistService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PlaylistResponse> create(@RequestBody PlaylistRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(playlistService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaylistResponse> update(
            @PathVariable Long id,
            @RequestBody PlaylistRequest request) {

        return ResponseEntity.ok(playlistService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        playlistService.delete(id);
        return ResponseEntity.noContent().build();
    }
}