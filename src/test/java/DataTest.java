import com.github.javafaker.Faker;
import models.CreateUserBuilder;
import org.instancio.Instancio;
import org.instancio.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataTest {
    @Test
    public void fakerTest() {
        Faker faker = new Faker();

        CreateUserBuilder createUserBuilder = new CreateUserBuilder
                .Builder()
                .withFirstName(faker.name().firstName())
                .withLastName(faker.name().lastName())
                .withEmail(faker.internet().emailAddress())
                .withCheckbox(false)
                .withPassword(faker.internet().password())
                .build();

        System.out.println(createUserBuilder.toString());
    }

    @Test
    public void instancioTest() {
        List<String> names = List.of("John", "Jack", "Donald", "Elon", "Jeremy");
        CreateUserBuilder createUserBuilder = Instancio
                .of(CreateUserBuilder.class)
                // для игнорироания создания полей
                .ignore(Select.field(CreateUserBuilder::getEmail))
                // будет сгенерированно имя, но подставленно только из листа names
                .generate(Select.field(CreateUserBuilder::getFirstName),
                        x -> x.oneOf(names))
                .create();

        System.out.println(createUserBuilder.toString());
    }

    @Test
    public void instancioListTest() {
        List<String> names = List.of("John", "Jack", "Donald", "Elon", "Jeremy");
        // Для создания лстов объектов сгенерированных через Instancio
        List<CreateUserBuilder> list = Instancio
                .ofList(CreateUserBuilder.class)
                .size(5)
                // сет задает значение поля для всех экземпляров класса одинаковыми. в этом примере все будет true
                .set(Select.field(CreateUserBuilder::getCheckbox), true)
                .generate(Select.field(CreateUserBuilder::getFirstName),
                        x -> x.oneOf(names))
                // поля инт возраст рандомно подставятся значения из диапозона 18, 65 из метода ниже
                .generate(Select.field(CreateUserBuilder::getAge),
                        x -> x.ints().range(18, 65))
                .create();

        // Проверка что в list с CreateUserBuilder у каждого экземпляра поле Checkbox == true
        Assert.assertTrue(list.stream().allMatch(x -> x.getCheckbox().equals(true)));
        // Проверка что у каждого экземпляра возраст в диапозоне range(18, 65)
        Assert.assertTrue(list.stream().allMatch(x -> x.getAge() >= 18 && x.getAge() <= 65));
        // Проверка что имена использовались из листа names
        Assert.assertTrue(list.stream().allMatch(x -> names.contains(x.getFirstName())));
    }
}
