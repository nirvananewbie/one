import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Administrator on 2015/10/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:/spring/applicationContext.xml", "classpath*:/spring/applicationContext-mvc.xml"})
public class MyTest {
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Test
    @Deployment
    public void simpleProcessTest() {
        System.out.println("==========================================");
        runtimeService.startProcessInstanceByKey("simpleProcess");
        Task task = taskService.createTaskQuery().singleResult();
        System.out.println("My Task:" + task.getName());

        taskService.complete(task.getId());
        System.out.println("count:"+runtimeService.createProcessInstanceQuery().count());

    }
}
