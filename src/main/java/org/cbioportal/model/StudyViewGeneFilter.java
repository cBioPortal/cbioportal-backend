package org.cbioportal.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class StudyViewGeneFilter implements Serializable {

    private static final long serialVersionUID = -1824987957857707742L;
	private Set<String> molecularProfileIds;
    private List<List<GeneFilterQuery>> geneQueries;

}
