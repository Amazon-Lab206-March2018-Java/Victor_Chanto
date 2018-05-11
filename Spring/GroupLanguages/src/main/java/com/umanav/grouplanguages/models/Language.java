package com.umanav.grouplanguages.models;

import javax.validation.constraints.Size;

public class Language {
	//validation
	@Size(min = 2, max = 20, message = "must be 3-20 characters")
    private String name;
	//validation    
	@Size(min = 2, max = 20, message = "must be 3-20 characters")
    private String creator;
	//validation
	@Size(min = 1, message = "cannot be empty")
    private String version;
	
	public Language() {
	}
	
	public Language(String name, String creator, String version) {
		this.name = name;
		this.creator = creator;
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}


