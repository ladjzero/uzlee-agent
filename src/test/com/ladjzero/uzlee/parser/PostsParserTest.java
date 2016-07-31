package test.com.ladjzero.uzlee.parser;

import com.ladjzero.uzlee.parser.Post;
import com.ladjzero.uzlee.parser.PostsParser;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.io.FileInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/** 
* PostsParser Tester. 
* 
* @author <Authors name> 
* @since <pre>七月 31, 2016</pre> 
* @version 1.0 
*/ 
public class PostsParserTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: parseEditablePost(InputStream html, PostData res) 
* 
*/ 
@Test
public void testParseEditablePost() throws Exception {
//TODO: Test goes here... 
} 

/** 
* 
* Method: parsePosts(InputStream html, PostsData res) 
* 
*/ 
@Test
public void testParsePosts() throws Exception {
    PostsParser.PostsData data = new PostsParser.PostsData();
    PostsParser.parsePosts(new FileInputStream("testRes/发布一个客户端.htm"), data);
    assertNotNull(data);
    assertEquals(data.posts.size(), 50);
    assertEquals(data.fid, 2);
    assertEquals(data.title, "发布一个客户端");
    int i = 1;
    for (Post p : data.posts) {
        assertEquals(p.getPostIndex(), i++);
    }
    assertTrue(data.success);
}

/** 
* 
* Method: parseMentions(InputStream html, PostsData res) 
* 
*/ 
@Test
public void testParseMentions() throws Exception {
//TODO: Test goes here...
} 

/** 
* 
* Method: parseMessagesToHtml(InputStream html, PostsData res) 
* 
*/ 
@Test
public void testParseMessagesToHtml() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: toPostObj(Element ePost) 
* 
*/ 
@Test
public void testToPostObj() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PostsParser.getClass().getMethod("toPostObj", Element.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: replaceQuoteLink(Element eBody) 
* 
*/ 
@Test
public void testReplaceQuoteLink() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PostsParser.getClass().getMethod("replaceQuoteLink", Element.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: findSig(Element eBody) 
* 
*/ 
@Test
public void testFindSig() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PostsParser.getClass().getMethod("findSig", Element.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
