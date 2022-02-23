package google.com.ortona.hashcode.qualification.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import google.com.ortona.hashcode.qualification.model.ProblemContainer;

public class ProblemReader {	
	private final Logger LOG = LoggerFactory.getLogger(getClass());


	public ProblemContainer readProblem(String fileLocation) throws IOException {
		ProblemContainer pC = new ProblemContainer();

		BufferedReader br = new BufferedReader(new InputStreamReader(ProblemReader.class.getResourceAsStream(fileLocation)));

		String []firstLine = br.readLine().split(" ");
		LOG.info(String.join("" ,firstLine));
		
		br.close();
		return pC;
	}

}
