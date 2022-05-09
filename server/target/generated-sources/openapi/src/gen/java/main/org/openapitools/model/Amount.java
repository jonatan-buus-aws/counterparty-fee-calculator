package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.model.CURRENCY;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A representation of an amount used through various calculations
 */
@ApiModel(description = "A representation of an amount used through various calculations")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-09T12:24:31.479218+02:00[Europe/Paris]")
public class Amount   {
  @JsonProperty("value")
  private Long value;

  @JsonProperty("currency")
  private CURRENCY currency;

  public Amount value(Long value) {
    this.value = value;
    return this;
  }

  /**
   * The amount value in the currency's smallest unit, i.e. cents, pence etc.
   * minimum: 100
   * @return value
  */
  @ApiModelProperty(example = "1000", required = true, value = "The amount value in the currency's smallest unit, i.e. cents, pence etc.")
  @NotNull

@Min(100L)
  public Long getValue() {
    return value;
  }

  public void setValue(Long value) {
    this.value = value;
  }

  public Amount currency(CURRENCY currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public CURRENCY getCurrency() {
    return currency;
  }

  public void setCurrency(CURRENCY currency) {
    this.currency = currency;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Amount amount = (Amount) o;
    return Objects.equals(this.value, amount.value) &&
        Objects.equals(this.currency, amount.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Amount {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

