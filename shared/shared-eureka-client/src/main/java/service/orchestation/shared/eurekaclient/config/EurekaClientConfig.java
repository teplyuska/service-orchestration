package service.orchestation.shared.eurekaclient.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * There are multiple implementations of "Discovery Service" (eureka, consul, zookeeper).
 * @EnableDiscoveryClient lives in spring-cloud-commons and picks the implementation on the classpath.
 * @EnableEurekaClient lives in spring-cloud-netflix and only works for eureka.
 * If eureka is on your classpath, they are effectively the same.
 */
@Configuration
// @EnableEurekaClient
@EnableDiscoveryClient
// @ComponentScan("service.orchestation.shared.eurekaclient.service")
public class EurekaClientConfig {
}
