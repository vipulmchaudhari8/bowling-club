package bowling_club;

public class Frame {

	Roll roll;
	int score;
	boolean isItSpare;
	boolean isItStrike;
	
	public boolean isItSpare() {
		return isItSpare;
	}

	public void setItSpare(boolean isItSpare) {
		this.isItSpare = isItSpare;
	}

	public boolean isItStrike() {
		return isItStrike;
	}

	public void setItStrike(boolean isItStrike) {
		this.isItStrike = isItStrike;
	}


	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Roll getRoll() {
		return roll;
	}

	public void setRoll(Roll roll) {
		this.roll = roll;
	}


}
