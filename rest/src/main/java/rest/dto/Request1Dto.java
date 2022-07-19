package rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
public class Request1Dto {

    @Schema(description = "Czajnik1 schema name", example = "Czajnik elektryczny", required = true)
    String name;
}
