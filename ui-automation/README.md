# UI Automation — Playwright + TypeScript

End-to-end web UI tests for [Automation Exercise](https://automationexercise.com), a public e-commerce app built for QA practice.

## Stack

- [Playwright](https://playwright.dev) 1.47
- TypeScript 5.6
- Page Object Model
- Parallel execution across Chromium and Firefox
- HTML + JUnit XML reports

## Structure

```
src/
├── pages/        # Page Object classes (BasePage, HomePage, LoginPage)
├── tests/        # Test specs (auth, search)
└── helpers/      # Test data and utilities
```

## Run locally

```bash
npm install
npx playwright install --with-deps
npx playwright test
npx playwright show-report   # open HTML report
```

## CI

Runs on every push/PR via GitHub Actions. Artifacts: HTML report (30-day retention).

## Design decisions

- `BasePage` centralises all Playwright interactions — Page Objects never call `page.*` directly, keeping tests readable and refactoring cheap.
- `TestData.uniqueEmail()` generates a random email per run to avoid conflicts on shared test environments.
- Retries set to 2 on CI to absorb transient network flakiness without hiding real failures.
