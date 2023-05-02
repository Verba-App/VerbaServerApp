package ru.nsu.ccfit.verba.verbadata.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.verba.verbadata.api.openai.dto.GeneratorRequestDto;
import ru.nsu.ccfit.verba.verbadata.api.openai.service.ImageService;

import java.io.IOException;


@Controller
@RestController("/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageGeneratorService;

    @PostMapping("/generate")
    public String generateImages(@RequestBody GeneratorRequestDto request) throws IOException {
        return imageGeneratorService.generateImage(request);
    }

}
