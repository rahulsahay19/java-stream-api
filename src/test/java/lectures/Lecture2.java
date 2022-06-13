package lectures;

import beans.Person;
import java.util.List;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

  @Test
  public void range() throws Exception {
    for(int i =0; i<10; i++){
      System.out.println(i);
    }
    System.out.println("Range exclusive");
    IntStream.range(0, 10)
            .forEach(index-> System.out.println(index));
    System.out.println("Range inclusive");
    IntStream.rangeClosed(0, 10)
            .forEach(index -> System.out.println(index));
  }

  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();
    IntStream.range(0, people.size())
            .forEach(index->{
              Person person = people.get(index);
              System.out.println(person.getFirstName());
            });
    //if we don't need index, then we can simply do
    System.out.println("Without index");
    people.forEach(System.out::println);
  }

  @Test
  public void intStreamIterate() throws Exception {
      IntStream.iterate(0, operand -> operand + 1)
          .filter(number -> number % 2 == 0)
          .limit(20)
          .forEach(System.out::println);
  }
}
