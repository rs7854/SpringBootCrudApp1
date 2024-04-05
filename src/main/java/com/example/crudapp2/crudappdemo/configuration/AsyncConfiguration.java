package com.example.crudapp2.crudappdemo.configuration;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfiguration {

//	ThreadPoolExecutor thread;
	
	@Bean("asyncTaskExecutor")
	public Executor asyncTaskExecutor() {
		ThreadPoolTaskExecutor taskexecutor = new ThreadPoolTaskExecutor();
		taskexecutor.setCorePoolSize(4);
		taskexecutor.setQueueCapacity(150);
		taskexecutor.setMaxPoolSize(4);
		taskexecutor.setThreadNamePrefix("AsyncTaskThread-");
		taskexecutor.initialize();
		
		return taskexecutor;
		
	}
}
