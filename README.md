# @plug/antifurto-plugin

nd

## Install

```bash
npm install @plug/antifurto-plugin
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`sendMessage(...)`](#sendmessage)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### sendMessage(...)

```typescript
sendMessage(options: MessageOptions) => Promise<{ result: boolean | null; }>
```

| Param         | Type                                                      |
| ------------- | --------------------------------------------------------- |
| **`options`** | <code><a href="#messageoptions">MessageOptions</a></code> |

**Returns:** <code>Promise&lt;{ result: boolean | null; }&gt;</code>

--------------------


### Interfaces


#### MessageOptions

| Prop              | Type                |
| ----------------- | ------------------- |
| **`phoneNumber`** | <code>string</code> |
| **`message`**     | <code>string</code> |

</docgen-api>
