package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
public class ToDoModel {

    private long id;
    private String title;
    private Category category;
    private LocalDateTime creationDate;
    private LocalDateTime deadlineDate;
    private String description;
    private boolean taskDone;


}
