export interface BraintreePopupbridgePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
