package local.learnspring;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
@RequiredArgsConstructor
public class BaseController {

    private final JdbcTemplate jdbcTemplate;

    @GetMapping("test")
    public String test(){
        String sql = "create table if not exists test_table (" +
                "id int auto_increment primary key, " +
                "name varchar(255) not null) ";
//                ")";
        jdbcTemplate.execute(sql);
        return "đã tạo thành công";
    }

}
