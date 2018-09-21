package com.internetsaying.web.types;

public enum ClassifyType {

	/**
	 * advice,readme,resource,question,interview,job
	 */
	ADVICE("advice","忠告"),
	README("readme","自述"),
	RESOURCE("resource","资源"),
	QUESTION("question","疑问"),
	INTERVIEW("interview","面经"),
	JOB("job","技能图"),
	;
	public String urlName;
	public String showName;
	
	private ClassifyType(String urlName, String showName) {
		this.urlName = urlName;
		this.showName = showName;
	}
	
	public static String getValueByName(String urlName) {
		for (ClassifyType e : values()) {
			if(e.urlName.equals(urlName)) {
				return e.showName;
			}
		}
		return "";
	}
}
