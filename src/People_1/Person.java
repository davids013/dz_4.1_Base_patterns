package People_1;

import java.util.Objects;

public class Person {

    private final String name;
    private final String surname;
    private int age = -1;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        return address != null && address.length() > 0;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public boolean happyBirthday() {
        if (hasAge()) {
            age++;
            return true;
        } else return false;
    }

    public Person setAddress(String address) {
        this.address = (address != null && address.length() > 0) ? address : "";
        return this;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAge(0).setAddress(address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age
                && name.equals(person.name)
                && surname.equals(person.surname)
                && address.equals(person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", age=" + age +
//                ", address='" + address + '\'' +
//                '}';
        StringBuilder sb = new StringBuilder();
        sb
                .append(name)
                .append(" ")
                .append(surname);
        if (hasAge()) {
            sb
                    .append(" в возрасте ")
                    .append(age);
            if ((age > 4 && age < 21) || (age % 10 > 4 || age % 10 == 0)) {
                sb.append(" лет");
            } else sb.append((age % 10 == 1) ? " год" : " года");
        }
        if (hasAddress()) sb.append(" из г." + address);
        return sb.toString();
    }
}
