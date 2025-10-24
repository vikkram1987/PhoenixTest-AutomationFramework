package com.api.constants;

public enum Model {
	
NEXUS_2_BLUE(1),GALAXY(2);
	
	int code;
	private Model(int code) {
		this.code=code;
	}
	
	public int getCode() {
		return code;
	}

}

/*
 * 1. Enum constants are like instances of a class
 * When you write:
 * 
 * public enum Model { NEXUS_2_BLUE(1), GALAXY(2);
 * 
 * 
 * you are actually creating two objects (instances) of the enum class Model.
 * 
 * Think of it like:
 * 
 * public static final Model NEXUS_2_BLUE = new Model(1); public static final
 * Model GALAXY = new Model(2);
 * 
 * 2. The enum constructor runs for each constant
 * 
 * When each enum constant is created, Java calls the enum’s constructor with
 * the argument you provided.
 * 
 * private Model(int code) { this.code = code; }
 * 
 * 
 * So when Java creates NEXUS_2_BLUE, it does this internally:
 * 
 * new Model(1);
 * 
 * 
 * Inside the constructor:
 * 
 * The parameter code has the value 1.
 * 
 * The line this.code = code; sets the instance variable code (the one declared
 * in the class) to 1.
 * 
 * For GALAXY, the same thing happens but with 2.
 * 
 * 3. The getCode() method returns that stored value
 * 
 * Later, when you call:
 * 
 * Model.NEXUS_2_BLUE.getCode();
 * 
 * 
 * It accesses the NEXUS_2_BLUE object and runs:
 * 
 * return this.code;
 * 
 * 
 * Since that object’s code field was set to 1 when it was created, it returns
 * 1.
 * 
 * 4. In short
 * 
 * Each enum constant has its own copy of the field code.
 * 
 * The constructor initializes it when the enum constant is created.
 * 
 * The getCode() method just returns that stored value.
 * 
 */
