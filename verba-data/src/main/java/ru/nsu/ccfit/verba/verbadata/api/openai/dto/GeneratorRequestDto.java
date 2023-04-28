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

    //** Идентификатор пользователя */
    private String user;

    public GeneratorRequestDto(String prompt, int n, String size, String response_format)
    {
        this.prompt = prompt;
        this.n = n;
        this.size = size;
        this.response_format = response_format;
    }

}
