package org.openapitools.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Currency code as defined by ISO-4217 using the numeric codes as values and the alpha-3 codes as names
 */
public enum CURRENCY {
  
  DKK(208),
  
  EUR(978),
  
  GBP(826),
  
  USD(840);

  private Integer value;

  CURRENCY(Integer value) {
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
  public static CURRENCY fromValue(Integer value) {
    for (CURRENCY b : CURRENCY.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

