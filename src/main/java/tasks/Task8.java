package tasks;

import common.Person;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
  public List<String> getNames(List<Person> persons) { //я понял, что мне не очень нравятся названия ФИО в классе Person,
                                                       //не очень понятно, к чему относится каждое поле из ФИО,
                                                       //назвал их firstName, lastName и patronymic
    return persons.isEmpty() ? Collections.emptyList() :
            persons.stream()
                    .skip(1) //лучше просто пропустить первый элемент, чем удалять
                    .map(Person::getFirstName)
                    .collect(Collectors.toList());
  }

  //ну и различные имена тоже хочется
  public Set<String> getDifferentNames(List<Person> persons) {
    return getNames(persons).stream().collect(Collectors.toSet()); //тут идея сама подсказывает, что в distinct() нет смысла, т.к. собираем в Set
  }

  //Для фронтов выдадим полное имя, а то сами не могут
  public String convertPersonToString(Person person) { //я бы все примерно так и оставил, мне так читать легко, но думаю, что нужно добавить еще
                                                       // и проверки на пустую строку, чтобы не прибавлять лишние пробелы
    String result = "";
    if (person.getLastName() != null) { //нет смысла делать проверку isEmpty(), т.к. лишний пробел не прибавится
      result += person.getLastName();
    }

    if (person.getFirstName() != null && !person.getFirstName().isEmpty()) {
      if(!result.isEmpty())
        result += " " + person.getFirstName();
      else result+=person.getFirstName();
    }

    if (person.getPatronymic() != null && !person.getPatronymic().isEmpty()) { //тут должно быть отчество
      if(!result.isEmpty())
        result += " " + person.getPatronymic();
      else result+=person.getPatronymic();
    }
    return result;
  }

  // словарь id персоны -> ее имя
  public Map<Integer, String> getPersonNames(Collection<Person> persons) {
    return persons.stream().collect(Collectors.toMap(Person::getId, Person::getLastName)); //есть нужный метод
  }

  // есть ли совпадающие в двух коллекциях персоны?
  public boolean hasSamePersons(Collection<Person> persons1, Collection<Person> persons2) {
    return persons1.stream().filter(person -> persons2.contains(person)).findFirst().isPresent();
  }

  //...
  public long countEven(Stream<Integer> numbers) {
    return numbers.filter(num -> num % 2 == 0).count(); //есть нужный метод
  }
}
