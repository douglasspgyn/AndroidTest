package douglasspgyn.com.github.androidtest;

import org.junit.Before;
import org.junit.Test;

import douglasspgyn.com.github.androidtest.ui.unitconverter.UnitConverterActivity;

import static org.junit.Assert.assertEquals;

/**
 * Created by Douglas on 29/03/17.
 */

public class UnitConverterUnitTest {
    private UnitConverterActivity unitConverterActivity;

    @Before
    public void setUp() throws Exception {
        unitConverterActivity = new UnitConverterActivity();
    }

    @Test
    public void convertToCIntegerNegative() throws Exception {
        assertEquals("Expected Value", unitConverterActivity.convertToC(0), -18, 0.5);
    }

    @Test
    public void convertToCIntegerZero() throws Exception {
        assertEquals("Expected Value", unitConverterActivity.convertToC(32), 0, 0.5);
    }

    @Test
    public void convertToCIntegerMed() throws Exception {
        assertEquals("Expected Value", unitConverterActivity.convertToC(50), 10, 0.5);
    }

    @Test
    public void convertToCIntegerHigh() throws Exception {
        assertEquals("Expected Value", unitConverterActivity.convertToC(104), 40, 0.5);
    }

    @Test
    public void convertToFIntegerNegative() throws Exception {
        assertEquals("Expected Value", unitConverterActivity.convertToF(-20), -4, 0.5);
    }

    @Test
    public void convertToFIntegerZero() throws Exception {
        assertEquals("Expected Value", unitConverterActivity.convertToF(-18), 0, 0.5);
    }

    @Test
    public void convertToFIntegerMed() throws Exception {
        assertEquals("Expected Value", unitConverterActivity.convertToF(50), 122, 0.5);
    }

    @Test
    public void convertToFIntegerHigh() throws Exception {
        assertEquals("Expected Value", unitConverterActivity.convertToF(150), 302, 0.5);
    }
}
