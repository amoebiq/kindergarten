package com.amoebiq.ssa.config;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.couchbase.client.spring.cache.CacheBuilder;

@Configuration
@EnableCaching
public class CacheConfig implements CachingConfigurer{
	
	private static final Logger logger = LogManager.getLogger(CacheConfig.class);
	
	@Bean
	@Override
	public CacheManager cacheManager() {
		// TODO Auto-generated method stub
		SimpleCacheManager scm = new SimpleCacheManager();
		GuavaCache studentCache = new GuavaCache("studentCache", com.google.common.cache.CacheBuilder.newBuilder()
																					  .expireAfterAccess(3, TimeUnit.MINUTES)
																					  .build());
		GuavaCache classCache = new GuavaCache("classCache", com.google.common.cache.CacheBuilder.newBuilder()
				  .expireAfterAccess(3, TimeUnit.MINUTES)
				  .build());

		scm.setCaches(Arrays.asList(studentCache,classCache));
		
		return scm;
	}

	@Override
	public CacheResolver cacheResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CacheErrorHandler errorHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KeyGenerator keyGenerator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
