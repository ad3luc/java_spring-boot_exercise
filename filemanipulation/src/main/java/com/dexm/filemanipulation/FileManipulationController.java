package com.dexm.filemanipulation;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Slf4j
@Controller
public class FileManipulationController {

	@Value("${spring.file.path}")
	private String src;

	public void changeCreationDateFile() throws IOException {

		if (StringUtils.isBlank(src)) {

			log.error(String.format("You need to provide a valid path :: %s", src));
			throw new RuntimeException(String.format("You need to provide a valid path the current is invalid :: %s", src));
		}

		try (Stream<Path> paths = Files.walk(Paths.get(src))) {

			paths.filter(Files::isRegularFile).forEach(System.out::println);
		}
	}
}
