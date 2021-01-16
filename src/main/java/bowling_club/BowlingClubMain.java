package bowling_club;

public class BowlingClubMain {
	
	/* Main class to start the Bowling Game */
	/* Default frame per match is 10. Constants.framesPerGame =10   Change this to update frame size per match*/
	public static void main(String args[]) {
		MatchStarted matchStarted = new MatchStarted();
		matchStarted.startMatch();
		matchStarted.endGame();
	}
}
