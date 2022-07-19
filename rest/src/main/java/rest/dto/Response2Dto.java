package rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(staticName = "newInstance")
public class Response2Dto {

    @Schema(description = "Id incremented by one", example = "69", defaultValue = "69", required = true)
    Long increasedId;

    @Schema(description = "You're awesome")
    String haveAGoodDayMessage = "have a good day";
}
