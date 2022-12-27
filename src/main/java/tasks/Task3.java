package tasks;

import common.Person;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Задача 3
Отсортировать коллекцию сначала по фамилии, по имени (при равной фамилии), и по дате создания (при равных фамилии и имени)
 */
public class Task3 {

  public static List<Person> sort(Collection<Person> persons) {

    return persons.stream()
            .sorted(Comparator.comparing(Person::getSecondName, Comparator.nullsFirst(Comparator.naturalOrder())) // Поскольку персоны могут быть с null каком-то из полей, добавил
                    .thenComparing(Person::getFirstName, Comparator.nullsFirst(Comparator.naturalOrder())) //обработку null, причем они идут первыми, потому что при пустой строке в имени
                    .thenComparing(Person::getCreatedAt, Comparator.nullsFirst(Comparator.naturalOrder()))) //или фамилии сравнение сработает в пользу пустой строки, а equals я не переписывал
            .collect(Collectors.toList());
  }
}
