package com.kyle.erp.inven.container;

import java.util.List;

public class Containers {
	private List<Container>containers;
	private int containerCount;
	
	public Containers() {
		// TODO Auto-generated constructor stub
	}

	public Containers(List<Container> containers, int containerCount) {
		super();
		this.containers = containers;
		this.containerCount = containerCount;
	}

	public List<Container> getContainers() {
		return containers;
	}

	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}

	public int getContainerCount() {
		return containerCount;
	}

	public void setContainerCount(int containerCount) {
		this.containerCount = containerCount;
	}

	
}
