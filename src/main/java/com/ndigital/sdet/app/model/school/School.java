package com.ndigital.sdet.app.model.school;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "student",
        "bicycle"
})
public class School {

    @JsonProperty("student")
    private List<Student> student = null;
    @JsonProperty("bicycle")
    private Bicycle bicycle;

    @JsonProperty("student")
    public List<Student> getStudent() {
        return student;
    }

    @JsonProperty("student")
    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public School withStudent(List<Student> student) {
        this.student = student;
        return this;
    }

    @JsonProperty("bicycle")
    public Bicycle getBicycle() {
        return bicycle;
    }

    @JsonProperty("bicycle")
    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    public School withBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
        return this;
    }

}
