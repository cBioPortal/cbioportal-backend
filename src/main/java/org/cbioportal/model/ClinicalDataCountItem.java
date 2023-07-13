package org.cbioportal.model;

import java.io.Serializable;
import java.util.List;

public class ClinicalDataCountItem implements Serializable {

	private static final long serialVersionUID = 5218299352625542923L;
	private String attributeId;
	private List<ClinicalDataCount> counts;

	public String getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	public List<ClinicalDataCount> getCounts() {
		return counts;
	}

	public void setCounts(List<ClinicalDataCount> counts) {
		this.counts = counts;
	}

}
