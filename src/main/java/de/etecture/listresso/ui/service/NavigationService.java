package de.etecture.listresso.ui.service;

import com.vaadin.navigator.View;
import com.vaadin.ui.UI;

import java.util.Map;

public interface NavigationService {

    void root(UI root);

    void bind(View component, Endpoint... endpoints);

    void to(Endpoint endpoint);

    void to(Endpoint endpoint, Map<String, String> parameters);

    void to(Endpoint endpoint, String firstKey, String... params);

    void back();

}
