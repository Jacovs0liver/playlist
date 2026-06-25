package cl.duoc.playlist.history.mapper;

import cl.duoc.playlist.history.dto.HistoryRequest;
import cl.duoc.playlist.history.dto.HistoryResponse;
import cl.duoc.playlist.history.model.History;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HistoryMapper {

    History toEntity(HistoryRequest request);

    HistoryResponse toResponse(History history);

    List<HistoryResponse> toResponseList(List<History> histories);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaReproduccion", ignore = true)
    void updateEntity(HistoryRequest request,
            @MappingTarget History history);
}