package mx.com.dxesoft.lunchtime.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document
@Data
@ApiModel(description = "Class representing the 'Horario de comida'.")
public class HorarioDeComida implements Serializable {

    @Id
    @ApiModelProperty(value = "Unique identifier for the Horario comida.", required = true)
    private String id;

    @NotNull
    @Field("name")
    @ApiModelProperty(value = "Name for the horario de comida", required = true)
    private String name;

    @NotNull
    @Field("active")
    @ApiModelProperty(value = "Indicates if the horario is active for the week menu.", required = true)
    private Boolean active;
}
