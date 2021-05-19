package edu.unsj.fcefn.lcc.optimizacion.api.model.domain;


public class StopDTO {

    private Integer id;
    private String name;
    private String city;
    private String province;
    private String country;
    private String latitud;
    private String logitud;
    private Integer ranking;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLogitud() {
        return logitud;
    }

    public void setLogitud(String logitud) {
        this.logitud = logitud;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }




}
