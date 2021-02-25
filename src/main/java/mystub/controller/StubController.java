package mystub.controller;

import mystub.dto.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mystub.service.StubService;

/**
 * @author Sergey Shilov
 */
@RestController
public class StubController {
    @Autowired
    private StubService service;

    @PostMapping(value = "/")
    public ResponseEntity<?> postEntity(@RequestBody Entity entity) {
        try {
            return ResponseEntity.ok(service.save(entity));
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEntity(@PathVariable String id, @RequestBody Entity entity) {
        try {
            return ResponseEntity.ok(service.update(id, entity));
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEntity(@PathVariable String id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(String.format("Item with id %s deleted", id));
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getEntity(@PathVariable String id) {
        try {
            return ResponseEntity.ok(service.get(id));
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }

    }
}
