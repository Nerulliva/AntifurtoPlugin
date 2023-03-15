export interface AntifurtoPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
