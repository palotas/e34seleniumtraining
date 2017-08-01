package com.element34.java.stream;

import com.element34.testng.report.Simple;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.element34.testng.report.Simple.sleepTight;


/**
 * some stream example
 */
public class StreamTest {

  private final List<String> list = Arrays.asList("one", "two", "three");


  @Test
  public void filter() {
    List<String> res = list.stream().filter(item -> !item.equals("two")).collect(Collectors.toList());
    System.out.println(res);
  }

  @Test
  public void map() {
    List<Integer> res = list
        .stream()
        .filter(item -> item.equals("two"))
        .map(item -> convert(item))
        .collect(Collectors.toList());
    System.out.println(res);
  }

  @Test
  public void parallel() {
    list.parallelStream().map(item -> slow(item)).forEach(System.out::println);
  }


  public String slow(String item) {
    Simple.sleepTight(2000);
    return item + "_slow";
  }

  public Integer convert(String item) {
    switch (item) {
      case "one":
        return 1;
      case "two":
        return 2;
      case "three":
        return 3;
      default:
        return 0;
    }
  }

}
