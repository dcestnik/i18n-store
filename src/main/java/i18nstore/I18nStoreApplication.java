package i18nstore;

import i18nstore.resource.I18nStoreCountryResource;
import i18nstore.resource.I18nStoreLanguageResource;
import i18nstore.resource.I18nStoreLocaleResource;
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
    public void initialize(Bootstrap<I18nStoreConfiguration> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void run(I18nStoreConfiguration dc, Environment env) throws Exception {
        env.healthChecks().register("started", new I18nHealthCheck());
        env.jersey().register(I18nStoreLocaleResource.class);
        env.jersey().register(I18nStoreLanguageResource.class);
        env.jersey().register(I18nStoreCountryResource.class);
    }
}
