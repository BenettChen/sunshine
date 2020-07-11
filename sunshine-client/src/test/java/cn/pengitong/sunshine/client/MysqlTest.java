package cn.pengitong.sunshine.client;

import cn.pengitong.sunshine.persist.dao.bean.test.*;
import cn.pengitong.sunshine.service.StudentService;
import org.apache.tomcat.util.ExceptionUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlTest {

    private static Student chenpeng = new Student(1, "chenpeng");
    private static Student zhangsan = new Student(2, "zhangsan");
    private static Student lisi = new Student(3, "lisi");
    private Student others = new Student(4, "others");

    private static Course yuwen = new Course(1, "yuwen");
    private static Course shuyue = new Course(2, "yuwen");
    private static Course yingyu = new Course(3, "yuwen");


    @Resource
    private CourseRepository courseRepository;

    @Resource
    private SCRepository scRepository;

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private StudentService studentService;

    @Test
    public void insertStudent() {
        studentRepository.saveAll(Lists.newArrayList(chenpeng, zhangsan, lisi, others));
        for (int i=5;i<=100;i++) {
            studentRepository.save(new Student(i, "others"+i));
        }
    }

    @Test
    public void insertCourse() throws InterruptedException {
        courseRepository.saveAll(Lists.newArrayList(yuwen, shuyue, yingyu));
        for (int i=10000;i<=70000;i++) {
            courseRepository.save(new Course(i, "course"+i));
        }
    }

    @Test
    public void insertSC() {
        LinkedList<SC> scs = new LinkedList<>();
        int k =1;
        for (int i=1;i<=100;i++) {
            for (int j=1;j<=70000;j++) {
                scs.add(new SC(k++, i, j, i));
                if ((j & 1023) == 0) {
                    scRepository.saveAll(scs);
                    scs.clear();
                }
            }
        }
    }

    @Test
    public void query() throws InterruptedException, ExecutionException, TimeoutException {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(null, 1);
        hashMap.put(null, 2);
        hashMap.put(null, 3);
        hashMap.put(null, 4);
        System.out.println(hashMap.size());
    }
}
