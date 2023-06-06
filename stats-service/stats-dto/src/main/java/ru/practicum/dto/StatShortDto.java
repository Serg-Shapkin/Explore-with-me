package ru.practicum.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.net.URI;

@Builder
@Getter
@EqualsAndHashCode
public class StatShortDto {
    private String app;   // Название сервиса
    private URI uri;      // URI сервиса
    private Long hits;    // Количество просмотров
}
