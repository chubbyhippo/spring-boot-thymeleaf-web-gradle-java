package io.github.chubbyhippo.mythyme.application.dto;

import io.github.chubbyhippo.mythyme.application.validation.UniqueEmail;
import io.github.chubbyhippo.mythyme.domain.model.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

public record RequestUserDto(
        UUID id,
        @NotBlank
        String firstname,
        @NotBlank
        String lastname,
        @NotNull
        Gender gender,
        @Email
        @NotBlank
        @UniqueEmail
        String email,
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate birthday,
        @NotBlank
        @Pattern(regexp = "[0-9.\\-() x/+]+")
        String phoneNumber
) {

    public static final class RequestUserDtoBuilder {
        private UUID id;
        private @NotBlank String firstname;
        private @NotBlank String lastname;
        private @NotNull Gender gender;
        private @Email
        @NotBlank String email;
        private @NotNull LocalDate birthday;
        private @NotBlank
        @Pattern(regexp = "[0-9.\\-() x/+]+") String phoneNumber;

        private RequestUserDtoBuilder() {
        }

        public static RequestUserDtoBuilder aRequestUserDto() {
            return new RequestUserDtoBuilder();
        }

        public RequestUserDtoBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public RequestUserDtoBuilder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public RequestUserDtoBuilder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public RequestUserDtoBuilder withGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public RequestUserDtoBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public RequestUserDtoBuilder withBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public RequestUserDtoBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public RequestUserDto build() {
            return new RequestUserDto(id, firstname, lastname, gender, email, birthday, phoneNumber);
        }
    }
}
