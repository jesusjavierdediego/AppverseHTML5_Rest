package com.rest.server.rest.application;

import com.rest.restangular.server.rest.resource.StaticResource;
import com.rest.restangular.server.rest.resource.TodoListResource;
import com.rest.restangular.server.rest.resource.TodoResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<>();
        s.add(TodoListResource.class);
        s.add(TodoResource.class);
        s.add(StaticResource.class);
        return s;
    }
}
