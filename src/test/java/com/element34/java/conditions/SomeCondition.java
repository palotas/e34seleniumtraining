package com.element34.java.conditions;


import com.google.common.base.Function;

// WARNING : Function is the google one.
public class SomeCondition implements Function<SomeDriver /* input */, SomeWebElement /* output */> {

  private final SomeParameter param;

  public SomeCondition(SomeParameter param) {
    this.param = param;
  }

  @Override
  public SomeWebElement apply(SomeDriver driver) {
    SomeWebElement element = driver.findElement();
    if (element.toString().equals(param.getName())) {
      return element;
    }
    System.out.println("element there but not correct : "+element.toString());
    return null;
  }
}
