package com.wen.security.model;



import java.io.Serializable;

import com.wen.security.util.FieldMeta;

/**
 * User: daiwx [sble.net]
 * @version 1.0
 */
public class TM1CopaParam implements Serializable {
    private static final long serialVersionUID = -2952248345440612491L;
    
    @FieldMeta(name="year")
    private String fiscalYear; // required
    @FieldMeta
    private String perion; // required (003 --> contains (001 002 003) )
    @FieldMeta
    private String sourceSyetem; // Optional (if blank, all systems are selected it seems like as sourceSyetemId  "project_one ")
    @FieldMeta(value="haha")
    private String leUniversal; //  Optional (if blank, all LEs are selected  it seems like as leCode)
    private String mrcUniversal; // Optional (if blank, all MRC are selected it seems likes as mrcCode )
    private String[] groupByKey; // groupByKey
    private boolean useLucene = true;
    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getPerion() {
        return perion;
    }

    public void setPerion(String perion) {
        this.perion = perion;
    }

    public String getSourceSyetem() {
        return sourceSyetem;
    }

    public void setSourceSyetem(String sourceSyetem) {
        this.sourceSyetem = sourceSyetem;
    }

    public String getLeUniversal() {
        return leUniversal;
    }

    public void setLeUniversal(String leUniversal) {
        this.leUniversal = leUniversal;
    }

    public String getMrcUniversal() {
        return mrcUniversal;
    }

    public void setMrcUniversal(String mrcUniversal) {
        this.mrcUniversal = mrcUniversal;
    }

    public boolean isUseLucene() {
        return useLucene;
    }

    public void setUseLucene(boolean useLucene) {
        this.useLucene = useLucene;
    }



    public String[] getGroupByKey() {
		return groupByKey;
	}

	public void setGroupByKey(String[] groupByKey) {
		this.groupByKey = groupByKey;
	}

	@Override
    public String toString() {
        return "TM1CopaParam{" +
                "fiscalYear='" + fiscalYear + '\'' +
                ", perion='" + perion + '\'' +
                ", sourceSyetem='" + sourceSyetem + '\'' +
                ", leUniversal='" + leUniversal + '\'' +
                ", mrcUniversal='" + mrcUniversal + '\'' +
                ", useLucene=" + useLucene +
                '}';
    }
}
