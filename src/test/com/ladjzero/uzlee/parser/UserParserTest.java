package test.com.ladjzero.uzlee.parser;

import com.ladjzero.uzlee.parser.UserParser;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.FileInputStream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * UserParser Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>七月 31, 2016</pre>
 */
public class UserParserTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: parseUser(InputStream html, UserData res)
     */
    @Test
    public void testParseUser() throws Exception {
        UserParser.UserData data = new UserParser.UserData();
        UserParser.parseUser(new FileInputStream("testRes/user_592617.htm"), data);
        assertNotNull(data);
        assertEquals(data.user.getName(), "ladjzero");
        assertEquals(data.user.getId(), 592617);
        assertTrue(data.success);
    }
} 
