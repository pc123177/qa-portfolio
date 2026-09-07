# QA Automation Portfolio

A QA automation portfolio demonstrating end-to-end testing capabilities across web UI and REST API layers.

## Modules

| Module | Stack | Target |
|--------|-------|--------|
| [ui-automation](./ui-automation) | Playwright + TypeScript | Web UI testing |
| [api-testing](./api-testing) | REST Assured + Java | REST API testing |

## About

Built by **Paulo Matos** — SDET with 5+ years of experience in test automation, CI/CD integration, and quality engineering.

- Certified: Scrum, Six Sigma Yellow Belt, Kobiton Appium, Full-Stack QA
- Stack: Java, JavaScript/TypeScript, Selenium, Playwright, REST Assured, Appium, Cypress

## Architecture

```
qa-portfolio/
├── ui-automation/        # Playwright + TypeScript (Page Object Model)
│   ├── src/
│   │   ├── pages/        # Page Object classes
│   │   ├── tests/        # Test specs
│   │   └── helpers/      # Utilities and fixtures
│   └── playwright.config.ts
│
└── api-testing/          # REST Assured + Java (Maven)
    ├── src/
    │   ├── main/java/    # Models and utilities
    │   └── test/java/    # Test classes
    └── pom.xml
```

## CI/CD

All modules run automatically on every push and pull request via GitHub Actions.

[![UI Tests](https://github.com/pc123177/qa-portfolio/actions/workflows/ui-tests.yml/badge.svg)](https://github.com/pc123177/qa-portfolio/actions/workflows/ui-tests.yml)
[![API Tests](https://github.com/pc123177/qa-portfolio/actions/workflows/api-tests.yml/badge.svg)](https://github.com/pc123177/qa-portfolio/actions/workflows/api-tests.yml)

## Running Locally

```bash
# UI
cd ui-automation && npm install && npx playwright test

# API
cd api-testing && mvn test
```
