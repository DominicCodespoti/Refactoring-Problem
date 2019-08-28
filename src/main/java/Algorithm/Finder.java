package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Finder {

  private final List<Person> listOfPersons;

  public Finder(List<Person> personList) {
    listOfPersons = personList;
  }

  public DifferenceInAgeCalculator Find(Options possibleOptions) {
    List<DifferenceInAgeCalculator> listOfAgeDifferences = new ArrayList<>();

    for (int personIterator = 0; personIterator < listOfPersons.size() - 1; personIterator++) {
      for (int personIteratorForward = personIterator + 1;
          personIteratorForward < listOfPersons.size(); personIteratorForward++) {
        DifferenceInAgeCalculator differenceInAgeCalculator = new DifferenceInAgeCalculator();
        if (listOfPersons.get(personIterator).getBirthDate().getTime() < listOfPersons
            .get(personIteratorForward).getBirthDate().getTime()) {
          differenceInAgeCalculator.personOne = listOfPersons.get(personIterator);
          differenceInAgeCalculator.personTwo = listOfPersons.get(personIteratorForward);
        } else {
          differenceInAgeCalculator.personOne = listOfPersons.get(personIteratorForward);
          differenceInAgeCalculator.personTwo = listOfPersons.get(personIterator);
        }
        differenceInAgeCalculator.differenceInAge =
            differenceInAgeCalculator.personTwo.getBirthDate().getTime()
                - differenceInAgeCalculator.personOne.getBirthDate().getTime();
        listOfAgeDifferences.add(differenceInAgeCalculator);
      }
    }

    if (listOfAgeDifferences.size() < 1) {
      return new DifferenceInAgeCalculator();
    }

    DifferenceInAgeCalculator oldestPersonInList = listOfAgeDifferences.get(0);

    for (DifferenceInAgeCalculator personBeingCheckedAgainst : listOfAgeDifferences) {
      switch (possibleOptions) {
        case personIsOlder:
          if (personBeingCheckedAgainst.differenceInAge < oldestPersonInList.differenceInAge) {
            oldestPersonInList = personBeingCheckedAgainst;
          }
          break;

        case personIsYounger:
          if (personBeingCheckedAgainst.differenceInAge > oldestPersonInList.differenceInAge) {
            oldestPersonInList = personBeingCheckedAgainst;
          }
          break;
      }
    }
    return oldestPersonInList;
  }
}