package com.gamingroom;
import java.util.ArrayList;
import java.util.List;
/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	long id;
	String name;
	private static List<Team> teams = new ArrayList<Team>();
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	private Game() {
	}

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		this();
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	public Team addTeam(String name) {

		// a local Team instance
		Team team = null;

		// iterate over teams look for existing team with the same name 
		for (int i = 0; i < teams.size() - 1; i++) {
			// looks through teams list 
			if (teams.get(i).getName() == name) {
				team = teams.get(i);
			}
		}
		
		// make a new team instance and add to list of teams
		if (team == null) {
			GameService service = GameService.getInstance();
			
			// reference to the GameService instance and then call the getNextTeamId() get the Id and designate to the team.
			team = new Team(service.getNextPlayerId(), name);
			teams.add(team);
		}

		// return the new/existing game instance to the caller
		return team;
	}

	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
