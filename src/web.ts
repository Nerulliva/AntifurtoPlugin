import { WebPlugin } from '@capacitor/core';

import type { AntifurtoPlugin, MessageOptions } from './definitions';

export class AntifurtoWeb extends WebPlugin implements AntifurtoPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async sendMessage(_options: MessageOptions): Promise<{ result: boolean | null }> {
    throw this.unimplemented('sendMessage non è disponibile sul web. Esegui l\'app su un dispositivo Android.');
  }
}
