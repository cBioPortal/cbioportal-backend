package org.cbioportal.model;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class AlterationFilter extends BaseAlterationFilter implements Serializable {

	private static final long serialVersionUID = -6619318403942511863L;
	private Map<MutationEventType, Boolean> mutationEventTypes = new HashMap<>();
	private Map<CNA, Boolean> copyNumberAlterationEventTypes = new HashMap<>();
	private Boolean structuralVariants;

	@JsonIgnore
	private Select<MutationEventType> mutationTypeSelect;
	@JsonIgnore
	private Select<CNA> cnaTypeSelect;

	public AlterationFilter() {
	}

	public AlterationFilter(Select<MutationEventType> mutationTypesMap, Select<CNA> cnaEventTypes,
			boolean includeDriver, boolean includeVUS, boolean includeUnknownOncogenicity, boolean includeGermline,
			boolean includeSomatic, boolean includeUnknownStatus, Select<String> tiersSelect,
			boolean includeUnknownTier) {
		this.mutationTypeSelect = mutationTypesMap;
		this.cnaTypeSelect = cnaEventTypes;
		this.includeDriver = includeDriver;
		this.includeVUS = includeVUS;
		this.includeUnknownOncogenicity = includeUnknownOncogenicity;
		this.includeGermline = includeGermline;
		this.includeSomatic = includeSomatic;
		this.includeUnknownStatus = includeUnknownStatus;
		this.tiersSelect = tiersSelect;
		this.includeUnknownTier = includeUnknownTier;
	}

	public Map<MutationEventType, Boolean> getMutationEventTypes() {
		return mutationEventTypes;
	}

	public void setMutationEventTypes(Map<MutationEventType, Boolean> mutationEventTypes) {
		this.mutationEventTypes = mutationEventTypes;
	}

	public Map<CNA, Boolean> getCopyNumberAlterationEventTypes() {
		return copyNumberAlterationEventTypes;
	}

	public void setCopyNumberAlterationEventTypes(Map<CNA, Boolean> copyNumberAlterationEventTypes) {
		this.copyNumberAlterationEventTypes = copyNumberAlterationEventTypes;
	}

	public Boolean getStructuralVariants() {
		return structuralVariants;
	}

	public void setStructuralVariants(Boolean structuralVariants) {
		this.structuralVariants = structuralVariants;
	}

	public Select<MutationEventType> getMutationTypeSelect() {
		return mutationTypeSelect;
	}

	public void setMutationTypeSelect(Select<MutationEventType> mutationTypeSelect) {
		this.mutationTypeSelect = mutationTypeSelect;
	}

	public Select<CNA> getCnaTypeSelect() {
		return cnaTypeSelect;
	}

	public void setCnaTypeSelect(Select<CNA> cnaTypeSelect) {
		this.cnaTypeSelect = cnaTypeSelect;
	}

}
