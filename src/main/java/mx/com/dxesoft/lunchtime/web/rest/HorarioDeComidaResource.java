package mx.com.dxesoft.lunchtime.web.rest;

import io.swagger.annotations.*;
import mx.com.dxesoft.lunchtime.domain.HorarioDeComida;
import mx.com.dxesoft.lunchtime.service.HorarioDeComidaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@Api(value = "HorariosResource", description = "Horarios de comida API")
@CrossOrigin
public class HorarioDeComidaResource {

    private final Logger log = LoggerFactory.getLogger(HorarioDeComidaResource.class);

    private final HorarioDeComidaService horarioDeComidaService;

    @Autowired
    public HorarioDeComidaResource(HorarioDeComidaService horarioDeComidaService) {
        this.horarioDeComidaService = horarioDeComidaService;
    }

    @ApiOperation(value = "Gets all the Horarios de comida", nickname = "findAll", notes = "Examples: Breakfast, Lunch, Dinner, Snacks", response = HorarioDeComida.class, responseContainer = "List", authorizations = {
        @Authorization(value = "lunch_auth", scopes = {
                @AuthorizationScope(scope = "write:horariosdecomida", description = "modify the horarios de comida"),
                @AuthorizationScope(scope = "read:horariosdecomida", description = "read the horarios de comida")
        })
    }, tags = {"horario-de-comida-resource"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation", response = HorarioDeComida.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid status value")
    })
    @GetMapping(path = "/horariodecomida",
        produces = { "application/json" })
    public ResponseEntity<List<HorarioDeComida>> findAll() {
        log.debug("REST request to get all the Horarios de comida");

        List<HorarioDeComida> horarioDeComidas = horarioDeComidaService.findAll();

        return new ResponseEntity<List<HorarioDeComida>>(horarioDeComidas, HttpStatus.OK);
    }

    @ApiOperation(value = "Save horarios de comida", nickname = "Save", response = HorarioDeComida.class, authorizations = {
            @Authorization(value = "lunch_auth", scopes = {
                    @AuthorizationScope(scope = "write:horariosdecomida", description = "modify the horarios de comida"),
                    @AuthorizationScope(scope = "read:horariosdecomida", description = "read the horarios de comida")
            })
    }, tags = {"horario-de-comida-resource"})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Instance created", response = HorarioDeComida.class),
            @ApiResponse(code = 405, message = "Invalid input")
    })
    @PostMapping(path = "/horariodecomida",
        produces = { "application/json" })
    public ResponseEntity<HorarioDeComida> addHorario(@ApiParam(value = "Horario de comida to be saved", required = true)
                                                          @Valid @RequestBody HorarioDeComida horarioDeComida) throws URISyntaxException {
        log.debug("REST request to create a new 'Horario de comida'");

        HorarioDeComida result = horarioDeComidaService.save(horarioDeComida);

        return ResponseEntity.created(new URI("/api/v1/horarios/" + result.getId()))
                .body(result);
    }

    @ApiOperation(value = "Update horarios de comida", nickname = "Update", response = HorarioDeComida.class, authorizations = {
            @Authorization(value = "lunch_auth", scopes = {
                    @AuthorizationScope(scope = "write:horariosdecomida", description = "modify the horarios de comida"),
                    @AuthorizationScope(scope = "read:horariosdecomida", description = "read the horarios de comida")
            })
    }, tags = {"horario-de-comida-resource"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = HorarioDeComida.class),
            @ApiResponse(code = 405, message = "Invalid input")
    })
    @PutMapping(path = "/horariodecomida",
            produces = { "application/json" })
    public ResponseEntity<HorarioDeComida> updateHorario(@ApiParam(value = "Horario de comida to be updated", required = true)
                                                             @Valid @RequestBody HorarioDeComida horarioDeComida) {
        log.debug("REST request to update a new 'Horario de comida'");

        if (horarioDeComida.getId() != null) {
            HorarioDeComida result = horarioDeComidaService.update(horarioDeComida);

            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation(value = "Deletes an horarios de comida", nickname = "Delete", authorizations = {
            @Authorization(value = "lunch_auth", scopes = {
                    @AuthorizationScope(scope = "write:horariosdecomida", description = "modify the horarios de comida"),
                    @AuthorizationScope(scope = "read:horariosdecomida", description = "read the horarios de comida")
            })
    }, tags = {"horario-de-comida-resource"})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Horario not found")
    })
    @DeleteMapping("/horariodecomida/{id}")
    ResponseEntity<Void> deleteHorario(@ApiParam(value = "Horario de comida Id to be deleted", required = true) @PathVariable String id) {
        log.debug("REST Request to delete an 'Horario de comida'");

        horarioDeComidaService.delete(id);

        return ResponseEntity.ok().build();
    }

    //TODO implement RSQL as query language to find only the active horarios to schedule a weekly menu.  https://aboullaite.me/rsql/
//    @ApiOperation(value = "Find active horarios de comida", nickname = "Find active", authorizations = {
//            @Authorization(value = "lunch_auth", scopes = {
//                    @AuthorizationScope(scope = "write:horariosdecomida", description = "modify the horarios de comida"),
//                    @AuthorizationScope(scope = "read:horariosdecomida", description = "read the horarios de comida")
//            })
//    }, tags = {"horario-de-comida-resource"})
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "successful operation", response = HorarioDeComida.class, responseContainer = "List"),
//            @ApiResponse(code = 400, message = "Invalid status value")
//    })
//    @GetMapping("/horariodecomida")
}
