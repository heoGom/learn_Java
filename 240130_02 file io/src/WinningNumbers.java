import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WinningNumbers {
	private int[] winningNum;
	private int bonusNum;
	
	public WinningNumbers(int[] winningNum, int bonusNum) {
		super();
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
	
	public static void main(String[] args) {
		WinningNumbers nums = new WinningNumbers(new int[] {1,2,3,4,5,6}, 7);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonText = gson.toJson(nums);
		
		System.out.println(jsonText);
		
	}
}





