package com.bayside.npa.resource.model;

public class Resource {
    private String id;

    private Integer firmsid;

    private String resourceurl;
    
    private String resourcename;

    public String getResourcename() {
		return resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getFirmsid() {
        return firmsid;
    }

    public void setFirmsid(Integer firmsid) {
        this.firmsid = firmsid;
    }

    public String getResourceurl() {
        return resourceurl;
    }

    public void setResourceurl(String resourceurl) {
        this.resourceurl = resourceurl == null ? null : resourceurl.trim();
    }
}