//package cn.pengitong.sunshine.client;
//
//import cn.pengitong.sunshine.persist.dao.bean.ArticleContentDO;
//import cn.pengitong.sunshine.persist.dao.mapper.ArticleContentMapper;
//import cn.pengitong.sunshine.service.ArticleContentService;
//import cn.pengitong.sunshine.service.model.UserModel;
//import cn.pengitong.sunshine.utils.JsonUtils;
//import com.google.common.collect.Lists;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import tools.WarrantyClaimResponse;
//
//import javax.annotation.Resource;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SunshineApplicationTests {
//
//    @Resource
//    private ArticleContentMapper articleContentMapper;
//
//    @Resource
//    private ArticleContentService articleContentService;
//
//    @Resource
//    private UserModel userModel;
//
//    @Test
//    public void test5() {
//        System.out.println(userModel);
//    }
//
//    @Test
//    public void contextLoads() {
//        List<ArticleContentDO> articleContentDOS = articleContentMapper.queryArticleContent();
//        System.out.println(articleContentDOS);
//    }
//
//    @Test
//    public void should_add_data_2_database_when_insert_data_given_one_entity() {
//        Integer contentId = 102;
//
//        try {
//            articleContentService.insert(contentId);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        ArticleContentDO result = articleContentMapper.queryArticleContentByContentId(contentId);
//        Assert.assertNotNull(result);
//    }
//    @Test
//    public void test() {
//        ArrayList<Character> characters = Lists.newArrayList('1');
//        boolean contains = characters.contains(null);
//        System.out.println(contains);
//    }
//
//    private ArticleContentDO mockArticleContentDO(Integer contentId) {
//        ArticleContentDO articleContentDO = new ArticleContentDO();
//        articleContentDO.setArticleContent("文章内容" + contentId);
//        articleContentDO.setContentId(contentId);
//        articleContentDO.setGmtCreate(new Date());
//        articleContentDO.setGmtModify(new Date());
//        return articleContentDO;
//    }
//
//    @Test
//    public void test2() throws IOException {
//        String content = getContent();
//        content = content.replaceAll(",", "\",\"");
//        content = content.replaceAll(":", "\":\"");
//        content = content.replaceAll("\\{", "{\"");
//        content = content.replaceAll("}", "\"}");
//        content = content.replaceAll(" ", "");
//        content = content.replaceAll("\"\\[", "[");
//        content = content.replaceAll("]\"", "]");
//        content = content.replaceAll("\"\\{", "{");
//        content = content.replaceAll("}\"", "}");
//
//        System.out.println(content);
//        WarrantyClaimResponse warrantyClaimResponse = JsonUtils.jsonToObjectSilent(content, WarrantyClaimResponse.class);
//        System.out.println(warrantyClaimResponse);
//    }
//
//    private String getContent() {
//        return " " +
//                "{ parentId :null, contributionId :8485, claimable :true, productCode :null, businessCode : CLA92222 , totalAmount :647.7, claimAmount :171.45, customerShareAmount :476.25, handlingFee :25.91, claimUnitPrice :647.7, valid :true, errorCode :null, children :[], invalid :false, id :473422650836815872}"
//                + "";
//    }
//
//    private String getFormatContent() {
//        return "" +
//                "{\"parentId\":\"null\",\"contributionId\":\"8485\",\"claimable\":\"true\",\"productCode\":\"null\",\"businessCode\":\"CLA92222\",\"totalAmount\":\"647.7\",\"claimAmount\":\"171.45\",\"customerShareAmount\":\"476.25\",\"handlingFee\":\"25.91\",\"claimUnitPrice\":\"647.7\",\"valid\":\"true\",\"errorCode\":\"null\",\"children\":\"[]\",\"invalid\":\"false\",\"id\":\"473422650836815872\"}\n"
//                + "";
//    }
//
//}
