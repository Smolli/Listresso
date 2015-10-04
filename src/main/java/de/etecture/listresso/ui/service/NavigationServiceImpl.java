package de.etecture.listresso.ui.service;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.UI;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

@Service
//@Scope
public class NavigationServiceImpl implements NavigationService {

    private static class EndpointInfo {
        Endpoint endpoint;
        String parameters;
    }

    private Navigator navigator;
    private Queue<EndpointInfo> locationQueue = new LinkedBlockingQueue<>();

    @Override
    public void root(final UI root) {
        this.navigator = new Navigator(root, root);
    }

    @Override
    public void bind(final View component, final Endpoint... endpoints) {
        for (Endpoint endpoint : endpoints) {
            if (endpoint == null) {
                this.navigator.addView("", component);
            } else {
                endpoint.add(component, this.navigator);
            }
        }
    }

    @Override
    public void to(final Endpoint endpoint) {
        this.to(endpoint, null);
    }

    @Override
    public void to(final Endpoint endpoint, final String firstKey, final String... params) {
        if (params.length % 2 == 0) {
            throw new IllegalArgumentException("Wrong count of arguments given!");
        }

        final Map<String, String> result = new HashMap<>(params.length / 2 + 1);
        int n = -1;

        while (n < params.length - 1) {
            final String key;
            if (n == -1) {
                key = firstKey;
            } else {
                key = params[++n];
            }
            final String value = params[++n];

            result.put(key, value);
        }

        this.to(endpoint, result);
    }

    @Override
    public void to(final Endpoint endpoint, final Map<String, String> parameters) {
        final String paramString = Optional.ofNullable(parameters)
            .map(NavigationServiceImpl::compileParameters)
            .orElse(null);

        EndpointInfo info = new EndpointInfo();
        info.endpoint = endpoint;
        info.parameters = paramString;

        this.locationQueue.add(info);

        Optional.ofNullable(endpoint)
            .ifPresent(ep -> ep.to(this.navigator, paramString));
    }

    private static String compileParameters(final Map<String, String> parameters) {
        return parameters.entrySet().stream()
            .map(entry -> entry.getKey() + '=' + entry.getValue())
            .collect(Collectors.joining("&"));
    }

    @Override
    public void back() {
        this.locationQueue.poll();
        EndpointInfo info = this.locationQueue.peek();

        if (info == null) {
            this.navigator.navigateTo("");
        } else {
            info.endpoint.to(this.navigator, info.parameters);
        }
    }

}
