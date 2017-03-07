package com.iqmsoft.boot.wickets.wicket.component.util;


import java.io.Serializable;

@FunctionalInterface
 public interface StringSupplier extends Serializable {
    String get();
}
