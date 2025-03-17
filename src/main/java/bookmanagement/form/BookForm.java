package bookmanagement.form;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookForm {
    private UUID uuid;

    private String title;

    private Integer sortOrder;
}
