package org.openapitools.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * The status codes that may be returned by a system
 */
public enum STATUSCODE {
  
  INVALID_COUNTERPARTY_ID(400001),
  
  COUNTERPARTY_NOT_FOUND(404001);

  private Integer value;

  STATUSCODE(Integer value) {
    this.value = value;
  }

  @JsonValue
  public Integer getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static STATUSCODE fromValue(Integer value) {
    for (STATUSCODE b : STATUSCODE.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

