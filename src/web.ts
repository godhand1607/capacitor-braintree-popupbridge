import { WebPlugin } from '@capacitor/core';

import type { BraintreePopupbridgePlugin } from './definitions';

export class BraintreePopupbridgeWeb
  extends WebPlugin
  implements BraintreePopupbridgePlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
