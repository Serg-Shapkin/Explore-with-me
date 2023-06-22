package ru.practicum.explore.main.compilation.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
public class NewCompilationDto {
    private List<Long> events = new ArrayList<>();
    private boolean pinned;
    @NotBlank(message = "Заголовок подборки отсутствует или представлен пустым символом")
    @Size(max = 50)
    private String title;
}
