package tasks;

import common.Person;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Task3Test {

  private Person person1;
  private Person person2;
  private Person person3;
  private Person person4;
  private Person person5;
  private Person person6;
  private Person person7;
  private Person person8;
  private Person person9;
  private Person person10;
  private Person person11;
  private Person person12;
  private Person person13;
  private Person person14;

  @BeforeEach
  void before() {
    Instant time = Instant.now();
    person1 = new Person(1, "Oleg", "Ivanov", time);
    person2 = new Person(2, "Oleg", "Ivanov", time);
    person3 = new Person(3, "Oleg", "Ivanov", time.plusSeconds(1));
    person4 = new Person(4, "Oleg", "Petrov", time.plusSeconds(1));
    person5 = new Person(5, "Oleg", "Agapkin", time.plusSeconds(1));
    person6 = new Person(6, "Oleg", "Agapkin", time);
    person7 = new Person(7, "Anton", "Agapkin", time);
    person8 = new Person(8, "Anton", "Agapkin", time.plusSeconds(1));
    person9 = new Person(9, "Vasya", "Petrov", time);
    person10 = new Person(10, "Oleg", "Petrov", time.plusSeconds(1));
    person11 = new Person(11, "Anton", "Ivanov", time.plusSeconds(1));
    person12 = new Person(12, "Anton", "Ivanov", time);
    person13 = new Person(13, "", "Ivanov", time);
    person14 = new Person(14, "", time);
  }

  @Test
  public void test() {
    assertEquals(List.of(person1, person2, person3, person4), Task3.sort(List.of(person1, person2, person3, person4)));
    assertEquals(Collections.emptyList(), Task3.sort(Collections.EMPTY_LIST));
    assertEquals(List.of(person7, person8, person6, person5, person12, person11, person1, person2, person3, person4, person10, person9),
            Task3.sort(List.of(person1, person2, person3, person4, person5, person6, person7, person8, person9, person10, person11, person12)));
    assertEquals(List.of(person7, person8, person6, person5, person12, person11, person2, person1, person3, person10, person4, person9),
            Task3.sort(List.of(person12, person11, person10, person9, person8, person7, person6, person5, person4, person3, person2, person1)));
    assertEquals(List.of(person14, person13, person12, person11),
            Task3.sort(List.of(person11, person12, person13, person14)));
  }

  @Test
  public void testEmpty() {
    assertEquals(Collections.emptyList(), Task3.sort(Collections.emptyList()));
  }
}
