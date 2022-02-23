package google.com.ortona.hashcode.qualification;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import google.com.ortona.hashcode.qualification.io.ProblemReader;
import google.com.ortona.hashcode.qualification.io.ProblemWriter;
import google.com.ortona.hashcode.qualification.logic.ProblemSolver;
import google.com.ortona.hashcode.qualification.model.ProblemContainer;
import google.com.ortona.hashcode.qualification.model.SolutionContainer;
/**
 *
 */
public class ProblemSolverTest {

	private final static ProblemSolver SOLVER = new ProblemSolver();
	private final static ProblemWriter WRITER = new ProblemWriter();
	private final static ProblemReader READER = new ProblemReader();

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Test
	public void firstTest() throws IOException {
		LOG.info("----------------------");
		LOG.info("First test is starting");
		final ProblemContainer p = READER.readProblem("a.txt");
		LOG.info(p.toString());
		final SolutionContainer solution = SOLVER.solve(p);
		Assert.assertNotNull(solution);
		LOG.info("test1 solution: " + solution.toString() + "\nScore: " + solution.getScore());
		Assert.assertTrue(true);

	}

	@Test
	public void testFirstInput() throws IOException {
		//		final String inputFile = "a_example.txt";
		//		final String inputFile = "b_read_on.txt";
		//final String inputFile = "c_incunabula.txt";
		final String inputFile = "d_tough_choices.txt";
		//		final String inputFile = "e_so_many_books.txt";
		//final String inputFile = "f_libraries_of_the_world.txt";

		final ProblemContainer p = READER.readProblem(inputFile);

		final SolutionContainer sC = SOLVER.solve(p);
		WRITER.writeProblem("output_" + inputFile, sC);
		LOG.info("Solution: " + sC.toString() + "\nScore: " + sC.getScore());
	}

}
