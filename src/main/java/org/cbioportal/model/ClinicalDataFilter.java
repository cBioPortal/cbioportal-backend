package org.cbioportal.model;

import java.io.Serializable;

public class ClinicalDataFilter extends DataFilter implements Serializable {
	private static final long serialVersionUID = 8191854184741111852L;
	private String attributeId;

	public String getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

}
