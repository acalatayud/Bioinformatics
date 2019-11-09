package ar.edu.itba.bio;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.File;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        //assertTrue(GenBankTranslator.translate(new File("./sequence.gb"), "o"));
        //assertTrue(BlastReporter.execute(new File("./o.fas"), "o2"));
        assertTrue(BlastHitParser.getHits(new File("o2_NM_183416 - FRAME TWO.out"), "homo", true));
    }
}
