package rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
public class Response2Dto {

    @JsonCreator
    public static Response2Dto newInstance(@JsonProperty("increasedId") Long increasedId) {
        return new Response2Dto(increasedId);
    }

    @Schema(description = "Id incremented by one", example = "69", defaultValue = "69", required = true)
    Long increasedId;

    @Schema(description = "You're awesome")
    String haveAGoodDayMessage = "have a good day";
}
