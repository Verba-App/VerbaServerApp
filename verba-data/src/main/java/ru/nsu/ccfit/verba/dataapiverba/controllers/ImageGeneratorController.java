package ru.nsu.ccfit.verba.dataapiverba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.verba.dataapiverba.dto.GeneratorRequest;
import ru.nsu.ccfit.verba.dataapiverba.services.ImageGeneratorService;

import java.io.IOException;


@RestController
public class ImageGeneratorController {
    @Autowired
    private final ImageGeneratorService imageGeneratorService;

    public ImageGeneratorController(ImageGeneratorService imageGeneratorService) {
        this.imageGeneratorService = imageGeneratorService;
    }

    @PostMapping("/generate")
    public String generateImages(@RequestBody GeneratorRequest request) throws IOException {
        return imageGeneratorService.generateImage(request);
    }

}
