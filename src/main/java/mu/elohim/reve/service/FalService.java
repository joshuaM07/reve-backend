package mu.elohim.reve.service;

import ai.fal.client.FalClient;
import ai.fal.client.RunOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import mu.elohim.reve.dto.AvatarBuilderRequest;
import mu.elohim.reve.dto.AvatarBuilderResponse;
import mu.elohim.reve.dto.DefaultClothingsRequest;
import mu.elohim.reve.dto.DefaultClothingsResponse;
import mu.elohim.reve.dto.GenerateOutfitRequest;
import mu.elohim.reve.dto.GenerateOutfitResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FalService {

    private final FalClient falClient;
    private final Gson gson;

    public FalService(FalClient falClient) {
        this.falClient = falClient;
        this.gson = new GsonBuilder()
                .registerTypeAdapter(DefaultClothingsResponse.class, (JsonDeserializer<DefaultClothingsResponse>) (json, typeOfT, context) -> {
                    DefaultClothingsResponse response = new DefaultClothingsResponse();
                    Map<String, String> images = new HashMap<>();
                    JsonObject jsonObject = json.getAsJsonObject();
                    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                        images.put(entry.getKey(), entry.getValue().getAsString());
                    }
                    response.setImages(images);
                    return response;
                })
                .create();
    }

    public GenerateOutfitResponse generateOutfit(GenerateOutfitRequest request) throws Exception {
        RunOptions<JsonObject> options = RunOptions.<JsonObject>builder()
                .input(request)
                .build();
        return gson.fromJson(falClient.run("workflows/joshm071197/reve-generate-outfit", options).getData(), GenerateOutfitResponse.class);
    }

    public AvatarBuilderResponse buildAvatar(AvatarBuilderRequest request) throws Exception {
        RunOptions<JsonObject> options = RunOptions.<JsonObject>builder()
                .input(request)
                .build();
        return gson.fromJson(falClient.run("workflows/joshm071197/reve-avatar-builder", options).getData(), AvatarBuilderResponse.class);
    }

    public DefaultClothingsResponse getDefaultClothings(DefaultClothingsRequest request) throws Exception {
        RunOptions<JsonObject> options = RunOptions.<JsonObject>builder()
                .input(request)
                .build();
        return gson.fromJson(falClient.run("workflows/joshm071197/reve-default-clothings", options).getData(), DefaultClothingsResponse.class);
    }
}
