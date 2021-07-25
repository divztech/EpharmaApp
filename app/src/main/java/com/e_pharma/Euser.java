package com.e_pharma;

public class Euser {
    String Date_Of_Test,EID,HspID,Name,PTID,PcrNo,PresNo,Results,MedPckg,MedQty,MEDN1,MEDN2,MEDN3,MEDQ1,MEDQ2,MEDQ3,MEDC1,MEDC2,MEDC3,MEDTC;


    public Euser(){
    }

    public String getMEDN1() {
        return MEDN1;
    }

    public void setMEDN1(String MEDN1) {
        this.MEDN1 = MEDN1;
    }


    public Euser(String EID, String PcrNo, String Date_Of_Test, String PTID, String HspID, String Name, String Results, String PresNo, String MedPckg, String MEDN1, String MEDN2, String MEDN3, String MEDQ1, String MEDQ2, String MEDQ3, String MEDC1, String MEDC2, String MEDC3, String MEDTC) {
        this.EID = EID;
        this.PcrNo=PcrNo;

        this.Name=Name;
        this.Results= Results;
        this.Date_Of_Test=Date_Of_Test;

        this.PTID=PTID;
        this.HspID=HspID;

        this.PresNo=PresNo;
        this.MedPckg=MedPckg;

        this.MEDN1=MEDN1;
       this.MEDN2=MEDN2;
        this.MEDN3=MEDN3;
        this.MEDQ1=MEDQ1;
        this.MEDQ2=MEDQ2;
        this.MEDQ3=MEDQ3;
        this.MEDC1=MEDC1;
        this.MEDC2=MEDC2;
        this.MEDC3=MEDC3;
        this.MEDTC = MEDTC;



    }

    public String getMEDTC() {
        return MEDTC;
    }

    public void setMEDTC(String MEDTC) {
        this.MEDTC = MEDTC;
    }

    public String getMEDQ2() {
        return MEDQ2;
    }

    public void setMEDQ2(String MEDQ2) {
        this.MEDQ2 = MEDQ2;
    }

    public String getMEDQ3() {
        return MEDQ3;
    }

    public void setMEDQ3(String MEDQ3) {
        this.MEDQ3 = MEDQ3;
    }

    public String getMEDC1() {
        return MEDC1;
    }

    public void setMEDC1(String MEDC1) {
        this.MEDC1 = MEDC1;
    }

    public String getMEDC2() {
        return MEDC2;
    }

    public void setMEDC2(String MEDC2) {
        this.MEDC2 = MEDC2;
    }

    public String getMEDC3() {
        return MEDC3;
    }

    public void setMEDC3(String MEDC3) {
        this.MEDC3 = MEDC3;
    }

    public String getMEDQ1() {
        return MEDQ1;
    }

    public void setMEDQ1(String MEDQ1) {
        this.MEDQ1 = MEDQ1;
    }

    public String getMEDN3() {
        return MEDN3;
    }

    public void setMEDN3(String MEDN3) {
        this.MEDN3 = MEDN3;
    }

    public String getMEDN2() {
        return MEDN2;
    }

    public void setMEDN2(String MEDN2) {
        this.MEDN2 = MEDN2;
    }

    public String getMedQty() {
        return MedQty;
    }

    public void setMedQty(String medQty) {
        MedQty = medQty;
    }


    public String getMedPckg() {
        return MedPckg;
    }

    public void setMedPckg(String medPckg) {
        MedPckg = medPckg;
    }

    public String getPresNo() {
        return PresNo;
    }

    public void setPresNo(String presNo) {
        PresNo = presNo;
    }

    public String getEID() {
        return EID;
    }

    public void setEID(String EID) {
        this.EID = EID;
    }

    public String getPcrNo() {
        return PcrNo;
    }

    public void setPcrNo(String pcrNo) {
        PcrNo = pcrNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getResults() {
        return Results;
    }

    public void setResults(String results) {
        Results = results;
    }

    public String getHspID() {
        return HspID;
    }

    public void setHspID(String hspID) {
        HspID = hspID;
    }

    public String getPTID() {
        return PTID;
    }

    public void setPTID(String PTID) {
        this.PTID = PTID;
    }

    public String getDate_Of_Test() {
        return Date_Of_Test;
    }

    public void setDate_Of_Test(String date_Of_Test) {
        Date_Of_Test = date_Of_Test;
    }
}