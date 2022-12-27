package tasks;

import common.Person;
import common.PersonService;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Задача 1
Метод на входе принимает List<Integer> id людей, ходит за ними в сервис
(он выдает несортированный Set<Person>, внутренняя работа сервиса неизвестна)
нужно их отсортировать в том же порядке, что и переданные id.
Оценить асимпотику работы
 */
public class Task1 {

  private final PersonService personService;

  public Task1(PersonService personService) {
    this.personService = personService;
  }

  public List<Person> findOrderedPersons(List<Integer> personIds) {
    Set<Person> persons = personService.findPersons(personIds);
    Map<Integer, Person> idToPersonMap = persons.stream().collect(Collectors.toMap(Person::getId, Function.identity())); // O(n)
    return personIds.stream().map(idToPersonMap::get).collect(Collectors.toList()); // тут тоже сложность O(n), суммарная O(2n) = O(n)
                                                                                    // Но если случится так, что personService на один айдишник выдаст 2 разные персоны, то я должен буду в
                                                                                    // Collectors.toMap добавить merge function
  }
}
