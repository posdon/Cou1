package main.model;

import main.model.example.ExampleInterface;
import main.model.example.ExampleManager;

public class ModelFactory {

	public static final ModelFactory INSTANCE = new ModelFactory();
	
	private ExampleInterface exampleInterface;
	
	private ModelFactory() {
		exampleInterface = new ExampleManager();
	}
	
	public ExampleInterface getExampleModel() {
		return exampleInterface;
	}
	
}
