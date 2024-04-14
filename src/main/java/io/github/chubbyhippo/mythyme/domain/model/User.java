package io.github.chubbyhippo.mythyme.domain.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Table(name = "app_user")
public record User(
        @Id
        UUID id,
        @Column("first_name")
        String firstname,
        @Column("last_name")
        String lastname,
        @Column("gender")
        Gender gender,
        @Column("date_of_birth")
        LocalDate dob,
        @Column("email")
        String email,
        @Column("phone_number")
        String phoneNumber,
        @CreatedDate
        Instant createdDate,
        @LastModifiedDate
        Instant lastModifiedDate,
        @Version
        int version
) {

    public static final class UserBuilder {
        private UUID id;
        private String firstname;
        private String lastname;
        private Gender gender;
        private LocalDate dob;
        private String email;
        private String phoneNumber;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public UserBuilder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public UserBuilder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserBuilder withGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder withDob(LocalDate dob) {
            this.dob = dob;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public User build() {
            return new User(id, firstname, lastname, gender, dob, email, phoneNumber, null, null, 0);
        }
    }
}
