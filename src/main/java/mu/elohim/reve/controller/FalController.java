package mu.elohim.reve.controller;

import mu.elohim.reve.dto.AvatarBuilderRequest;
import mu.elohim.reve.dto.AvatarBuilderResponse;
import mu.elohim.reve.dto.DefaultClothingsRequest;
import mu.elohim.reve.dto.DefaultClothingsResponse;
import mu.elohim.reve.dto.GenerateOutfitRequest;
import mu.elohim.reve.dto.GenerateOutfitResponse;
import mu.elohim.reve.service.FalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fal")
public class FalController {

    private final FalService falService;

    public FalController(FalService falService) {
        this.falService = falService;
    }

    @PostMapping("/generate-outfit")
    public ResponseEntity<GenerateOutfitResponse> generateOutfit(@RequestBody GenerateOutfitRequest request) throws Exception {
        return ResponseEntity.ok(falService.generateOutfit(request));
    }

    @PostMapping("/avatar-builder")
    public ResponseEntity<AvatarBuilderResponse> buildAvatar(@RequestBody AvatarBuilderRequest request) throws Exception {
        return ResponseEntity.ok(falService.buildAvatar(request));
    }

    @PostMapping("/default-clothings")
    public ResponseEntity<DefaultClothingsResponse> getDefaultClothings(@RequestBody DefaultClothingsRequest request) throws Exception {
        return ResponseEntity.ok(falService.getDefaultClothings(request));
    }
}
