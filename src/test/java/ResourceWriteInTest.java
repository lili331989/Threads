import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import threads.Resource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ResourceWriteInTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testString() {
        Resource res=new Resource(5);
        res.createFile();
        Assert.assertTrue(res.writeIn("Поток 1"));
        String s1="Старое значение 0 Новое значение 1 Поток 1"+System.lineSeparator();
        Assert.assertEquals(s1, output.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
