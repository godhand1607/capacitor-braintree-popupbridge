import { registerPlugin } from '@capacitor/core';

import type { BraintreePopupbridgePlugin } from './definitions';

const BraintreePopupbridge = registerPlugin<BraintreePopupbridgePlugin>(
  'BraintreePopupbridge',
  {
    web: () => import('./web').then(m => new m.BraintreePopupbridgeWeb()),
  },
);

export * from './definitions';
export { BraintreePopupbridge };
