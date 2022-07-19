package rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(staticName = "newInstance")
public class Response1Dto {

    @Schema(description = "Info about Lewandowski in Barca", example = "heh", defaultValue = "heh1", required = true)
    String message;

    @Schema(description = "No idea what i'm doing")
    Boolean justBoolean;
}
