package com.sovon9.RRMS_Gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import reactor.core.publisher.Mono;

@Controller
public class Test
{
	@GetMapping("/get")
	public Mono<ResponseEntity<String>> getResponse()
	{
		return Mono.just(ResponseEntity.status(HttpStatus.OK).body(""));
	}
}
