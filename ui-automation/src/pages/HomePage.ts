import { Page, Locator } from '@playwright/test';
import { BasePage } from './BasePage';

export class HomePage extends BasePage {
  readonly signupLoginLink: Locator;
  readonly productsLink: Locator;
  readonly cartLink: Locator;
  readonly searchInput: Locator;
  readonly searchButton: Locator;

  constructor(page: Page) {
    super(page);
    this.signupLoginLink = page.getByRole('link', { name: /signup.*login/i });
    this.productsLink    = page.getByRole('link', { name: /products/i });
    this.cartLink        = page.getByRole('link', { name: /cart/i });
    this.searchInput     = page.locator('#search_product');
    this.searchButton    = page.locator('#submit_search');
  }

  async goto(): Promise<void> {
    await this.navigate('/');
  }

  async goToSignup(): Promise<void> {
    await this.clickAndWait(this.signupLoginLink);
  }

  async searchProduct(term: string): Promise<void> {
    await this.productsLink.click();
    await this.fillField(this.searchInput, term);
    await this.searchButton.click();
  }
}
