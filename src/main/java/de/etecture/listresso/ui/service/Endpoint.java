package de.etecture.listresso.ui.service;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public enum Endpoint {

     OVERVIEW, MEMBERS, ROUNDS;

    public void add(final View view, final Navigator navigator) {
        final String name = this.name();
        navigator.addView(name, view);
    }

    public void to(final Navigator navigator, final String paramString) {
        final String name = this.name() + Optional.ofNullable(paramString)
                .map(params -> '/' + params)
                .orElse("");

        navigator.navigateTo(name);
    }

}
