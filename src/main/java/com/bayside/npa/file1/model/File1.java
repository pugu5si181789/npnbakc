package com.bayside.npa.file1.model;

import java.util.List;

public class File1 {
	private String archiveid;
	private String id;
	private String part;
	private String parturl;
	private String partname;
	private List<String> listds;
	public List<String> getListds() {
		return listds;
	}
	public void setListds(List<String> listds) {
		this.listds = listds;
	}
	public String getArchiveid() {
		return archiveid;
	}
	public void setArchiveid(String archiveid) {
		this.archiveid = archiveid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getParturl() {
		return parturl;
	}
	public void setParturl(String parturl) {
		this.parturl = parturl;
	}
	public String getPartname() {
		return partname;
	}
	public void setPartname(String partname) {
		this.partname = partname;
	}
}
