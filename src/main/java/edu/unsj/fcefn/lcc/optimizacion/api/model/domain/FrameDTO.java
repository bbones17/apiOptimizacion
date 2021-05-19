package edu.unsj.fcefn.lcc.optimizacion.api.model.domain;
import java.time.LocalTime;

public class FrameDTO {

        private Integer id;
        private Integer idTransportCompany;
        private Integer idStopDeparture;
        private Integer idStopArrival;
        private Float   price;
        private String category;
        private LocalTime departureDatetime;
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

        public Integer getIdStopArrival() {
            return idStopArrival;
        }

        public void setIdStopArrival(Integer idStopArrival) {
            this.idStopArrival = idStopArrival;
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

}



