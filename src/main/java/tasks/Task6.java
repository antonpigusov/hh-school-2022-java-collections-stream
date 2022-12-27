package tasks;

import common.Area;
import common.Person;

import java.util.*;
import java.util.stream.Collectors;

/*
Имеются
- коллекция персон Collection<Person>
- словарь Map<Integer, Set<Integer>>, сопоставляющий каждой персоне множество id регионов
- коллекция всех регионов Collection<Area>
На выходе хочется получить множество строк вида "Имя - регион". Если у персон регионов несколько, таких строк так же будет несколько
 */
public class Task6 {

  public static Set<String> getPersonDescriptions(Collection<Person> persons,
                                                  Map<Integer, Set<Integer>> personAreaIds,
                                                  Collection<Area> areas) {
    Map<Integer, Area> areaIdToAreaHashMap = areas.stream().collect(Collectors.toMap(Area::getId, area -> area)); //O(n)
    return persons.stream()
            .flatMap(person -> personAreaIds.get(person.getId()).stream()
                    .map(areaId -> person.getFirstName() + " - " + areaIdToAreaHashMap.get(areaId).getName()))
            .collect(Collectors.toSet()); //O(m), результат O(n+m)
  }
}
