package tasks;

import common.Person;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task8Test {
    Task8 task8 = new Task8();

    @Test
    void testGetNames(){
        List<Person> personList = List.of(new Person(1, "a", "a", "c", Instant.now()),
                                        new Person(1, "b", "", "c", Instant.now()),
                                        new Person(1, "c", "", "", Instant.now()));

        assertEquals(List.of("b", "c"), task8.getNames(personList));
        assertEquals(Collections.EMPTY_LIST, task8.getNames(Collections.EMPTY_LIST));
    }

    @Test
    void testGetDifferentNames(){
        List<Person> persons = List.of(
                new Person(1, "a", "b", "c", Instant.ofEpochMilli(10)),
                new Person(2, "a", "b", "c", Instant.ofEpochMilli(10)),
                new Person(3, "b", "b", "c", Instant.ofEpochMilli(10)),
                new Person(4, "b", "s", "c", Instant.ofEpochMilli(10)),
                new Person(5, "v", "b", "c", Instant.ofEpochMilli(10)),
                new Person(6, "s", "b", "c", Instant.ofEpochMilli(10)),
                new Person(7, "s", "c", "c", Instant.ofEpochMilli(10)));
        assertEquals(Set.of("a","b","v","s"), task8.getDifferentNames(persons));
    }

    @Test
    void testConvertPersonToString(){
        Person person1 = new Person(1, "b", "a", "c", Instant.now());
        Person person2 = new Person(1, "b", "", "c", Instant.now());
        Person person3 = new Person(1, "", "", "", Instant.now());

        assertEquals("a b c",task8.convertPersonToString(person1));
        assertEquals("b c",task8.convertPersonToString(person2));
        assertEquals("",task8.convertPersonToString(person3));
    }

    @Test
    void testHaveSamePersons(){
        List<Person> persons1 = List.of(
                new Person(1, "a", "b", "c", Instant.ofEpochMilli(10)),
                new Person(2, "b", "b", "c", Instant.ofEpochMilli(10)),
                new Person(3, "v", "b", "c", Instant.ofEpochMilli(10)),
                new Person(4, "s", "b", "c", Instant.ofEpochMilli(10)));
        List<Person> persons2 = List.of(
                new Person(5, "b", "b", "c", Instant.ofEpochMilli(10)),
                new Person(6, "n", "b", "c", Instant.ofEpochMilli(10)),
                new Person(1, "a", "b", "c", Instant.ofEpochMilli(10)));
        List<Person> persons3 = List.of(
                new Person(5, "b", "b", "c", Instant.ofEpochMilli(10)),
                new Person(6, "n", "b", "c", Instant.ofEpochMilli(10)),
                new Person(1, "n", "b", "c", Instant.ofEpochMilli(10)),
                new Person(1, "a", "b", "c", Instant.ofEpochMilli(10)));
        assertEquals(true,task8.hasSamePersons(persons1, persons2));
        assertEquals(true,task8.hasSamePersons(persons1, persons3));
        assertEquals(false, task8.hasSamePersons(persons1, Collections.EMPTY_LIST));
    }

    @Test
    void testGetPersonNames(){
        List<Person> persons = List.of(
                new Person(1, "a", "b", "c", Instant.ofEpochMilli(10)),
                new Person(2, "b", "b", "c", Instant.ofEpochMilli(10)),
                new Person(3, "v", "b", "c", Instant.ofEpochMilli(10)),
                new Person(3, "v", "b", "c", Instant.ofEpochMilli(10)),
                new Person(4, "s", "b", "c", Instant.ofEpochMilli(10)));
        assertEquals(Map.of(1,"a",2,"b",3,"v",4,"s"),task8.getPersonNames(persons));
    }
}
