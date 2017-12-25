package model;

import java.util.List;

public class MenuInfo extends Menu{

	private List<Menu> child;

	public List<Menu> getChild() {
		return child;
	}

	public void setChild(List<Menu> child) {
		this.child = child;
	}
	
}
