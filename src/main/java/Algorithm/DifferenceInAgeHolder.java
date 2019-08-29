package Algorithm;

public class DifferenceInAgeHolder {

  public Person personOne;
  public Person personTwo;
  long differenceInAge;

  DifferenceInAgeHolder(Person personOne, Person personTwo){
    if (personOne != null && personTwo != null && personOne.getBirthDateTime() < personTwo.getBirthDateTime()) {
      this.personOne = personOne;
      this.personTwo = personTwo;
    } else {
      this.personOne = personTwo;
      this.personTwo = personOne;
    }
  }
}