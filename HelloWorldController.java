import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@RestController
public class HelloWorldController {
    @PostMapping(path = "/hello")
    public String helloWorld(@RequestBody Student student) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        List<Student> students = mapper.readValue(new File("C:/Users/arinr/Downloads/quickstart/quickstart/src/main/resources/student.json"), new TypeReference<List<Student>>() {});
        students.add(student);
        mapper.writeValue(new File("C:/Users/arinr/Downloads/quickstart/quickstart/src/main/resources/student.json"), students);
        return "Hello Arin";
    }
}
