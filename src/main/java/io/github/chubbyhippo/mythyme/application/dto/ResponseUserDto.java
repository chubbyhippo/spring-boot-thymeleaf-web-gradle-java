package io.github.chubbyhippo.mythyme.application.dto;

import io.github.chubbyhippo.mythyme.domain.model.Gender;

import java.time.LocalDate;

public record ResponseUserDto(
        String name,
        Gender gender,
        LocalDate birthday,
        String phoneNumber,
        String email
) {

    public static final class ResponseUserDtoBuilder {
        private String name;
        private Gender gender;
        private LocalDate birthday;
        private String phoneNumber;
        private String email;

        private ResponseUserDtoBuilder() {
        }

        public static ResponseUserDtoBuilder aResponseUserDto() {
            return new ResponseUserDtoBuilder();
        }

        public ResponseUserDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ResponseUserDtoBuilder withGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public ResponseUserDtoBuilder withBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public ResponseUserDtoBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public ResponseUserDtoBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public ResponseUserDto build() {
            return new ResponseUserDto(name, gender, birthday, phoneNumber, email);
        }
    }
}
