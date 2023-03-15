import { registerPlugin } from '@capacitor/core';

import type { AntifurtoPlugin } from './definitions';

const Antifurto = registerPlugin<AntifurtoPlugin>('Antifurto', {
  web: () => import('./web').then(m => new m.AntifurtoWeb()),
});

export * from './definitions';
export { Antifurto };
