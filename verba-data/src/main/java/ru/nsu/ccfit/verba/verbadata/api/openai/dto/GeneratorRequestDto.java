package ru.nsu.ccfit.verba.verbadata.api.openai.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class GeneratorRequestDto {
    //** Запрос */
    private String prompt;

    //** Колиество сгенерированных картинок */
    private Integer n;

    //** Размер картинок в пикселях: 256x256, 512x512 или 1024x1024 */
    private String size;

    //** Формат: url или b64_json */
    private String response_format;

}
