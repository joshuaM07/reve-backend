package mu.elohim.reve.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class GenerateOutfitRequest {
    @JsonProperty("image_urls")
    private List<String> imageUrls;
    @JsonProperty("aspect_ratio")
    private String aspectRatio;
    private String resolution;
}
