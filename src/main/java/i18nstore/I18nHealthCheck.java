package i18nstore;

import com.codahale.metrics.health.HealthCheck;

public class I18nHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
