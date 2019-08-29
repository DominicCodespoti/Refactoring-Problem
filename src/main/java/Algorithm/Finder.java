package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Finder {

  private final List<Person> listOfPersons;

  private DifferenceInAgeHolder test(Options possibleOptions,
      List<DifferenceInAgeHolder> listOfAgeDifferences) {
    DifferenceInAgeHolder oldestPersonInList = listOfAgeDifferences.get(0);

    Map<Options, Boolean> test = new HashMap<>();

    for (DifferenceInAgeHolder currentPerson : listOfAgeDifferences) {
      test.put(Options.findFurthestGap,
          currentPerson.differenceInAge < oldestPersonInList.differenceInAge);
      test.put(Options.findNearestGap,
          currentPerson.differenceInAge > oldestPersonInList.differenceInAge);
      if (!test.get(possibleOptions)) {
        oldestPersonInList = currentPerson;
      }
    }
    return oldestPersonInList;
  }

  private DifferenceInAgeHolder listAdder(DifferenceInAgeHolder differenceInAgeCalculator) {
    differenceInAgeCalculator.differenceInAge =
        differenceInAgeCalculator.personTwo.getBirthDateTime()
            - differenceInAgeCalculator.personOne.getBirthDateTime();

    return differenceInAgeCalculator;
  }

  public Finder(List<Person> personList) {
    listOfPersons = personList;
  }

  public DifferenceInAgeHolder Find(Options possibleOptions) {
    List<DifferenceInAgeHolder> listOfAgeDifferences = new ArrayList<>();

    for (int I = 0; I < listOfPersons.size() - 1; I++) {
      for (int J = I + 1; J < listOfPersons.size(); J++) {
        DifferenceInAgeHolder differenceInAgeCalculator = new DifferenceInAgeHolder(
            listOfPersons.get(I), listOfPersons.get(J));
        listOfAgeDifferences.add(listAdder(differenceInAgeCalculator));
      }
    }

    return listOfAgeDifferences.size() < 1 ? new DifferenceInAgeHolder(null, null)
        : test(possibleOptions, listOfAgeDifferences);
  }
}