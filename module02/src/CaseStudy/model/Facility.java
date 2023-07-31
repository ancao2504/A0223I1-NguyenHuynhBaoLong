package CaseStudy.model;

public abstract class  Facility {
    private String serviceCode;
    private String nameService;
    private double areaUse;
    private double fee;
    private int maxPeople;
    private String style;

    public Facility() {
    }

    public Facility(String serviceCode, String nameService, double areaUse, double fee, int maxPeople, String style) {
        this.serviceCode = serviceCode;
        this.nameService = nameService;
        this.areaUse = areaUse;
        this.fee = fee;
        this.maxPeople = maxPeople;
        this.style = style;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return  "serviceCode=" + serviceCode + '\n' +
                "nameService=" + nameService + '\n' +
                "areaUse=" + areaUse +'\n'+
                "fee=" + fee +'\n'+
                "maxPeople=" + maxPeople +'\n'+
                "style='" + style + '\n';
    }
}
