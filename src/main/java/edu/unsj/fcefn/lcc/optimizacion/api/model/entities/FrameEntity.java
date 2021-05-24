package edu.unsj.fcefn.lcc.optimizacion.api.model.entities;


import javax.persistence.*;
import java.time.LocalTime;


@Entity
    @Table(name = "frames")
    public class FrameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name="id_transport_company")
    private Integer idTransportCompany;
    @Column(name="id_stop_departure")
    private Integer idStopDeparture;
    @Column(name="id_stop_arrival")
    private Integer IdStopArrival;
    @Column(name="price")
    private Float   price;
    @Column(name="category")
    private String category;
    @Column(name="departure_datetime")
    private LocalTime departureDatetime;
    @Column(name="arrival_datetime")
    private LocalTime arrivalDatetime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTransportCompany() {
        return idTransportCompany;
    }

    public void setIdTransportCompany(Integer idTransportCompany) {
        this.idTransportCompany = idTransportCompany;
    }

    public Integer getIdStopDeparture() {
        return idStopDeparture;
    }

    public void setIdStopDeparture(Integer idStopDeparture) {
        this.idStopDeparture = idStopDeparture;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalTime getDepartureDatetime() {
        return departureDatetime;
    }

    public void setDepartureDatetime(LocalTime departureDatetime) {
        this.departureDatetime = departureDatetime;
    }

    public LocalTime getArrivalDatetime() {
        return arrivalDatetime;
    }

    public void setArrivalDatetime(LocalTime arrivalDatetime) {
        this.arrivalDatetime = arrivalDatetime;
    }

    public Integer getIdStopArrival() {
        return IdStopArrival;
    }

    public void setIdStopArrival(Integer idStopArrival) {
        IdStopArrival = idStopArrival;
    }



}
