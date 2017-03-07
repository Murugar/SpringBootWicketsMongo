package com.iqmsoft.boot.wickets.wicket.component.util;

import org.apache.wicket.ajax.AjaxRequestTarget;

import java.io.Serializable;

@FunctionalInterface
public interface AjaxAction extends Serializable {
    public abstract void onClick(AjaxRequestTarget target);
}
