package cl.duoc.playlist.playlist.mapper;

import cl.duoc.playlist.playlist.dto.PlaylistRequest;
import cl.duoc.playlist.playlist.dto.PlaylistResponse;
import cl.duoc.playlist.playlist.model.Playlist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {

    Playlist toEntity(PlaylistRequest request);

    PlaylistResponse toResponse(Playlist playlist);

    List<PlaylistResponse> toResponseList(List<Playlist> playlists);

    @Mapping(target = "id", ignore = true)
    void updateEntity(PlaylistRequest request,
            @MappingTarget Playlist playlist);
}