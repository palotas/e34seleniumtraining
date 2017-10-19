/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package com.element34.testng.multiplexer;

import com.google.gson.JsonObject;
import org.testng.IInvokedMethod;
import org.testng.ITestNGMethod;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;


public class Metadata {
  private final Map<String, Object> metadata = new HashMap<>();
  private static final Map<ITestNGMethod, Metadata> map = new IdentityHashMap<>();

  private Metadata() {

  }

  public static synchronized  Metadata getMetadata(ITestNGMethod method) {
    Metadata res = map.get(method);
    if (res == null) {
      res = new Metadata();
      map.put(method, res);
    }
    return res;
  }

  public static synchronized Metadata  getMetadata(IInvokedMethod method) {
    Metadata res = map.get(method.getTestMethod());
    if (res == null) {
      res = new Metadata();
      map.put(method.getTestMethod(), res);
    }
    return res;
  }

  public Metadata put(String key, Object object) {
    metadata.put(key, object);
    return this;
  }

  public Object get(String key) {
    return metadata.get(key);
  }

  public JsonObject asJson() {
    JsonObject o = new JsonObject();
    for (String key : metadata.keySet()) {
      o.addProperty(key, metadata.get(key).toString());
    }
    return o;
  }



}
