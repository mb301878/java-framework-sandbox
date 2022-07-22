package rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
public class Request1Dto {

    @Schema(description = "Czajnik1 schema name", example = "Czajnik elektryczny", required = true)
    String name;

    @JsonCreator
    public static Request1Dto newInstance(@JsonProperty("name") String name) {
        return new Request1Dto(name);
    }
}
