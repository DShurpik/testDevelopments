package models;

public class CreateUserBuilder {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean checkbox;

    public static class Builder{
        private CreateUserBuilder createUserBuilder;

        public Builder withFirstName(String firstName) {
            createUserBuilder.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            createUserBuilder.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            createUserBuilder.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            createUserBuilder.password = password;
            return this;
        }

        public Builder withCheckbox(Boolean checkbox) {
            createUserBuilder.checkbox = checkbox;
            return this;
        }

        public Builder() {
            this.createUserBuilder = new CreateUserBuilder();
        }

        public CreateUserBuilder build() {
            return createUserBuilder;
        }
    }

    @Override
    public String toString() {
        return "CreateUserBuilder{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", checkbox=" + checkbox +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getCheckbox() {
        return checkbox;
    }
}
