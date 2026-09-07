import crypto from 'crypto';

export const TestData = {
  /**
   * Generates a unique email per test run to avoid conflicts on shared environments.
   */
  uniqueEmail(): string {
    const id = crypto.randomBytes(4).toString('hex');
    return `testuser.${id}@qaportfolio.dev`;
  },

  users: {
    valid: {
      email: 'test@qaportfolio.dev',
      password: 'Test@1234',
    },
    invalid: {
      email: 'wrong@email.com',
      password: 'wrongpassword',
    },
  },

  products: {
    searchTerms: ['dress', 'top', 'jeans'],
  },
};
