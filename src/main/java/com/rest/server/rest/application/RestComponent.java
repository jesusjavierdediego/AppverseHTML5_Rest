package com.rest.server.rest.application;

import com.google.common.util.concurrent.AbstractIdleService;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class RestComponent extends AbstractIdleService {

    public static final int PORT = 8000;

    private HttpServer httpServer;

    public RestComponent() throws IOException {
        RestApplication app = new RestApplication();
        Set<Class<?>> resources = new LinkedHashSet<>(app.getClasses());
        resources.add(JacksonJsonProvider.class);
        ResourceConfig config = new DefaultResourceConfig(resources);
        httpServer = HttpServerFactory.create("http://localhost:" + PORT + "/", config);
    }

    @Override
    protected void startUp() throws Exception {
        httpServer.start();
        System.out.println("Server started on port " + PORT + ".");
        System.out.println("Application is now available on http://localhost:" + PORT + "/web/index.html");
    }

    @Override
    protected void shutDown() throws Exception {
        httpServer.stop(1);
    }

    public static void main(String[] args) throws Exception {
        new RestComponent().startAndWait();
    }
}
