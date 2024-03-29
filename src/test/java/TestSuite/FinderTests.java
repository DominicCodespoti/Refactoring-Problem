package TestSuite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import Algorithm.PairOfPersons;
import Algorithm.Finder;
import Algorithm.Options;
import Algorithm.Person;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class FinderTests {

  private Person sue = new Person();
  private Person greg = new Person();
  private Person sarah = new Person();
  private Person mike = new Person();

  @Before
  public void initialiseTests() {
    sue.setBirthDate(new Date(50, Calendar.JANUARY, 1));
    greg.setBirthDate(new Date(52, Calendar.JUNE, 1));
    sarah.setBirthDate(new Date(82, Calendar.JANUARY, 1));
    mike.setBirthDate(new Date(79, Calendar.JANUARY, 1));
  }

  @Test
  public void Returns_Null_When_Finder_Is_Given_Empty_List() {
    List<Person> list = new ArrayList<>();
    Finder finder = new Finder(list);

    PairOfPersons result = finder.Find(Options.findClearestGap);
    assertNull(result.personOne);
    assertNull(result.personTwo);
  }

  @Test
  public void Returns_Null_When_Finder_Is_Given_One_Person() {
    List<Person> list = new ArrayList<>();
    list.add(sue);

    Finder finder = new Finder(list);

    PairOfPersons result = finder.Find(Options.findClearestGap);

    assertNull(result.personOne);
    assertNull(result.personTwo);
  }

  @Test
  public void Returns_Closest_Two_For_Two_People() {
    List<Person> list = new ArrayList<>();
    list.add(sue);
    list.add(greg);
    Finder finder = new Finder(list);

    PairOfPersons result = finder.Find(Options.findClearestGap);

    assertEquals(sue, result.personOne);
    assertEquals(greg, result.personTwo);
  }

  @Test
  public void Returns_Furthest_Two_For_Two_People() {
    List<Person> list = new ArrayList<>();
    list.add(mike);
    list.add(greg);

    Finder finder = new Finder(list);

    PairOfPersons result = finder.Find(Options.findFurthestGap);

    assertEquals(greg, result.personOne);
    assertEquals(mike, result.personTwo);
  }

  @Test
  public void Returns_Furthest_Two_For_Four_People() {
    List<Person> list = new ArrayList<>();
    list.add(sue);
    list.add(sarah);
    list.add(mike);
    list.add(greg);
    Finder finder = new Finder(list);

    PairOfPersons result = finder.Find(Options.findFurthestGap);

    assertEquals(sue, result.personOne);
    assertEquals(sarah, result.personTwo);
  }

  @Test
  public void Returns_Closest_Two_For_Four_People() {
    List<Person> list = new ArrayList<>();
    list.add(sue);
    list.add(sarah);
    list.add(mike);
    list.add(greg);

    Finder finder = new Finder(list);

    PairOfPersons result = finder.Find(Options.findClearestGap);

    assertEquals(sue, result.personOne);
    assertEquals(greg, result.personTwo);
  }
}