package mu.elohim.reve.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AvatarBuilderResponse {
    @JsonProperty("full_body")
    private String fullBody;
    private String portrait;
}
