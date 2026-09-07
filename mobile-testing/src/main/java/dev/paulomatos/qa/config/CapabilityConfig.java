package dev.paulomatos.qa.config;

import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;

public class CapabilityConfig {

    public static final String APPIUM_URL = System.getenv().getOrDefault(
            "APPIUM_URL", "http://localhost:4723");

    /**
     * Capabilities for the Android Wikipedia app.
     * APK is downloaded in CI; locally you need it installed on the emulator.
     */
    public static UiAutomator2Options androidOptions() {
        UiAutomator2Options opts = new UiAutomator2Options();
        opts.setPlatformName("Android");
        opts.setAutomationName("UiAutomator2");
        opts.setAppPackage("org.wikipedia");
        opts.setAppActivity("org.wikipedia.main.MainActivity");
        opts.setNoReset(false);
        opts.setAutoGrantPermissions(true);
        // Point to APK when running without a pre-installed app
        String apkPath = System.getenv("WIKIPEDIA_APK");
        if (apkPath != null && !apkPath.isBlank()) {
            opts.setApp(apkPath);
        }
        return opts;
    }

    public static URL appiumUrl() {
        try {
            return new URL(APPIUM_URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid APPIUM_URL: " + APPIUM_URL, e);
        }
    }
}
