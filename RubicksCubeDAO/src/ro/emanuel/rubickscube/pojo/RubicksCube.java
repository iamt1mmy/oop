package ro.emanuel.rubickscube.pojo;

public class RubicksCube {

	private int id;
	private String brand;
	private double weight;
	private int sides;
	
	public RubicksCube(int id, String brand, double weight, int sides) {
		super();
		this.setId(id);
		this.setBrand(brand);
		this.setWeight(weight);
		this.setSides(sides);
	}

	public RubicksCube(String brand, double weight, int sides) {
		super();
		this.setBrand(brand);
		this.setWeight(weight);
		this.setSides(sides);
	}

	public RubicksCube() {
		super();
	}
	
	@Override
	public String toString() {
		return "RubicksCube [id=" + id + ", brand=" + brand + ", weight=" + weight + ", sides=" + sides + "]";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}

	
	
	
}
