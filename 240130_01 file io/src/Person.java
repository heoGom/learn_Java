import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2687380973518114908L;
	
	private String name;
	private int height;
	private double weight;
	private boolean married;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + ", weight=" + weight + ", married=" + married + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public Person(String name, int height, double weight, boolean married) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.married = married;
	}

}
