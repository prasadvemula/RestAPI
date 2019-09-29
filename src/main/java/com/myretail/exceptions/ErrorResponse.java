package com.myretail.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "errors")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "error"
})
@EqualsAndHashCode
public class ErrorResponse {

    @XmlElement(required = true)
    @JsonProperty("errors")
    private List<APIError> error;

    public ErrorResponse() {
        error = new ArrayList<>();
    }

    public void add(APIError error) {
        this.error.add(error);
    }
}
