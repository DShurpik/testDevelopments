package models;

import io.qameta.allure.Step;

public class CreateUserBuilder {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean checkbox;

    public static class Builder {
        protected CreateUserBuilder createUserBuilder;

        @Step("Create a user with {firstName} name")
        public Builder withFirstName(String firstName) {
            createUserBuilder.firstName = firstName;
            logStep("withFirstName", firstName);
            return this;
        }

        @Step("Create a user with {lastName} last name")
        public Builder withLastName(String lastName) {
            createUserBuilder.lastName = lastName;
            logStep("withLastName", lastName);
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
            System.out.println("Open class Builder");
            this.createUserBuilder = new CreateUserBuilder();
        }

        public CreateUserBuilder build() {
            System.out.println("Object has been built");
            return createUserBuilder;
        }

        // Логирование шага в Allure
        private void logStep(String field, String value) {
            io.qameta.allure.Allure.step(String.format("Set %s to %s", field, value));
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
