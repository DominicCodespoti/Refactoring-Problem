package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode.Op;

public class Finder {

  private final List<Person> listOfPersons;

  private boolean twoPersonDateComparator(Person personOne, Person personTwo) {
    return personOne.getBirthDateTime() < personTwo.getBirthDateTime();
  }

  private DifferenceInAgeHolder test(Options possibleOptions,
      List<DifferenceInAgeHolder> listOfAgeDifferences) {
    DifferenceInAgeHolder oldestPersonInList = listOfAgeDifferences.get(0);

    Map<Options, Boolean> test = new HashMap<>();

    for (DifferenceInAgeHolder currentPerson : listOfAgeDifferences) {
      test.put(Options.findFurthestGap, currentPerson.differenceInAge < oldestPersonInList.differenceInAge);
      test.put(Options.findNearestGap, currentPerson.differenceInAge > oldestPersonInList.differenceInAge);
      if (!test.get(possibleOptions))
        oldestPersonInList = currentPerson;
    }
    return oldestPersonInList;
  }

  public Finder(List<Person> personList) {
    listOfPersons = personList;
  }

  public DifferenceInAgeHolder Find(Options possibleOptions) {
    List<DifferenceInAgeHolder> listOfAgeDifferences = new ArrayList<>();

    for (int I = 0; I < listOfPersons.size() - 1; I++) {
      for (int J = I + 1; J < listOfPersons.size(); J++) {

        DifferenceInAgeHolder differenceInAgeCalculator = new DifferenceInAgeHolder();

        if (twoPersonDateComparator(listOfPersons.get(I), listOfPersons.get(J))) {
          differenceInAgeCalculator.personOne = listOfPersons.get(I);
          differenceInAgeCalculator.personTwo = listOfPersons.get(J);
        } else {
          differenceInAgeCalculator.personOne = listOfPersons.get(J);
          differenceInAgeCalculator.personTwo = listOfPersons.get(I);
        }

        differenceInAgeCalculator.differenceInAge =
            differenceInAgeCalculator.personTwo.getBirthDateTime()
                - differenceInAgeCalculator.personOne.getBirthDateTime();

        listOfAgeDifferences.add(differenceInAgeCalculator);
      }
    }

    if (listOfAgeDifferences.size() < 1) {
      return new DifferenceInAgeHolder();
    }

    return test(possibleOptions, listOfAgeDifferences);
  }
}