package com.element34.testng.multiplexer;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({CONSTRUCTOR, METHOD, TYPE})
public @interface WebTest {

  Browsers browsers() default Browsers.Chrome;


}

