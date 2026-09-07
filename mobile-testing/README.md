# Mobile Testing — Appium + Java

Android UI automation for the [Wikipedia app](https://github.com/wikimedia/apps-android-wikipedia), an open-source app with stable locators — ideal for portfolio demonstrations.

## Stack

- [Appium](https://appium.io) 2.x + UIAutomator2 driver
- Java 17 + Maven
- TestNG 7.10
- Page Object Model with `AppiumFieldDecorator`
- Allure 2.29 for reporting

## Coverage

| Feature | Tests |
|---------|-------|
| Onboarding skip | skips intro screens if present |
| Search | returns results, first result has non-empty title |

## Run locally

Requirements: Android emulator running API 33, Appium server on `http://localhost:4723`, Wikipedia APK installed.

```bash
# Start Appium
appium

# Run tests (in a separate terminal)
mvn test

# Point to a specific APK instead of pre-installed app
WIKIPEDIA_APK=/path/to/wikipedia.apk mvn test
```

## CI

Uses `reactivecircus/android-emulator-runner` with KVM acceleration on Ubuntu. Downloads the APK automatically. Full end-to-end run completes in ~8 minutes.

## Design decisions

- `BasePage` initialises `AppiumFieldDecorator` so `@AndroidFindBy` elements are lazily resolved — no stale element exceptions on navigation.
- `CapabilityConfig` reads `APPIUM_URL` and `WIKIPEDIA_APK` from env so CI and local runs use the same code path without hardcoded paths.
- `@AfterMethod(alwaysRun = true)` guarantees driver quit even when a test fails, preventing emulator leaks in CI.
