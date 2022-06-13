package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {
  final  Predicate<Car> carPredicate = car -> car.getPrice() < 10000;
  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
   // Predicate<Car> carPredicate = car -> car.getPrice() < 10000;
    List<Car> filterdCars = cars.stream()
            .filter(carPredicate)
            .collect(Collectors.toList());
    filterdCars.forEach(System.out::println);
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // map transform from one data type to another
    List<Person> people = MockData.getPeople();
//    List<PersonDTO> dtos = people.stream()
//            .map(person -> {
//              PersonDTO dto = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
//              return dto;
//            }).collect(Collectors.toList());
//    List<PersonDTO> dtos = people.stream()
//            .map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
//            .collect(Collectors.toList());
//    dtos.forEach(System.out::println);

    //3rd way via extension method
//    List<PersonDTO> dtos = people.stream()
//            .map(PersonDTO::map)
//            .collect(Collectors.toList());
//    dtos.forEach(System.out::println);
    //or via function. This way It can be made reusable like automapper in a different mapping file
    Function<Person, PersonDTO> personPersonDTOFunction = person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
    people.stream()
            .map(personPersonDTOFunction)
            .collect(Collectors.toList());
  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    double average = MockData.getCars()
            .stream()
            .mapToDouble(Car::getPrice)
            .average()
            .orElse(0);
    System.out.println(average);
  }

  @Test
  public void test() throws Exception {

  }
}



