package People_1;

public class PersonBuilder {

    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder() {
    }

    public Person build() {
        if (name == null || surname == null) throw new IllegalStateException("Пустые имя или/и фамилия");
        Person person;
        person = (age >= 0) ? new Person(name, surname, age) : new Person(name, surname);
        if (address != null) person.setAddress(address);
        return person;
    }

    public PersonBuilder setName(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Некорректно задано имя");
        } else this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.length() == 0) {
            throw new IllegalArgumentException("Некорректно задана фамилия");
        } else this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не должен быть отрицательным");
        } else this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        if (address == null || address.length() == 0) {
            throw new IllegalArgumentException("Задан пустой адрес");
        } else this.address = address;
        return this;
    }
}
