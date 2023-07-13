package org.cbioportal.model;

import java.io.Serializable;
import java.util.List;

public class ClinicalDataCountFilter implements Serializable {

    private static final long serialVersionUID = 555516545169449040L;
	private List<ClinicalDataFilter> attributes;
    private StudyViewFilter studyViewFilter;
    
	public List<ClinicalDataFilter> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<ClinicalDataFilter> attributes) {
		this.attributes = attributes;
	}
	public StudyViewFilter getStudyViewFilter() {
		return studyViewFilter;
	}
	public void setStudyViewFilter(StudyViewFilter studyViewFilter) {
		this.studyViewFilter = studyViewFilter;
	}

    
}
