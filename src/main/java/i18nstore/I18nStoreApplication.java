package i18nstore;


import org.glassfish.jersey.message.filtering.SelectableEntityFilteringFeature;

import i18nstore.health.I18nHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class I18nStoreApplication extends Application<I18nStoreConfiguration>{
    public static void main(String... args) throws Exception {
        new I18nStoreApplication().run(args);
    }

    @Override
    public String getName() {
        return "I18nStore";
    }

    @Override
    public void initialize(Bootstrap<I18nStoreConfiguration> arg0) { }

    @Override
    public void run(I18nStoreConfiguration dc, Environment env) throws Exception {
        env.healthChecks()
                .register("started", new I18nHealthCheck());
        env.jersey()
                .getResourceConfig()
                .packages("i18nstore")
                .register(SelectableEntityFilteringFeature.class)
                .property(SelectableEntityFilteringFeature.QUERY_PARAM_NAME, "select");
    }
}
