package service.orchestation.shared.feign.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * There are multiple implementations of "Discovery Service" (eureka, consul, zookeeper).
 * @EnableDiscoveryClient lives in spring-cloud-commons and picks the implementation on the classpath.
 * @EnableEurekaClient lives in spring-cloud-netflix and only works for eureka.
 * If eureka is on your classpath, they are effectively the same.
 */
@Configuration
// @EnableDiscoveryClient
@EnableFeignClients
// @RibbonClients
public class SharedFeignConfig {
}
