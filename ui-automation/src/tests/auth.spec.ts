import { test, expect } from '@playwright/test';
import { HomePage } from '../pages/HomePage';
import { LoginPage } from '../pages/LoginPage';
import { TestData } from '../helpers/TestData';

test.describe('Authentication', () => {
  test('login with invalid credentials shows error', async ({ page }) => {
    const home = new HomePage(page);
    const login = new LoginPage(page);

    await home.goto();
    await home.goToSignup();
    await login.login(TestData.users.invalid.email, TestData.users.invalid.password);

    await login.assertVisible(login.errorMessage);
  });

  test('signup form accepts valid name and email', async ({ page }) => {
    const home = new HomePage(page);
    const login = new LoginPage(page);

    await home.goto();
    await home.goToSignup();
    await login.startSignup('Paulo Matos', TestData.uniqueEmail());

    await login.assertURL(/signup/);
  });
});
