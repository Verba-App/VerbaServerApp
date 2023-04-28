package ru.nsu.ccfit.verba.verbadata.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.verba.verbadata.api.openai.service.FoundService;

import java.io.IOException;
import java.util.List;
import ru.nsu.ccfit.verba.verbadata.api.openai.dto.ResponseDto;


@Controller
@RestController
@RequiredArgsConstructor
public class FoundController {
    private final FoundService foundService;

    @PostMapping("/data/image/found")
    public ResponseDto<List<String>> generateImages(@RequestParam("search") String request) throws IOException {
        return foundService.generateImage(request);
    }

}
