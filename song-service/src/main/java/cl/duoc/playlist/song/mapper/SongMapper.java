package cl.duoc.playlist.song.mapper;

import cl.duoc.playlist.song.dto.SongRequest;
import cl.duoc.playlist.song.dto.SongResponse;
import cl.duoc.playlist.song.model.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SongMapper {

    Song toEntity(SongRequest request);

    SongResponse toResponse(Song song);

    List<SongResponse> toResponseList(List<Song> songs);

    @Mapping(target = "id", ignore = true)
    void updateEntity(SongRequest request, @MappingTarget Song song);
}