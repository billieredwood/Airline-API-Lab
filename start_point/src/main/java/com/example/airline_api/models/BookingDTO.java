package com.example.airline_api.models;

import java.util.List;
// this class is used to save a passengers. used to create an entity, so must include everything that the entity needs.
// we need the DTO's data to write the passenger object.
// this class is not a database entity, but instead creates entities that will be stored in the database.

public class BookingDTO {
    private Long passengerId;

    public BookingDTO(Long id) {
        this.passengerId = passengerId;
    }

    public BookingDTO() {
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }
}





