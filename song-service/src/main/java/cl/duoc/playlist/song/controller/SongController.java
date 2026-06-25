package cl.duoc.playlist.song.controller;

import cl.duoc.playlist.song.dto.SongRequest;
import cl.duoc.playlist.song.dto.SongResponse;
import cl.duoc.playlist.song.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping
    public ResponseEntity<List<SongResponse>> findAll() {
        return ResponseEntity.ok(songService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(songService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SongResponse> create(@RequestBody SongRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(songService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SongResponse> update(@PathVariable Long id,
            @RequestBody SongRequest request) {
        return ResponseEntity.ok(songService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        songService.delete(id);
        return ResponseEntity.noContent().build();
    }
}