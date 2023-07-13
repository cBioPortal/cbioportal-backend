package org.cbioportal.model;

import java.io.Serializable;

public class GenericAssayDataFilter extends DataFilter implements Serializable {
	private static final long serialVersionUID = -6905148919731410827L;
	private String stableId;
	private String profileType;

	public String getStableId() {
		return stableId;
	}

	public void setStableId(String stableId) {
		this.stableId = stableId;
	}

	public String getProfileType() {
		return profileType;
	}

	public void setProfileType(String profileType) {
		this.profileType = profileType;
	}

}
