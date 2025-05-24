package demo.request;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class InQueryRequest {

	private List<String> firstNames;
}
