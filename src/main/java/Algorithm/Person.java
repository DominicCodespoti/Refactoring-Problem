package Algorithm;

import java.util.Date;

public class Person {
  private Date birthDate;

  long getBirthDateTime() {
    return birthDate.getTime();
  }
  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }
}

/*
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
 */