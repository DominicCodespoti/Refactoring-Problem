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