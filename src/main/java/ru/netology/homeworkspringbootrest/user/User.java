package ru.netology.homeworkspringbootrest.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class User {
    @Size(min = 2, max = 4)
    private String name;
    @Size(min = 2, max = 4)
    private String password;
}
