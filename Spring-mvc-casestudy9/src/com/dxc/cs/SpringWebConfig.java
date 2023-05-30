package com.dxc.cs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@ComponentScan(basePackages = {"com.dxc.cs"})
public class SpringWebConfig {
	@Bean(name="viewResolver")
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setViewClass(JstlView.class);
		vr.setPrefix("/WEB-INF/pages/");
		vr.setSuffix(".jsp");
		vr.setOrder(1); // top priority
		return vr;
	}

}
