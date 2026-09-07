import { test } from '@playwright/test';
import { HomePage } from '../pages/HomePage';
import { TestData } from '../helpers/TestData';

test.describe('Product Search', () => {
  for (const term of TestData.products.searchTerms) {
    test(`search for "${term}" returns results`, async ({ page }) => {
      const home = new HomePage(page);
      await home.goto();
      await home.searchProduct(term);

      await home.assertText(page.locator('h2.title'), 'Searched Products');
      // At least one product card should be visible
      await page.locator('.productinfo').first().waitFor({ state: 'visible' });
    });
  }
});
