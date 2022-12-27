package tasks;

import common.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
А теперь о горьком
Всем придется читать код
А некоторым придется читать код, написанный мною
Сочувствую им
Спасите будущих жертв, и исправьте здесь все, что вам не по душе!
P.S. функции тут разные и рабочие (наверное), но вот их понятность и эффективность страдает (аж пришлось писать комменты)
P.P.S Здесь ваши правки желательно прокомментировать (можно на гитхабе в пулл реквесте)
 */
public class Task8 {

  //убрал переменную за ненадобностью

  //Не хотим выдывать апи нашу фальшивую персону, поэтому конвертим начиная со второй
  public List<String> getNames(List<Person> persons) {
    return persons.stream()
                    .skip(1)  // если нам понадобится в методе использовать элементы, которые мы хотим сначала пропустить,
                              // то remove не подойдет, т.к. удалит элементы, + remove после удаления сдвигает все элементы,
                              // чтобы заполнить пустоту, а skip (если правильно понимаю) просто позволяет взять элементы, начиная с нужного
                    .map(Person::getFirstName)
                    .collect(Collectors.toList());
  }

  //ну и различные имена тоже хочется
  public Set<String> getDifferentNames(List<Person> persons) {
    return new HashSet<>(getNames(persons));
  }

  //Для фронтов выдадим полное имя, а то сами не могут
  public String convertPersonToString(Person person) {
    return Stream.of(person.getSecondName(), person.getFirstName(), person.getMiddleName())
            .filter(str -> str != null && !str.isEmpty())
            .collect(Collectors.joining(" "));
  }

  // словарь id персоны -> ее имя
  public Map<Integer, String> getPersonNames(Collection<Person> persons) {
    return persons.stream().collect(Collectors.toMap(Person::getId, Person::getFirstName, (person1, person2) -> person1)); // оставляем 1-ю персону при равных id
  }

  // есть ли совпадающие в двух коллекциях персоны?
  public boolean hasSamePersons(Collection<Person> persons1, Collection<Person> persons2) {
    HashSet<Person> person2HashSet = new HashSet<>(persons2); //O(m)
    return persons1.stream().anyMatch(person -> person2HashSet.contains(person)); //O(m+n)
  }

  //...
  public long countEven(Stream<Integer> numbers) {
    return numbers.filter(num -> num % 2 == 0).count(); //есть нужный метод
  }
}
