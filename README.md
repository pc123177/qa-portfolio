# QA Automation Portfolio

A comprehensive QA automation portfolio demonstrating end-to-end testing capabilities across web, API, and mobile platforms.

## Modules

| Module | Stack | Target |
|--------|-------|--------|
| [ui-automation](./ui-automation) | Playwright + TypeScript | Web UI testing |
| [api-testing](./api-testing) | REST Assured + Java | REST API testing |
| [mobile-testing](./mobile-testing) | Appium + Java | Android mobile testing |

## About

Built by **Paulo Matos** — SDET with experience at Meta, specializing in test automation frameworks, CI/CD integration, and quality engineering at scale.

- 5+ years in QA Automation
- Ex-Meta (2023–2025)
- Certified: Scrum, Six Sigma Yellow Belt, Kobiton Appium, Full-Stack QA
- Stack: Java, JavaScript/TypeScript, Python, Selenium, Playwright, Appium, RestAssured, Cypress

## Architecture

```
qa-portfolio/
├── ui-automation/        # Playwright + TypeScript (Page Object Model)
│   ├── src/
│   │   ├── pages/        # Page Object classes
│   │   ├── tests/        # Test specs
│   │   └── helpers/      # Utilities and fixtures
│   ├── playwright.config.ts
│   └── .github/workflows/
│
├── api-testing/          # REST Assured + Java (Maven)
│   ├── src/
│   │   ├── main/java/    # Models and utilities
│   │   └── test/java/    # Test classes
│   ├── pom.xml
│   └── .github/workflows/
│
└── mobile-testing/       # Appium + Java (Maven)
    ├── src/
    │   ├── main/java/    # Page Objects, capabilities
    │   └── test/java/    # Test classes
    ├── pom.xml
    └── .github/workflows/
```

## CI/CD

All modules run automatically on every push and pull request via GitHub Actions.

[![UI Tests](https://github.com/YOUR_USERNAME/qa-portfolio/actions/workflows/ui-tests.yml/badge.svg)](https://github.com/YOUR_USERNAME/qa-portfolio/actions)
[![API Tests](https://github.com/YOUR_USERNAME/qa-portfolio/actions/workflows/api-tests.yml/badge.svg)](https://github.com/YOUR_USERNAME/qa-portfolio/actions)
[![Mobile Tests](https://github.com/YOUR_USERNAME/qa-portfolio/actions/workflows/mobile-tests.yml/badge.svg)](https://github.com/YOUR_USERNAME/qa-portfolio/actions)

## Running Locally

```bash
# UI
cd ui-automation && npm install && npx playwright test

# API
cd api-testing && mvn test

# Mobile (requires Android emulator + Appium server)
cd mobile-testing && mvn test
```
