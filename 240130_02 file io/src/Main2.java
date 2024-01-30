import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

class Ball {
	private int[] winningNum;
	private int bonusNum;

	public Ball() {
	}

	public Ball(int[] winningNum, int bonusNum) {
		this.winningNum = winningNum;
		this.bonusNum = bonusNum;
	}

	public int[] getWinningNum() {
		return winningNum;
	}

	public void setWinningNum(int[] winningNum) {
		this.winningNum = winningNum;
	}

	public int getBonusNum() {
		return bonusNum;
	}

	public void setBonusNum(int bonusNum) {
		this.bonusNum = bonusNum;
	}
}

class Games {
	private Map<String, int[]> games;

	public Games(Map<String, int[]> games) {
		this.games = games;
	}

	public Map<String, int[]> getGames() {
		return games;
	}
}

public class Main2 {
	public static void main(String[] args) {
		Gson gson = new Gson();
		int[] ball = { 1, 2, 3, 4, 5, 6 };
		Ball balls = new Ball(ball, 7);

		int[] game1 = { 11, 22, 33, 34, 44, 45 };
		int[] game2 = { 4, 5, 6, 10, 11, 12 };

		Map<String, int[]> gamesMap = new HashMap<>();
		gamesMap.put("game1", game1);
		gamesMap.put("game2", game2);

		Games games = new Games(gamesMap);

		String jsonStringGames = gson.toJson(games);
		String jsonStringBalls = gson.toJson(balls);
		System.out.println(jsonStringBalls);
		System.out.println(jsonStringGames);
		System.out.println();

		System.out.println("game1의 맞는 숫자는 " + count(balls, game1));
		System.out.println("game2의 맞는 숫자는 " + count(balls, game2));
	}

	private static int count(Ball balls, int[] game) {
		int count = 0;
		for (int i : game) {
			for (int b : balls.getWinningNum()) {
				if (i == b) {
					count++;
				}
			}

		}
		return count;
	}

}
