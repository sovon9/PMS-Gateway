package com.sovon9.RRMS_Gateway;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Aspect
@Component
public class GatewayLoggingService
{
	Logger LOGGER = LoggerFactory.getLogger(GatewayLoggingService.class);
	
	@Before("execution(* com.sovon9.RRMS_Gateway.jwt.JwtAuthenticationFilter.*(..))")
	public void beforeMethod(JoinPoint joinPoint)
	{
		if(joinPoint.getArgs().length>0)
		{
		    
			Object object = (joinPoint.getArgs())[0];
			if(object instanceof ServerWebExchange)
			{
				ServerWebExchange webexchange = (ServerWebExchange) object;
				LOGGER.error("Calling Service Url====> {}", webexchange.getRequest().getPath());
			}
		}
	}
}
