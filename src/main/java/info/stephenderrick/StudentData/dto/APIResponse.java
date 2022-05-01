package info.stephenderrick.StudentData.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse <T>{
    private int recordCount;
    T response;
}
