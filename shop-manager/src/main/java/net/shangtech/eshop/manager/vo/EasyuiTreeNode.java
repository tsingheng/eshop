package net.shangtech.eshop.manager.vo;

import java.io.Serializable;
import java.util.List;

public class EasyuiTreeNode implements Serializable {
	
    private static final long serialVersionUID = -6644151886014370711L;
    
    public static final String NODE_STATE_CLOSED = "closed";
    public static final String NODE_STATE_OPEN = "open";

	private Long id;
	
	private String text;
	
	private List<EasyuiTreeNode> children;
	
	private String state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<EasyuiTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<EasyuiTreeNode> children) {
		this.children = children;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
