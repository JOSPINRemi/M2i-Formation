package org.example.exercice_api_rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exercice_api_rest.entity.Todo;

/**
 * DTO for {@link org.example.exercice_api_rest.entity.Todo}
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {
    Long id;
    String content;
    boolean status;

    public Todo toEntity() {
        return Todo.builder().content(content).status(status).build();
    }
}