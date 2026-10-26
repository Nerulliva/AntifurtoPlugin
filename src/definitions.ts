export interface AntifurtoPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  sendMessage(options: MessageOptions):Promise<{result: boolean | null}>;
}


export interface MessageOptions{
  phoneNumber: string;
  message: string;
}