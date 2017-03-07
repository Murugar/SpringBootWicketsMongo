package com.iqmsoft.boot.wickets.wicket.component.util;

import java.io.Serializable;

@FunctionalInterface
 public interface FormAction extends Serializable {
    public abstract void onSubmit();
}
