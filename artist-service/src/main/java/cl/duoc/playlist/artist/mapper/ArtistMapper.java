package cl.duoc.playlist.artist.mapper;

import cl.duoc.playlist.artist.dto.ArtistRequest;
import cl.duoc.playlist.artist.dto.ArtistResponse;
import cl.duoc.playlist.artist.model.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArtistMapper {

    Artist toEntity(ArtistRequest request);

    ArtistResponse toResponse(Artist artist);

    List<ArtistResponse> toResponseList(List<Artist> artists);

    @Mapping(target = "id", ignore = true)
    void updateEntity(ArtistRequest request, @MappingTarget Artist artist);
}