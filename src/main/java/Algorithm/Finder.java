package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Finder {

  private final List<Person> listOfPersons;

  private PairOfPersons findBiggestOrSmallestAgeGap(Options findClosestPair,
      List<PairOfPersons> listOfAgeDifferences) {
    PairOfPersons closestOrFurtherestPair = listOfAgeDifferences.get(0);

    Map<Options, Boolean> conditionMap = new HashMap<>();

    for (PairOfPersons currentPair : listOfAgeDifferences) {
      conditionMap.put(Options.findFurthestGap,
          currentPair.differenceInAge < closestOrFurtherestPair.differenceInAge);
      conditionMap.put(Options.findClearestGap,
          currentPair.differenceInAge > closestOrFurtherestPair.differenceInAge);
      if (!conditionMap.get(findClosestPair)) {
        closestOrFurtherestPair = currentPair;
      }
    }
    return closestOrFurtherestPair;
  }

  private PairOfPersons addPairToList(PairOfPersons pairOfPersons) {
    pairOfPersons.differenceInAge =
        pairOfPersons.personTwo.getBirthDateTime()
            - pairOfPersons.personOne.getBirthDateTime();

    return pairOfPersons;
  }

  public Finder(List<Person> personList) {
    listOfPersons = personList;
  }

  public PairOfPersons Find(Options possibleOptions) {
    List<PairOfPersons> listOfPairsOfPersons = new ArrayList<>();

    for (int I = 0; I < listOfPersons.size() - 1; I++) {
      for (int J = I + 1; J < listOfPersons.size(); J++) {
        PairOfPersons differenceInAgeCalculator = new PairOfPersons(
            listOfPersons.get(I), listOfPersons.get(J));
        listOfPairsOfPersons.add(addPairToList(differenceInAgeCalculator));
      }
    }

    return listOfPairsOfPersons.size() < 1 ? new PairOfPersons(null, null)
        : findBiggestOrSmallestAgeGap(possibleOptions, listOfPairsOfPersons);
  }
}