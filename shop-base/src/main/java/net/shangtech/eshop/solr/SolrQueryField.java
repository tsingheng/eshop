package net.shangtech.eshop.solr;

public abstract class SolrQueryField {
	
	private String fieldName;
	
	public abstract String getQueryString();

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
}
