package cl.duoc.playlist.artist.controller;

import cl.duoc.playlist.artist.dto.ArtistRequest;
import cl.duoc.playlist.artist.dto.ArtistResponse;
import cl.duoc.playlist.artist.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping
    public ResponseEntity<List<ArtistResponse>> findAll() {
        return ResponseEntity.ok(artistService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(artistService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ArtistResponse> create(@RequestBody ArtistRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(artistService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtistResponse> update(@PathVariable("id") Long id,
            @RequestBody ArtistRequest request) {
        return ResponseEntity.ok(artistService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        artistService.delete(id);
        return ResponseEntity.noContent().build();
    }
}