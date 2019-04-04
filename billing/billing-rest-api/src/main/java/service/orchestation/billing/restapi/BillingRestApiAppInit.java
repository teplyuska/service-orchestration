package service.orchestation.billing.restapi;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;
import service.orchestation.billing.restapi.config.RestApiConfig;

@SpringBootApplication(exclude = GsonAutoConfiguration.class)
@Import(RestApiConfig.class)
public class BillingRestApiAppInit {
    public static void main(String[] args) {
        new SpringApplicationBuilder(BillingRestApiAppInit.class)
                .web(WebApplicationType.SERVLET)
                .bannerMode(Banner.Mode.LOG)
                .run();
    }
}
