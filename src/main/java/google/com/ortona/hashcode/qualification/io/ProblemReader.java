package google.com.ortona.hashcode.qualification.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import google.com.ortona.hashcode.qualification.model.Person;
import google.com.ortona.hashcode.qualification.model.ProblemContainer;
import google.com.ortona.hashcode.qualification.model.Project;
import google.com.ortona.hashcode.qualification.model.Skill;

public class ProblemReader {	


	public ProblemContainer readProblem(String fileLocation) throws IOException {
		ProblemContainer pC = new ProblemContainer();
		List<Person> allPeople = new ArrayList<>();
		List<Project> allProjects = new ArrayList<>();
		Map<String, List<Person>> skill2people = new HashMap<>();



		BufferedReader br = new BufferedReader(new InputStreamReader(ProblemReader.class.getResourceAsStream(fileLocation)));

		String []firstLine = br.readLine().split(" ");
		int contrib = Integer.parseInt(firstLine[0]);
		int projects = Integer.parseInt(firstLine[1]);
		for(int i = 0; i< contrib; i++) {
			Person p = readPerson(br,skill2people);
			allPeople.add(p);
		}
		for(int i = 0; i<projects; i++) {
			Project pr = readProject(br);
			allProjects.add(pr);
		}
		br.close();
		pC.PROJECT_LIST = allProjects;
		pC.PERSON_LIST = allPeople;
		pC.SKILL_2_PEOPLE_MAP = skill2people;

		return pC;
	}


	private Project readProject(BufferedReader br) throws IOException {
		String []line = br.readLine().split(" ");
		String name = line[0];
		int duration = Integer.parseInt(line[1]);
		int score = Integer.parseInt(line[2]);
		int bestBeforeDay = Integer.parseInt(line[3]);
		int roles = Integer.parseInt(line[4]);
		Project pr = new Project(name, new ArrayList<>(), bestBeforeDay, duration, score);
		for(int i = 0; i < roles; i++) {
			String []oneL = br.readLine().split(" ");
			pr.getSkillRequiredList().add(new Skill(oneL[0], Integer.parseInt(oneL[1])));
		}
		return pr;
	}


	private Person readPerson(BufferedReader br, Map<String, List<Person>> skill2people) throws IOException {
		String []first = br.readLine().split(" ");
		String name = first[0];
		int totSkills = Integer.parseInt(first[1]);
		Person p = new Person(name, new ArrayList<>());
		for(int i = 0; i< totSkills; i++) {
			String []line = br.readLine().split(" ");
			String skill = line[0];
			int value = Integer.parseInt(line[1]);
			p.getSkillList().add(new Skill(skill, value));
			if(!skill2people.containsKey(skill)) {
				skill2people.put(skill, new LinkedList<>());
			}
			skill2people.get(skill).add(p);
		}
		return p;
	}

}
