import java.util.Date;

public class ProdEpiData {

    private int prodEId,epiNo;
    String epiName,timeDuration,celbName,podName,narName,typeName;
    Date publishedDate;

    public ProdEpiData(int prodEId,int epiNo,String epiName,String timeDuration,String podName,String celbName,
                       Date publishedDate,String narName,String typeName){
        this.prodEId=prodEId;
        this.epiNo=epiNo;
        this.epiName=epiName;
        this.timeDuration=timeDuration;
        this.podName=podName;
        this.celbName=celbName;
        this.publishedDate=publishedDate;
        this.narName=narName;
        this.typeName=typeName;
    }

    public int getProdEId() {
        return prodEId;
    }

    public void setProdEId(int prodEId) {
        this.prodEId = prodEId;
    }

    public int getEpiNo() {
        return epiNo;
    }

    public void setEpiNo(int epiNo) {
        this.epiNo = epiNo;
    }

    public String getEpiName() {
        return epiName;
    }

    public void setEpiName(String epiName) {
        this.epiName = epiName;
    }

    public String getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(String timeDuration) {
        this.timeDuration = timeDuration;
    }

    public String getCelbName() {
        return celbName;
    }

    public void setCelbName(String celbName) {
        this.celbName = celbName;
    }

    public String getPodName() {
        return podName;
    }

    public void setPodName(String podName) {
        this.podName = podName;
    }

    public String getNarName() {
        return narName;
    }

    public void setNarName(String narName) {
        this.narName = narName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString(){
        return (prodEId +" , "+ epiNo +" , "+ epiName +" , "+ timeDuration +" , "+ podName +" , "+ celbName
                +" , "+ publishedDate +" , "+ narName +" , "+ typeName);
    }
}
