package cn.pengitong.sunshine.service;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;
import cn.pengitong.sunshine.persist.dao.bean.ArticleContentDO;
import cn.pengitong.sunshine.persist.dao.mapper.ArticleContentMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author: chen peng
 * @create: 2019-10-14
 * @description:
 **/
@Service
public class ArticleContentService {

    @Resource
    private ArticleContentMapper articleContentMapper;

    private ExecutorService executorService = new ThreadPoolExecutor(40,40, 10,TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1, true),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    @Transactional
    public void insert(Integer contentId) {
        ArticleContentDO articleContentDO = new ArticleContentDO();
        articleContentDO.setArticleContent("文章内容" + contentId);
        articleContentDO.setContentId(contentId);
        articleContentDO.setGmtCreate(new Date());
        articleContentDO.setGmtModify(new Date());
        articleContentMapper.insert(articleContentDO);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert() {
        Double random =  Math.random() * 1000D;
        long id = random.longValue();
        ArticleContentDO articleContentDO = new ArticleContentDO();
        articleContentDO.setContentId((int)id);
        articleContentDO.setArticleContent("文章内容12" + id);
        articleContentDO.setGmtCreate(new Date());
        articleContentDO.setGmtModify(new Date());
        articleContentMapper.insert(articleContentDO);
    }

    public List<ArticleContentDO> showAll() {
        List<ArticleContentDO> articleContentDOS = articleContentMapper.queryArticleContent();
        return articleContentDOS;
    }

    public Map<Integer, Object> getProductByDealId(List<Integer> delaIds, Set<String> str) throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<List<ArticleContentDO>> listCompletableFuture = CompletableFuture.supplyAsync(() -> articleContentMapper.beatchQuery(delaIds), executorService);
        executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        listCompletableFuture.get(4010, TimeUnit.MILLISECONDS);
        return null;
    }

    public static final int REQUEST_COUNT = 1;
    /*** set the number of requests per second */
    private static final RateLimiter rateLimiter = RateLimiter.create(REQUEST_COUNT);


    protected boolean preHandle() {
        if (!rateLimiter.tryAcquire()) {
            System.out.println(">>>>>>>>>> 亲！请稍后重试！");
            return false;
        }
        System.out.println(">>>>>>>> 恭喜您下单成功！");
        return true;
    }



}
