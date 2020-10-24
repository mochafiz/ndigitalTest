package com.ndigital.sdet.app.model.school;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "name",
        "homework",
        "grade",
        "code"
})
public class Student {

    @JsonProperty("type")
    private String type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("homework")
    private String homework;
    @JsonProperty("grade")
    private Double grade;
    @JsonProperty("code")
    private String code;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Student withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Student withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("homework")
    public String getHomework() {
        return homework;
    }

    @JsonProperty("homework")
    public void setHomework(String homework) {
        this.homework = homework;
    }

    public Student withHomework(String homework) {
        this.homework = homework;
        return this;
    }

    @JsonProperty("grade")
    public Double getGrade() {
        return grade;
    }

    @JsonProperty("grade")
    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Student withGrade(Double grade) {
        this.grade = grade;
        return this;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    public Student withCode(String code) {
        this.code = code;
        return this;
    }

}
