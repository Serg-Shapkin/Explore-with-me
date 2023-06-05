package ru.practicum.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatDto {
    //Идентификатор записи
    private Long id;

    @NotBlank(message = "Отсутствует идентификатор сервиса для которого записывается информация" +
            " или передана пустая строка (символ)")
    private String app;

    @NotNull(message = "Отсутствует URI для которого был осуществлен запрос")
    private URI uri;

    @NotNull(message = "Отсутствует IP-адрес пользователя, осуществившего запрос")
    private String ip;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    //Дата и время, когда был совершен запрос к эндпоинту (в формате "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
}
