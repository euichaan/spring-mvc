package hello.springmvc.basic.mockito;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ChessPlayer {

	private String name;
	private String category;
	private Integer age;

	private Integer wins;
	private Integer points;

	public ChessPlayer(final String name, final Integer age) {
		this.name = name;
		this.age = age;
	}

	public void assignCategory() throws Exception {
		System.out.println("Assigning category for " + this.name);

		if (this.getAge() < 5) {
			throw new Exception("Player age too low");
		}
		this.category = this.getAge() < 18 ? "Under 18's" : "Senior";
	}

	public void assignScoreStats() {
		System.out.println("Assigning score stats for " + this.name);
		this.wins = 3;
		this.points = 9;
	}
}
