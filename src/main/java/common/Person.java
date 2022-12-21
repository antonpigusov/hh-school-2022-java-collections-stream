package common;

import java.time.Instant;
import java.util.Objects;

public class Person {
  private Integer id;
  private String firstName;
  private String lastName;
  private String patronymic;
  private Instant createdAt;

  public Person(Integer id, String firstName, String lastName, String patronymic, Instant createdAt) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.patronymic = patronymic;
    this.createdAt = createdAt;
  }

  public Person(Integer id, String firstName, String lastName, Instant createdAt) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.createdAt = createdAt;
  }

  public Person(Integer id, String firstName, Instant createdAt) {
    this.id = id;
    this.firstName = firstName;
    this.createdAt = createdAt;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPatronymic() {
    return patronymic;
  }

  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(id, person.id) &&
        Objects.equals(firstName, person.firstName) &&
        Objects.equals(lastName, person.lastName) &&
        Objects.equals(patronymic, person.patronymic) &&
        Objects.equals(createdAt, person.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, patronymic, createdAt);
  }

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", patronymic='" + patronymic + '\'' +
        ", createdAt=" + createdAt +
        '}';
  }
}
