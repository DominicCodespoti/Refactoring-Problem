package Algorithm;

public class PairOfPersons {

  public Person personOne;
  public Person personTwo;
  long differenceInAge;

  PairOfPersons(Person personOne, Person personTwo){
    if (personOne != null && personTwo != null && personOne.getBirthDateTime() < personTwo.getBirthDateTime()) {
      this.personOne = personOne;
      this.personTwo = personTwo;
    } else {
      this.personOne = personTwo;
      this.personTwo = personOne;
    }
  }
}