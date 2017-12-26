package ru.mtuci.shutov.leonid.server.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	private String data;

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public String getData() {
		return data;
	}

	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public ResponseEntity<String> setData(@RequestBody String data) {
		this.data = data;
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
}
