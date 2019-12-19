package user;
import java.util.HashMap;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.Application;
import com.springboot.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Test {
	
	@Autowired
    private UserService userService;

	@org.junit.Test
	public void test(){
		Map<String, Object> params = new HashMap<>();
    	params.put("id", "123");
		String result = userService.getUserRest(params);
		System.out.println(result);
	}
}
