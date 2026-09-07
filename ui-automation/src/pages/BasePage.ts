import { Page, Locator, expect } from '@playwright/test';

/**
 * Base page class — all Page Objects extend this.
 * Centralises common actions so test code stays declarative.
 */
export abstract class BasePage {
  constructor(protected readonly page: Page) {}

  async navigate(path: string = '/'): Promise<void> {
    await this.page.goto(path);
    await this.page.waitForLoadState('networkidle');
  }

  async getTitle(): Promise<string> {
    return this.page.title();
  }

  async waitForElement(locator: Locator, timeout = 10_000): Promise<void> {
    await locator.waitFor({ state: 'visible', timeout });
  }

  async clickAndWait(locator: Locator): Promise<void> {
    await locator.click();
    await this.page.waitForLoadState('networkidle');
  }

  async fillField(locator: Locator, value: string): Promise<void> {
    await locator.clear();
    await locator.fill(value);
  }

  async assertVisible(locator: Locator): Promise<void> {
    await expect(locator).toBeVisible();
  }

  async assertText(locator: Locator, text: string): Promise<void> {
    await expect(locator).toContainText(text);
  }

  async assertURL(pattern: string | RegExp): Promise<void> {
    await expect(this.page).toHaveURL(pattern);
  }
}
