package ru.practicum.explore.main.user.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto {
    private Long id;

    @NotBlank(message = "Имя пользователя отсутствует или представлено пустым символом")
    @Size(min = 2, max = 250, message = "Количество символов в имени пользователя должно быть в пределах 2-250")
    private String name;

    @NotBlank(message = "Адрес электронной почты отсутствует или представлен пустым символом")
    @Size(min = 6, max = 254, message = "Количество символов в адресе электронной почты должно быть в пределах 6-254")
    @Email(message = "Email не соответствует формату электронной почты")
    private String email;
}
