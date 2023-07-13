package org.cbioportal.model;

public class Mutation {
	private String sampleUniqueId;
	private String variant;
	private String hugoGeneSymbol;
	private String genePanelStableId;
	private String cancerStudyIdentifier;
	private String geneticProfileStableId;

	public String getSampleUniqueId() {
		return sampleUniqueId;
	}

	public void setSampleUniqueId(String sampleUniqueId) {
		this.sampleUniqueId = sampleUniqueId;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public String getHugoGeneSymbol() {
		return hugoGeneSymbol;
	}

	public void setHugoGeneSymbol(String hugoGeneSymbol) {
		this.hugoGeneSymbol = hugoGeneSymbol;
	}

	public String getGenePanelStableId() {
		return genePanelStableId;
	}

	public void setGenePanelStableId(String genePanelStableId) {
		this.genePanelStableId = genePanelStableId;
	}

	public String getCancerStudyIdentifier() {
		return cancerStudyIdentifier;
	}

	public void setCancerStudyIdentifier(String cancerStudyIdentifier) {
		this.cancerStudyIdentifier = cancerStudyIdentifier;
	}

	public String getGeneticProfileStableId() {
		return geneticProfileStableId;
	}

	public void setGeneticProfileStableId(String geneticProfileStableId) {
		this.geneticProfileStableId = geneticProfileStableId;
	}

}
