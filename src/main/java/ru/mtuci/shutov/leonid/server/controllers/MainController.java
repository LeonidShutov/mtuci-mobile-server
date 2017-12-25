package ru.mtuci.shutov.leonid.server.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@RequestMapping("/data")
	public List<String> getData() {
		List<String> data = Arrays.asList("data1", "data2", "data3");
		return data;
	}
}
