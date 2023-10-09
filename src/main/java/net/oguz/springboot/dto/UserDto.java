package net.oguz.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "User Dto Model Information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;

    @Schema(
            description = "User first name"
    )
    @NotEmpty(message = "first name must not be empty")
    private String firstName;

    @Schema(
            description = "User last name"
    )
    @NotEmpty(message = "last name must not be empty")
    private String lastName;

    @Schema(
            description = "User email"
    )
    @NotEmpty(message = "email must not be empty")
    @Email(message = "email address must be valid")
    private String email;

}
