package org.cbioportal.model;

import java.io.Serializable;

public class SampleIdentifier implements Serializable {

	private static final long serialVersionUID = -3970475452038564413L;

	private String sampleId;
	private String studyId;

	public String getSampleId() {
		return sampleId;
	}

	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
	}

	public String getStudyId() {
		return studyId;
	}

	public void setStudyId(String studyId) {
		this.studyId = studyId;
	}

}
