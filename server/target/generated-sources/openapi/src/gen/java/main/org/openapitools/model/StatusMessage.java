package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.model.STATUSCODE;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * StatusMessage
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-09T12:24:31.479218+02:00[Europe/Paris]")
public class StatusMessage   {
  @JsonProperty("code")
  private STATUSCODE code;

  @JsonProperty("message")
  private String message;

  public StatusMessage code(STATUSCODE code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public STATUSCODE getCode() {
    return code;
  }

  public void setCode(STATUSCODE code) {
    this.code = code;
  }

  public StatusMessage message(String message) {
    this.message = message;
    return this;
  }

  /**
   * A description of the status code returned by the system
   * @return message
  */
  @ApiModelProperty(example = "Invalid authorization header for end-point: /example. Authorization header must use the HTTP Bearer authentication.", value = "A description of the status code returned by the system")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusMessage statusMessage = (StatusMessage) o;
    return Objects.equals(this.code, statusMessage.code) &&
        Objects.equals(this.message, statusMessage.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusMessage {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

