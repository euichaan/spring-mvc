package hello.springmvc.basic.mockito;

public class Bird {

	private String name;

	public void fly() {
		System.out.println("fly");
	}

	public void walk() {
		System.out.println("walk");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String talk(String sentence) {
		return String.format("%s %s", this.name, sentence);
	}
}
