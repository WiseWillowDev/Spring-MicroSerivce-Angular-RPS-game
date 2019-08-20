package FullStack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import FullStack.filters.*;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
//@CrossOrigin(value = "http://localhost:4200")
public class FullStackRpsZuulGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullStackRpsZuulGateWayApplication.class, args);
	}

	@Bean
	public PreFilter getPrefilter() {
		return new PreFilter();
	}
	
	@Bean
	public PostFilter getPostFilter() {
		return new PostFilter();
	}
	
	@Bean
	public ErrorFilter getErrorFilter() {
		return new ErrorFilter();
	}
	
	@Bean
	public RouteFilter getRouteFilter() {
		return new RouteFilter();
	}
}
