package formatsi;

import org.junit.Test;
import static org.junit.Assert.*;
// import static formatsi.Util.log;

public class FormatTest {

    
    /** 
     * To make this test fail, it 
     * 
     */
    @Test
    public void formatSIFailing() throws Exception {
	Format form = new Format();
	// Test failed: formatSIFailing(formatsi.FormatTest)
	assertEquals("formatSIFailing(formatsi.FormatTest)", form.formatSI(1, "N"));
    }

    @Test
    public void formatSI() throws Exception {
    	Format form = new Format();
    	// formatSI:bigger-1
    	form.formatSI(10000.0, "N");
    }

    @Test public void formatSI1() {
    	Format form = new Format();
    	// formatSI:no-fit:false
    	form.formatSI(0.000000000000000000000000000001, "N");
    }
    
    @Test public void formatSI2() {
    	Format form = new Format();
    	// formatSI:no-fit:true
    	form.formatSI(1000000000000000000000000000.0, "N");
    }

    @Test public void formatSI3() {
    	Format form = new Format();
    	// 	formatSI:no-symbol
    	form.formatSI(100.0, "N");
    }

    @Test public void formatSI4() {
    	Format form = new Format();
    	// formatSI:smaller-1
    	form.formatSI(10000.0, "N");
    }

     @Test public void formatSI5() {
    	Format form = new Format();
    	// formatSI:smaller-1
    	form.formatSI(0, "N");
    }
}
