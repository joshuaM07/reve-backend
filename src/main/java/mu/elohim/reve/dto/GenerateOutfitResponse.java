package mu.elohim.reve.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GenerateOutfitResponse {
    private String description;
    private String image;
    @JsonProperty("image_2")
    private String image2;
    @JsonProperty("image_3")
    private String image3;
    @JsonProperty("image_4")
    private String image4;
}
