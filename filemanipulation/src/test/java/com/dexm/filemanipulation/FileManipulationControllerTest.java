package com.dexm.filemanipulation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test") // Like this
public class FileManipulationControllerTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Autowired
	private FileManipulationController fileManipulationController;

	@Test
	public void changeCreationDateFile() throws IOException {

		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage(is("You need to provide a valid path the current is invalid :: "));

		fileManipulationController.changeCreationDateFile();
	}
}