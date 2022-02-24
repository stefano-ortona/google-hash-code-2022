package google.com.ortona.hashcode.qualification;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import google.com.ortona.hashcode.qualification.io.ProblemReader;
import google.com.ortona.hashcode.qualification.io.ProblemWriter;
import google.com.ortona.hashcode.qualification.logic.ProblemSolver;
import google.com.ortona.hashcode.qualification.model.Person;
import google.com.ortona.hashcode.qualification.model.ProblemContainer;
import google.com.ortona.hashcode.qualification.model.Project;
import google.com.ortona.hashcode.qualification.model.Skill;
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
		
		final Person anna = new Person("Anna", Arrays.asList(new Skill("C++", 2)));
		final Person bob = new Person("Bob", Arrays.asList(new Skill("HTML",5), new Skill("CSS", 5)));
		final Person maria = new Person("Maria", Arrays.asList(new Skill("Python", 3)));
		final Project p0 = new Project("Logging", Arrays.asList(new Skill("C++", 3)), 5, 5, 10);
		final Project p1 = new Project("WebServer", Arrays.asList(new Skill("HTML", 3), new Skill("C++", 2)), 7, 7, 10);
		final Project p2 = new Project("WebChat", Arrays.asList(new Skill("Python", 3), new Skill("HTML", 3)), 20, 10, 20);
		final ProblemContainer p = new ProblemContainer();
		p.PERSON_LIST = Arrays.asList(anna, bob, maria);
		p.PROJECT_LIST = Arrays.asList(p0, p1, p2);
		p.SKILL_2_PEOPLE_MAP = new HashMap<String, List<Person>>();
		p.SKILL_2_PEOPLE_MAP.put("C++", Arrays.asList(anna));
		p.SKILL_2_PEOPLE_MAP.put("HTML", Arrays.asList(bob));
		p.SKILL_2_PEOPLE_MAP.put("CSS", Arrays.asList(bob));
		p.SKILL_2_PEOPLE_MAP.put("Python", Arrays.asList(maria));
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
