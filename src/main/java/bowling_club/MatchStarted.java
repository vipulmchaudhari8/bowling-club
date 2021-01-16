package bowling_club;

import java.util.ArrayList;
import java.util.Scanner;

public class MatchStarted {
	Scanner sc = new Scanner(System.in);

	public void startMatch() {
		Frame frame = null;
		int i = 0;
		ArrayList<Frame> listOfFrames = new ArrayList<Frame>();
		System.out.println("*********************** Game Started **************************");

		do {			
			frame = startFrame();
			calculateFrameScore(listOfFrames, frame);
			displayFrameScore(frame);
			listOfFrames.add(frame);
			i++;
		} while (i < Constants.framesPerGame);

		displayMatchScore(listOfFrames);
		sc.close();
	}

	public Frame startFrame() {
		
		Frame frame = new Frame();
		Roll roll = new Roll();
		roll = startRoll();

		frame.setRoll(roll);
		return frame;

	}

	public Roll startRoll() {
		Roll roll = new Roll();
		int score = 0;

		System.out.print("Enter Roll One score:");
		score = sc.nextInt();
		roll.setRollOneScore(score);

		if (score != Constants.pinsPerFrame) {
			System.out.print("Enter Roll Two score:");
			score = sc.nextInt();
			roll.setRollTwoScore(score);
		} else {
			roll.setRollTwoScore(0);
		}

		if (!validateRollScore(roll)) {
			roll.setRollOneScore(0);
			roll.setRollTwoScore(0);
		}

		return roll;
	}

	public boolean validateRollScore(Roll roll) {
		if (roll.getRollOneScore() + roll.getRollTwoScore() > 10) {
			return false;
		}
		return true;
	}

	public void calculateFrameScore(ArrayList<Frame> listOfFrames, Frame frame) {
		if (listOfFrames.size() == 0) {
			frame.setScore(frame.getRoll().rollOneScore + frame.getRoll().rollTwoScore);
		} else {
			if (isLastFrameSpare(listOfFrames)) { // if Last Frame was Spare
				System.out.println("Last frame was Spare ");
				listOfFrames.get(listOfFrames.size() - 1).setScore(Constants.pinsPerFrame + frame.getRoll().rollOneScore);
			} else if (isLastFrameStrike(listOfFrames)) { // if Last Frame was Spike
				System.out.println("Last frame was Strike ");
				listOfFrames.get(listOfFrames.size() - 1).setScore(Constants.pinsPerFrame + frame.getRoll().rollOneScore + frame.getRoll().rollTwoScore);
			} // Last frame was not spare or spike
			frame.setScore(frame.getRoll().rollOneScore + frame.getRoll().rollTwoScore);
		}
		isItSpareOrSpike(frame);
	}

	public boolean isLastFrameSpare(ArrayList<Frame> listOfFrames) {
		return listOfFrames.get(listOfFrames.size() - 1).isItSpare;
	}

	public boolean isLastFrameStrike(ArrayList<Frame> listOfFrames) {
		return listOfFrames.get(listOfFrames.size() - 1).isItStrike;
	}

	public void isItSpareOrSpike(Frame frame) {
		if (frame.getRoll().getRollOneScore() == 10) {
			frame.setItStrike(true);
			frame.setItSpare(false);
		} else if (frame.getRoll().getRollOneScore() + frame.getRoll().getRollTwoScore() == 10) {
			frame.setItSpare(true);
			frame.setItStrike(false);
		} else {
			frame.setItSpare(false);
			frame.setItStrike(false);
		}
	}

	public void displayFrameScore(Frame frame) {
		System.out.println("Frame Score : " + frame.getScore());
	}

	public void displayMatchScore(ArrayList<Frame> listOfFrames) {
		int matchScore = 0;
		System.out.println("\n" );
		for (int i = 0; i < listOfFrames.size(); i++) {
			System.out.println("Frame " + (i + 1) + " score :" + listOfFrames.get(i).score);
			matchScore = matchScore + listOfFrames.get(i).score;
		}
		System.out.println("Match Score : " + matchScore);

	}
	
	public void endGame() {
		System.out.println("*********************** Game Ended **************************");
	}	
}
