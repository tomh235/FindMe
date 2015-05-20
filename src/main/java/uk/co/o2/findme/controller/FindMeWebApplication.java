package uk.co.o2.findme.controller;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.MvcFeature;
import uk.co.o2.findme.view.FreemarkerTemplateProcessor;

public class FindMeWebApplication extends ResourceConfig {

    public FindMeWebApplication() {
        packages(FindMeWebApplication.class.getPackage().getName());
        register(MvcFeature.class);
        register(FreemarkerTemplateProcessor.class);
    }
}
