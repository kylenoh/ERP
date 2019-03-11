package com.kyle.erp.inven.container;

import java.util.List;

public interface ContainerMapper {
	public abstract int regContainer(Container container);
	public abstract int getContainerCount();
	public abstract List<Container>getContainer(ContainerNo containerno);
	public abstract List<Container>searchContainer(SearchContainer s);
	public abstract int updateContainer(Container container);
	public abstract int deleteContainer(Container container);
}
