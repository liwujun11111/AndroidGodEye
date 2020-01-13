package cn.hikyson.godeye.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import cn.hikyson.godeye.core.utils.IoUtil;
import cn.hikyson.godeye.core.utils.JsonUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GodEyeConfigTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void noneConfig() {
        GodEyeConfig config = GodEyeConfig.noneConfigBuilder().build();
        assertNull(config.getAppSizeConfig());
        assertNull(config.getBatteryConfig());
        assertNull(config.getCpuConfig());
        assertNull(config.getCrashConfig());
        assertNull(config.getFpsConfig());
        assertNull(config.getHeapConfig());
        assertNull(config.getImageCanaryConfig());
        assertNull(config.getLeakConfig());
        assertNull(config.getMethodCanaryConfig());
        assertNull(config.getNetworkConfig());
        assertNull(config.getPageloadConfig());
        assertNull(config.getPssConfig());
        assertNull(config.getRamConfig());
        assertNull(config.getSmConfig());
        assertNull(config.getStartupConfig());
        assertNull(config.getThreadConfig());
        assertNull(config.getTrafficConfig());
        assertNull(config.getViewCanaryConfig());
    }

    @Test
    public void defaultConfig() {
        GodEyeConfig config = GodEyeConfig.defaultConfigBuilder().build();
        assertEquals(JsonUtil.toJson(new GodEyeConfig.AppSizeConfig()), JsonUtil.toJson(config.getAppSizeConfig()));
        assertEquals(JsonUtil.toJson(new GodEyeConfig.BatteryConfig()), JsonUtil.toJson(config.getBatteryConfig()));
        assertEquals(JsonUtil.toJson(new GodEyeConfig.CpuConfig()), JsonUtil.toJson(config.getCpuConfig()));
        assertEquals(JsonUtil.toJson(new GodEyeConfig.CrashConfig()), JsonUtil.toJson(config.getCrashConfig()));
        assertEquals(JsonUtil.toJson(new GodEyeConfig.FpsConfig()), JsonUtil.toJson(config.getFpsConfig()));
        assertEquals(JsonUtil.toJson(new GodEyeConfig.HeapConfig()), JsonUtil.toJson(config.getHeapConfig()));
        assertEquals(JsonUtil.toJson(new GodEyeConfig.ImageCanaryConfig()), JsonUtil.toJson(config.getImageCanaryConfig()));
        assertEquals(JsonUtil.toJson(new GodEyeConfig.LeakConfig()), JsonUtil.toJson(config.getLeakConfig()));
        assertEquals(JsonUtil.toJson(new GodEyeConfig.MethodCanaryConfig()), JsonUtil.toJson(config.getMethodCanaryConfig()));
        assertEquals(JsonUtil.toJson(new GodEyeConfig.NetworkConfig()), JsonUtil.toJson(config.getNetworkConfig()));
        assertEquals(JsonUtil.toJson(new GodEyeConfig.PageloadConfig()), JsonUtil.toJson(config.getPageloadConfig()));
        assertEquals(JsonUtil.toJson(new GodEyeConfig.PssConfig()), JsonUtil.toJson(config.getPssConfig()));
        assertEquals(JsonUtil.toJson(new GodEyeConfig.RamConfig()), JsonUtil.toJson(config.getRamConfig()));
        assertEquals(JsonUtil.toJson(new GodEyeConfig.SmConfig()), JsonUtil.toJson(config.getSmConfig()));
        assertEquals(JsonUtil.toJson(new GodEyeConfig.StartupConfig()), JsonUtil.toJson(config.getStartupConfig()));
        assertEquals(JsonUtil.toJson(new GodEyeConfig.ThreadConfig()), JsonUtil.toJson(config.getThreadConfig()));
        assertEquals(JsonUtil.toJson(new GodEyeConfig.TrafficConfig()), JsonUtil.toJson(config.getTrafficConfig()));
        assertEquals(JsonUtil.toJson(new GodEyeConfig.ViewCanaryConfig()), JsonUtil.toJson(config.getViewCanaryConfig()));
    }

    @Test
    public void fromInputStream() {
        InputStream is = null;
        try {
            is = getClass().getClassLoader().getResourceAsStream("install.config");
            GodEyeConfig config = GodEyeConfig.fromInputStream(is);
            assertEquals(0, config.getAppSizeConfig().delayMillis());
            assertEquals(JsonUtil.toJson(new GodEyeConfig.BatteryConfig()), JsonUtil.toJson(config.getBatteryConfig()));
            assertEquals(2000, config.getCpuConfig().intervalMillis());
            assertEquals(false, config.getCrashConfig().immediate());
            assertEquals(2000, config.getFpsConfig().intervalMillis());
            assertEquals(2000, config.getHeapConfig().intervalMillis());
            assertEquals("cn.hikyson.godeye.core.internal.modules.imagecanary.DefaultImageCanaryConfigProvider", config.getImageCanaryConfig().getImageCanaryConfigProvider());
            assertEquals(true, config.getLeakConfig().debug());
            assertEquals(true, config.getLeakConfig().debugNotification());
            assertEquals("cn.hikyson.godeye.core.internal.modules.leakdetector.DefaultLeakRefInfoProvider", config.getLeakConfig().leakRefInfoProvider());
            assertEquals(10, config.getMethodCanaryConfig().lowCostMethodThresholdMillis());
            assertEquals(300, config.getMethodCanaryConfig().maxMethodCountSingleThreadByCost());
            assertEquals(JsonUtil.toJson(new GodEyeConfig.NetworkConfig()), JsonUtil.toJson(config.getNetworkConfig()));
            assertEquals("cn.hikyson.godeye.core.internal.modules.pageload.DefaultPageInfoProvider", config.getPageloadConfig().pageInfoProvider());
            assertEquals(2000, config.getPssConfig().intervalMillis());
            assertEquals(2000, config.getRamConfig().intervalMillis());
            assertEquals(1000, config.getSmConfig().dumpInterval());
            assertEquals(500, config.getSmConfig().longBlockThreshold());
            assertEquals(500, config.getSmConfig().shortBlockThreshold());
            assertEquals(true, config.getSmConfig().debugNotification());
            assertEquals(JsonUtil.toJson(new GodEyeConfig.StartupConfig()), JsonUtil.toJson(config.getStartupConfig()));
            assertEquals(3000, config.getThreadConfig().intervalMillis());
            assertEquals("cn.hikyson.godeye.core.internal.modules.thread.ExcludeSystemThreadFilter", config.getThreadConfig().threadFilter());
            assertEquals(2000, config.getTrafficConfig().intervalMillis());
            assertEquals(1000, config.getTrafficConfig().sampleMillis());
            assertEquals(10, config.getViewCanaryConfig().maxDepth());
        } finally {
            IoUtil.closeSilently(is);
        }
    }

    @Test
    public void fromAssets() {
        when(model.nativeMethod()).thenReturn(true);
        GodEyeConfig config = GodEyeConfig.fromAssets("");
    }
}