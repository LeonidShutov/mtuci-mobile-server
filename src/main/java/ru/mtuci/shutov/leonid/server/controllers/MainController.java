package ru.mtuci.shutov.leonid.server.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	private static final String DELIMITER = " ";
	private Map<String, String> data = new HashMap<>();

	@RequestMapping(value = "/data/{id}", method = RequestMethod.GET)
	public String getData(@PathVariable String id) {
		return data.get(id);
	}

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public String getAllData() {
		String res = "";
		for (Entry<String, String> entry : data.entrySet()) {
			res = res.concat(DELIMITER).concat(entry.getKey()).concat(DELIMITER).concat(entry.getValue());
		}
		return res;
	}

	@RequestMapping(value = "/data/{id}", method = RequestMethod.POST)
	public ResponseEntity<String> setData(@PathVariable String id, @RequestBody String data) {
		this.data.put(id, data);
		return new ResponseEntity<>(this.data.get(id), HttpStatus.OK);
	}
}
