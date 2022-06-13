package lectures;


import beans.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class Lecture8 {

  @Test
  public void simpleGrouping() throws Exception {
    //Group by make
    Map<String, List<Car>> makeGroup = MockData.getCars()
            .stream()
            .collect(Collectors.groupingBy(Car::getMake));
    //generic printing. No brainer
    //System.out.println(makeGroup);
    //printing in group by model
    makeGroup.forEach((make, cars)->{
      System.out.println(make);
      cars.forEach(System.out::println);
    });
  }

  @Test
  public void groupingAndCounting() throws Exception {
    ArrayList<String> names = Lists
        .newArrayList(
            "John",
            "John",
            "Mariam",
            "Alex",
            "Ram",
            "Ram",
            "Vincent",
            "Alex",
            "Alex"
        );
    Map<String, Long> counting = names.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    counting.forEach((name, count)-> System.out.println(name+"->"+count));

  }

}