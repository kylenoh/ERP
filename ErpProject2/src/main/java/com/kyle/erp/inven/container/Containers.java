package com.kyle.erp.inven.container;

import java.util.List;

public class Containers {
	private List<Container>containers;
	
	public Containers() {
		// TODO Auto-generated constructor stub
	}

	public Containers(List<Container> containers) {
		super();
		this.containers = containers;
	}

	public List<Container> getContainers() {
		return containers;
	}

	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}
		
}
