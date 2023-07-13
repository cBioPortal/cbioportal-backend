package org.cbioportal.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseAlterationFilter implements Serializable {

    private static final long serialVersionUID = 6596325303721113559L;
	protected boolean includeGermline = true;
    protected boolean includeSomatic = true;
    protected boolean includeUnknownStatus = true;
    protected boolean includeDriver = true;
    protected boolean includeVUS = true;
    protected boolean includeUnknownOncogenicity = true;
    protected Map<String, Boolean> tiersBooleanMap = new HashMap<>();
    protected boolean includeUnknownTier = true;

    @JsonIgnore
    protected Select<String> tiersSelect = Select.all();

    // When default constructor is called, the filter is inactive (excludes nothing)
    public BaseAlterationFilter() {
    }

    public BaseAlterationFilter(boolean includeDriver,
                                boolean includeVUS,
                                boolean includeUnknownOncogenicity,
                                boolean includeGermline,
                                boolean includeSomatic,
                                boolean includeUnknownStatus,
                                Select<String> tiersSelect,
                                boolean includeUnknownTier) {
        this.includeGermline = includeGermline;
        this.includeSomatic = includeSomatic;
        this.includeUnknownStatus = includeUnknownStatus;
        this.includeDriver = includeDriver;
        this.includeVUS = includeVUS;
        this.includeUnknownOncogenicity = includeUnknownOncogenicity;
        this.tiersSelect = tiersSelect;
        this.includeUnknownTier = includeUnknownTier;
    }

	public boolean isIncludeGermline() {
		return includeGermline;
	}

	public void setIncludeGermline(boolean includeGermline) {
		this.includeGermline = includeGermline;
	}

	public boolean isIncludeSomatic() {
		return includeSomatic;
	}

	public void setIncludeSomatic(boolean includeSomatic) {
		this.includeSomatic = includeSomatic;
	}

	public boolean isIncludeUnknownStatus() {
		return includeUnknownStatus;
	}

	public void setIncludeUnknownStatus(boolean includeUnknownStatus) {
		this.includeUnknownStatus = includeUnknownStatus;
	}

	public boolean isIncludeDriver() {
		return includeDriver;
	}

	public void setIncludeDriver(boolean includeDriver) {
		this.includeDriver = includeDriver;
	}

	public boolean isIncludeVUS() {
		return includeVUS;
	}

	public void setIncludeVUS(boolean includeVUS) {
		this.includeVUS = includeVUS;
	}

	public boolean isIncludeUnknownOncogenicity() {
		return includeUnknownOncogenicity;
	}

	public void setIncludeUnknownOncogenicity(boolean includeUnknownOncogenicity) {
		this.includeUnknownOncogenicity = includeUnknownOncogenicity;
	}

	public Map<String, Boolean> getTiersBooleanMap() {
		return tiersBooleanMap;
	}

	public void setTiersBooleanMap(Map<String, Boolean> tiersBooleanMap) {
		this.tiersBooleanMap = tiersBooleanMap;
	}

	public boolean isIncludeUnknownTier() {
		return includeUnknownTier;
	}

	public void setIncludeUnknownTier(boolean includeUnknownTier) {
		this.includeUnknownTier = includeUnknownTier;
	}

	public Select<String> getTiersSelect() {
		return tiersSelect;
	}

	public void setTiersSelect(Select<String> tiersSelect) {
		this.tiersSelect = tiersSelect;
	}

}
