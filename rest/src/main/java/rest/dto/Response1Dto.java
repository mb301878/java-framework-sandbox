package rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
public class Response1Dto {

    @Schema(description = "Info about Lewandowski in Barca", example = "heh", defaultValue = "heh1", required = true)
    String message;

    @Schema(description = "No idea what i'm doing")
    Boolean justBoolean;

    @JsonCreator
    public static Response1Dto newInstance(@JsonProperty("message") String message,
                                           @JsonProperty("justBoolean") boolean justBoolean) {
        return new Response1Dto(message, justBoolean);
    }
}
