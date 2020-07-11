package cn.pengitong.sunshine.service;

import cn.pengitong.sunshine.persist.dao.bean.test.*;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class StudentService {

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private CourseRepository courseRepository;

    public List<SC> getSCList() throws InterruptedException, ExecutionException, TimeoutException {
        List<Integer> studentIds = Lists.newArrayList(1,2,3);
        List<Integer> courseIds = Lists.newArrayList(1,2,3);

        StopWatch sw = new StopWatch("test1");
        sw.start();
        CompletableFuture<Iterable<Student>> studentFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                throw new RuntimeException("lall");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            Iterable<Student> allById = studentRepository.findAllById(studentIds);
            return Lists.newArrayList();
        });

        CompletableFuture<Iterable<Course>> courseFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            Iterable<Course> allById = courseRepository.findAllById(courseIds);
            return Lists.newArrayList();
        });

//        Iterable<Student> students0 = studentFuture.get();
//        Iterable<Course> courses0 = courseFuture.get();
//        sw.stop();
//        System.out.println("0耗时时间："+sw.getTotalTimeMillis()+"students0->"+students0+",course0->"+courses0);
//        System.out.println("sw.prettyPrint()~~~~~~~~~~~~~~~~~");
//        System.out.println(sw.prettyPrint());

        CompletableFuture<Void> completableFutureAll = CompletableFuture.allOf(studentFuture, courseFuture);
//        CompletableFuture<Object> completableFutureAny = CompletableFuture.anyOf(studentFuture, courseFuture);
        completableFutureAll.get(3000, TimeUnit.MILLISECONDS);

        Iterable<Student> students = studentFuture.get(0, TimeUnit.MILLISECONDS);
        Iterable<Course> courses = courseFuture.get(0, TimeUnit.MILLISECONDS);
        sw.stop();
        System.out.println("耗时时间："+sw.getTotalTimeMillis());
        System.out.println("students->"+students+",course->"+courses);
//        Object o = completableFutureAny.get(2000, TimeUnit.MILLISECONDS);
//        System.out.println(o.toString());
        return null;
    }
}
