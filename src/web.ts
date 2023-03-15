import { WebPlugin } from '@capacitor/core';

import type { AntifurtoPlugin } from './definitions';

export class AntifurtoWeb extends WebPlugin implements AntifurtoPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
