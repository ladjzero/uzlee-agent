package test.com.ladjzero.uzlee.parser;

import com.ladjzero.uzlee.parser.ThreadsParser;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.FileInputStream;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * ThreadsParser Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>七月 31, 2016</pre>
 */
public class ThreadsParserTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: parseThreads(InputStream html, ThreadsData res)
     */
    @Test
    public void testParseThreadsAtPage1() throws Exception {
//        ThreadsParser.ThreadsData data = new ThreadsParser.ThreadsData();
//        ThreadsParser.parseThreads(new FileInputStream("testRes/Discovery.htm"), data);
//        assertNotNull(data);
//        assertEquals(data.threads.size(), 75);
//        assertEquals(data.page, 1);
//        assertEquals(data.hasNextPage, true);
//        assertTrue(data.success);
    }

    @Test
    public void testParseThreadsAtPage3() throws Exception {
//        ThreadsParser.ThreadsData data = new ThreadsParser.ThreadsData();
//        ThreadsParser.parseThreads(new FileInputStream("testRes/Discovery_page3.htm"), data);
//        assertNotNull(data);
//        assertEquals(data.threads.size(), 75);
//        assertEquals(data.page, 3);
//        assertEquals(data.hasNextPage, true);
//        assertTrue(data.success);
    }


    /**
     * Method: toThreadObj(Element eThread)
     */
    @Test
    public void testToThreadObj() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ThreadsParser.getClass().getMethod("toThreadObj", Element.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
